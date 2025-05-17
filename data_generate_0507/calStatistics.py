import os
import json
import numpy as np
import psycopg2
from tools.dbconfig import DB_CONFIG
from tools.repo import fetch_latest_measurement_data
import matplotlib.pyplot as plt
from matplotlib.colors import to_hex
from tools.repo import fetch_latest_n_measurement_data
# 计算阻抗数据
def compute_impedance(data_from_db):
    results = {}
    all_mean_impedances = []
    all_std_impedances = []
    all_cv_impedance = []
    all_target_magnitudes = []
    all_10000Hz_magnitudes = []

    target_freq = 9.9968166
    freq_10000Hz = 10000.0

    # 先按 cell_id 整理出每个电芯的 n 次 target_magnitude
    cell_target_magnitudes_history = {}
    
    histogram = []
    for real_time_id in sorted(data_from_db.keys(), reverse=True):  # 确保时间从最近到最远
        cell_data = data_from_db[real_time_id]
        for cell_id, single_cell_data in cell_data.items():
            while len(histogram) <= cell_id:
                histogram.append([])
            frequencies = np.array(single_cell_data["frequencies"])
            real_parts = np.array(single_cell_data["real_parts"])
            imag_parts = np.array(single_cell_data["imag_parts"])

            magnitude = np.sqrt(real_parts**2 + imag_parts**2)
            
            idx_target = np.argmin(np.abs(frequencies - target_freq))

            target_real_parts = real_parts[idx_target]
            target_imag_parts = imag_parts[idx_target]
            target_magnitude = magnitude[idx_target]
            
            if cell_id not in cell_target_magnitudes_history:
                cell_target_magnitudes_history[cell_id] = []
            cell_target_magnitudes_history[cell_id].append(target_magnitude)
            histogram[cell_id].append({
                "realPart10Hz": target_real_parts,
                "imagPart10Hz": target_imag_parts,
                "timestamp": real_time_id
            })
            
    
    # 只用最近的一次数据（real_time_id最大的）做单次频率的指标
    latest_real_time_id = sorted(data_from_db.keys(), reverse=True)[0]
    latest_cell_data = data_from_db[latest_real_time_id]
    
    for cell_id, single_cell_data in latest_cell_data.items():
        frequencies = np.array(single_cell_data["frequencies"])
        real_parts = np.array(single_cell_data["real_parts"])
        imag_parts = np.array(single_cell_data["imag_parts"])
        
        magnitude = np.sqrt(real_parts**2 + imag_parts**2)
        phase_angle = np.arctan2(imag_parts, real_parts) * (180 / np.pi)

        idx_target = np.argmin(np.abs(frequencies - target_freq))
        idx_10000Hz = np.argmin(np.abs(frequencies - freq_10000Hz))

        target_magnitude_latest = magnitude[idx_target]
        target_phase_latest = phase_angle[idx_target]
        magnitude_10000Hz_latest = magnitude[idx_10000Hz]

        # 这里改成用 target_magnitudes_history 来计算均值、方差和变异系数
        target_magnitudes = cell_target_magnitudes_history.get(cell_id, [])
        
        if target_magnitudes:
            mean_impedance = np.mean(target_magnitudes)
            std_impedance = np.std(target_magnitudes)
            cv_impedance = std_impedance / mean_impedance if mean_impedance != 0 else 0
        else:
            mean_impedance = std_impedance = cv_impedance = 0

        all_mean_impedances.append(mean_impedance)
        all_std_impedances.append(std_impedance)
        all_cv_impedance.append(cv_impedance)
        all_target_magnitudes.append(target_magnitude_latest)
        all_10000Hz_magnitudes.append(magnitude_10000Hz_latest)
        
        results[f"cell_{cell_id}"] = {
            "absImpedanceMean": mean_impedance,
            "impedanceStdDev": std_impedance,
            "coefficientOfVariation": cv_impedance,
            "histogram":histogram[cell_id]
        }

    return results, all_mean_impedances, all_std_impedances, all_cv_impedance, all_target_magnitudes, all_10000Hz_magnitudes,cell_target_magnitudes_history


def num2hex(i):
    # 设置参数
    n = 101  # 颜色数量

    # 生成JET颜色映射
    jet_colormap = plt.colormaps['jet']  # 获取jet颜色映射
    values = np.linspace(0, 1, n)  # 生成101个均匀分布的点
    colors = jet_colormap(values)  # 获取对应的RGBA颜色

    # 转换为HEX颜色
    hex_colors = [to_hex(color, keep_alpha=False) for color in colors]

    hex_color = hex_colors[i]  # 获取第i个HEX颜色
    return hex_color

def compute_pack_statistics(all_mean_impedances, all_std_impedances, all_cv_impedance, all_target_magnitudes, 
                            all_10000Hz_magnitudes,cell_target_magnitudes_history,data_from_db):
    # 基本统计数据
    pack_mean_impedance = np.mean(all_mean_impedances)
    pack_std_impedance = np.mean(all_std_impedances)
    pack_cv_impedance = np.mean(all_cv_impedance)
    pack_mean_10000Hz = np.mean(all_10000Hz_magnitudes)
    pack_mean_target_freq = np.mean(all_target_magnitudes)
    
    # 计算最大最小值及对应系数
    max_impedance = max(all_mean_impedances)
    min_impedance = min(all_mean_impedances)
    
    max_std_impedance = max(all_std_impedances)
    min_std_impedance = min(all_std_impedances)
    
    max_cv_impedance = max(all_cv_impedance)
    min_cv_impedance = min(all_cv_impedance)

    range_impedance = max_impedance - min_impedance  # 数据范围
    pack_discrepancy_coefficient = pack_std_impedance / range_impedance if range_impedance != 0 else 0

    # 定义系数
    max_std_factor = 1.2  # 大于1的系数
    min_std_factor = 0.8  # 小于1的系数

    # === 计算每个电芯的颜色 ===
    mean_val = np.mean(all_target_magnitudes)
    std_val = np.std(all_target_magnitudes)

    normalized_values = []
    for value in all_target_magnitudes:
        # 归一化到0-100
        if std_val == 0:
            norm = 50  # 防止除以0，全部设为中间色
        else:
            norm = (value - (mean_val - 5 * std_val)) / (10 * std_val)
            norm = norm * 100
            norm = np.clip(norm, 0, 100)  # 限制在0到100之间

        normalized_values.append(int(round(norm)))

    # 计算对应的颜色列表
    cell_colors = [
        {"cellId": i+1, "color": num2hex(color)} 
        for i, color in enumerate(normalized_values)
    ]

    # === 计算 packHistogram ===
    pack_histogram = []

    # 按时间维度处理每个电芯的数据
    # 重新组织数据：第一维为测量点，第二维为电芯的目标幅值数据
    n_measurements = len(next(iter(cell_target_magnitudes_history.values())))  # 获取每个电芯的测量点数
    time_series_data = [[] for _ in range(n_measurements)]  # 初始化每个测量点的数据
    sorted_real_time_ids = sorted(data_from_db.keys(), reverse=True)
    # 将cell_target_magnitudes_history的电芯数据转换为时间维度为第一维，电芯为第二维的结构
    for cell_id, target_magnitudes_history in cell_target_magnitudes_history.items():
        for time_idx, target_magnitude in enumerate(target_magnitudes_history):
            time_series_data[time_idx].append(target_magnitude)

    # 对每个时间点计算统计数据
    for time_idx, time_data in enumerate(time_series_data):
        # 计算每个时间点的全局统计数据
        abs_impedance_means = np.mean(time_data)
        max_impedances = np.max(time_data)
        min_impedances = np.min(time_data)
        impedance_std_devs = np.std(time_data)

        # 获取对应时间点的 real_time_id 作为 timestamp
        timestamp = sorted_real_time_ids[time_idx] if time_idx < len(sorted_real_time_ids) else None

        # 存储统计结果，包含timestamp
        pack_histogram.append({
            "absImpedanceMean": abs_impedance_means,
            "maxAbsImpedance": max_impedances,
            "minAbsImpedance": min_impedances,
            "impedanceStdDev": impedance_std_devs,
            "timestamp": timestamp  # 添加 timestamp 字段
        })
    
    # 返回结果
    return {
        "absImpedanceMean": pack_mean_impedance,
        "impedanceStdDev": pack_std_impedance,
        "coefficientOfVariation": pack_cv_impedance,
        "impedance10000Hz": pack_mean_10000Hz,
        "impedance10Hz": pack_mean_target_freq,
        "dispersion": pack_discrepancy_coefficient,
        "pack_degradation_mode": "Normal",
        
        # 最大最小值处理
        "maxImpedanceStdDev": max_std_impedance * max_std_factor,
        "minImpedanceStdDev": min_std_impedance * min_std_factor,
        "maxAbsImpedance": max_impedance * max_std_factor,
        "minAbsImpedance": min_impedance * min_std_factor,
        "maxCoefficientOfVariation": max_cv_impedance * max_std_factor,
        "minCoefficientOfVariation": min_cv_impedance * min_std_factor,
        
        # 额外增加每个cell的颜色
        "cellColors": cell_colors,
        "packHistogram": pack_histogram
    }


# 计算跨电芯对比信息
def compute_cross_cell_comparison(results, all_mean_impedances, all_std_impedances):
    max_imp_cell = max(all_mean_impedances)
    min_imp_cell = min(all_mean_impedances)
    max_std_cell = max(all_std_impedances)
    min_std_cell = min(all_std_impedances)
    pack_mean_impedance = np.mean(all_mean_impedances)
    pack_std_impedance = np.mean(all_std_impedances)
    
    for cell_id in list(results.keys()):
        if "absImpedanceMean" not in results[cell_id] or "impedanceStdDev" not in results[cell_id]:
            continue
        
        mean_impedance = results[cell_id]["absImpedanceMean"]
        std_impedance = results[cell_id]["impedanceStdDev"]
        
        # 跨电芯对比：mean_impedance
        results[cell_id]["cross_cell"] = {
            "impedanceMeanTomaxRatio": (mean_impedance - max_imp_cell) / max_imp_cell * 100,
            "impedanceMeanToMinRatio": (mean_impedance - min_imp_cell) / min_imp_cell * 100,
            "impedanceMeanToAvgRatio": (mean_impedance - pack_mean_impedance) / pack_mean_impedance * 100,
            
            # 跨电芯对比：std_impedance
            "impedanceStdDevToMaxRatio": (std_impedance - max_std_cell) / max_std_cell * 100,
            "impedanceStdDevToMinRatio": (std_impedance - min_std_cell) / min_std_cell * 100,
            "impedanceStdDevToAvgRatio": (std_impedance - pack_std_impedance) / pack_std_impedance * 100
        }
    return results


# 主函数
def cal_Statistics(container_id,cluster_id,pack_id,n):
    data_from_db = fetch_latest_n_measurement_data(container_id,cluster_id,pack_id,n)
    results, all_mean_impedances, all_std_impedances, all_cv_impedance, all_target_magnitudes, all_10000Hz_magnitudes,cell_target_magnitudes_history = compute_impedance(data_from_db)
    
    # 计算 pack 级别统计
    pack_stats = compute_pack_statistics(all_mean_impedances, all_std_impedances,all_cv_impedance,all_target_magnitudes, 
                                         all_10000Hz_magnitudes,cell_target_magnitudes_history,data_from_db)
    
    # 计算跨电芯对比信息
    results = compute_cross_cell_comparison(results, all_mean_impedances, all_std_impedances)
    
    # 重新组织 JSON 结构，确保 pack 在顶部
    ordered_results = {"pack": pack_stats, "cells": results}
    
    output_file = "Statistics_results.json"
    json_result = json.dumps(ordered_results, indent=4,default=str)
    with open(output_file, "w", encoding="utf-8") as f:
        f.write(json_result)
    
    print(f"计算完成，结果已保存至 {output_file}")
    return ordered_results


if __name__ == "__main__":
    n = 10   #histort measurement times
    container_id = 1
    cluster_id = 1
    pack_id = 4
    cal_Statistics(container_id,cluster_id,pack_id,n)
