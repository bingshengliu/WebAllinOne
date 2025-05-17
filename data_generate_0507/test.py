import os
import json
import numpy as np

# 设置数据文件夹路径
data_folder = "data_generate"  # 请修改为你的txt文件所在目录

# 存储计算结果
results = {}
all_mean_impedances = []
all_target_magnitudes = []
all_10000Hz_magnitudes = []

# 处理104个电芯的第一次测量
for cell_id in range(1, 105):  # 1 到 104
    file_path = os.path.join(data_folder, f"{cell_id}-1.txt")
    if not os.path.exists(file_path):
        print(f"警告: 文件 {file_path} 不存在，跳过该电芯。")
        continue
    
    # 读取数据
    data = np.loadtxt(file_path)
    frequencies, real_parts, imag_parts = data[:, 0], data[:, 1], data[:, 2]
    
    # 计算阻抗幅值和相位角
    magnitude = np.sqrt(real_parts**2 + imag_parts**2)
    phase_angle = np.arctan2(imag_parts, real_parts) * (180 / np.pi)  # 转换为度
    
    # 计算均值、标准差、变异系数
    mean_impedance = np.mean(magnitude)
    std_impedance = np.std(magnitude)
    cv_impedance = std_impedance / mean_impedance if mean_impedance != 0 else 0
    
    # 查找9.9968166 Hz和10000 Hz 频率对应的阻抗信息
    target_freq = 9.9968166
    freq_10000Hz = 10000.0
    idx_target = np.argmin(np.abs(frequencies - target_freq))
    idx_10000Hz = np.argmin(np.abs(frequencies - freq_10000Hz))
    target_magnitude = magnitude[idx_target]
    target_phase = phase_angle[idx_target]
    magnitude_10000Hz = magnitude[idx_10000Hz]
    
    # 记录所有电芯的数据
    all_mean_impedances.append(mean_impedance)
    all_target_magnitudes.append(target_magnitude)
    all_10000Hz_magnitudes.append(magnitude_10000Hz)
    
    # 存储结果
    results[cell_id] = {
        "mean_impedance": mean_impedance,
        "std_impedance": std_impedance,
        "cv_impedance": cv_impedance,
        "10Hz_freq_magnitude": target_magnitude,
        "10Hz_freq_phase": target_phase
    }

# 计算pack级别的统计信息
pack_mean_impedance = np.mean(all_mean_impedances)
pact_std_impedance = np.std(all_mean_impedances)
pack_cv_impedance = pact_std_impedance / pack_mean_impedance if pack_mean_impedance != 0 else 0
pack_mean_10000Hz = np.mean(all_10000Hz_magnitudes)
pack_mean_target_freq = np.mean(all_target_magnitudes)

# 存储pack级别的信息
results["pack"] = {
    "pack_mean_impedance": pack_mean_impedance,
    "pack_std_impedance": pact_std_impedance,
    "pack_cv_impedance": pack_cv_impedance,
    "pack_mean_10000Hz": pack_mean_10000Hz,
    "pack_mean_10Hz": pack_mean_target_freq,
    "pack_degradation_mode": "正常"
}

# 计算最大、最小阻抗电芯
max_imp_cell = max(all_mean_impedances)
min_imp_cell = min(all_mean_impedances)

# 计算跨电芯对比信息

for cell_id in range(1, 105):
    if cell_id not in results:
        continue
    mean_impedance = results[cell_id]["mean_impedance"]
    
    results[f"{cell_id}_跨单体"] = {
        "vs_max": (mean_impedance - max_imp_cell) / max_imp_cell * 100,
        "vs_min": (mean_impedance - min_imp_cell) / min_imp_cell * 100,
        "vs_pack": (mean_impedance - pack_mean_impedance) / pack_mean_impedance * 100,
    }

# 保存为JSON文件
output_file = "impedance_results.json"
with open(output_file, "w", encoding="utf-8") as f:
    json.dump(results, f, indent=4)

print(f"计算完成，结果已保存至 {output_file}")
