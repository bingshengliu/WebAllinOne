import json
from calCorrelation import calculate_correlation
from calStatistics import cal_Statistics
from calDRTandECM import cal_DRTandECM
from plotNyquist import plot_Nyqusit
from plot_Bode import compute_bode_phase
import os
def load_json(file_path):
    """
    从文件中加载JSON数据
    """
    with open(file_path, 'r') as file:
        data = json.load(file)
    return data

def save_json(data, file_path):
    """
    将数据保存为JSON文件
    """
    with open(file_path, 'w') as file:
        json.dump(data, file, indent=4)

def process_statistics_data(file_path, cell_index):
    """
    对Statistics_results.json的数据进行处理，转换为新的格式
    :param file_path: JSON文件路径
    :param cell_index: cell的索引（从1开始）
    :return: 新格式的数据字典
    """
    data = load_json(file_path)
    
    # 生成cell_id，格式为cell_1, cell_2, ...
    cell_id = f"cell_{cell_index+1}"
    
    # 检查是否存在指定的cell
    if cell_id not in data["cells"]:
        print(f"cell_{cell_index} 不存在！")
        return None
    
    # 提取需要的数据
    metrics = {}
    
    # 从pack中提取数据
    metrics["maxAbsImpedance"] = data["pack"]["maxAbsImpedance"]
    metrics["minCoefficientOfVariation"] = data["pack"]["minCoefficientOfVariation"]
    metrics["minAbsImpedance"] = data["pack"]["minAbsImpedance"]
        # 从pack中提取其他数据
    metrics["minImpedanceStdDev"] = data["pack"]["minImpedanceStdDev"]
    metrics["maxCoefficientOfVariation"] = data["pack"]["maxCoefficientOfVariation"]
    metrics["maxImpedanceStdDev"] = data["pack"]["maxImpedanceStdDev"]
    
    # 提取指定cell的数据
    metrics["impedanceStdDevToMinRatio"] = data["cells"][cell_id]["cross_cell"]["impedanceStdDevToMinRatio"]
    metrics["impedanceMeanToAvgRatio"] = data["cells"][cell_id]["cross_cell"]["impedanceMeanToAvgRatio"]
    metrics["impedanceMeanToMaxRatio"] = data["cells"][cell_id]["cross_cell"]["impedanceMeanTomaxRatio"]
    metrics["impedanceStdDevToMaxRatio"] = data["cells"][cell_id]["cross_cell"]["impedanceStdDevToMaxRatio"]
    metrics["impedanceStdDevToAvgRatio"] = data["cells"][cell_id]["cross_cell"]["impedanceStdDevToAvgRatio"]
    metrics["impedanceMeanToMinRatio"] = data["cells"][cell_id]["cross_cell"]["impedanceMeanToMinRatio"]
    


    metrics["absImpedanceMean"] = data["cells"][cell_id]["absImpedanceMean"]
    metrics["impedanceStdDev"] = data["cells"][cell_id]["impedanceStdDev"]
    metrics["coefficientOfVariation"] = data["cells"][cell_id]["coefficientOfVariation"]

    metrics["coefficientOfVariation"] = data["cells"][cell_id]["coefficientOfVariation"]
    
    histogram = data["cells"][cell_id]["histogram"]

    drt_and_ecm_file_path = 'DRTandECM_results.json'
    # 加载 DRTandECM_results.json 数据
    drt_and_ecm_data = load_json(drt_and_ecm_file_path)

    # 提取 equivalentCircuitDiagram 中的 r0
    r0_value = drt_and_ecm_data[cell_id]["equivalentCircuitDiagram"].get("r0", 0)  # 默认值为 0

    # 将 r0 添加到 histogram 中
    for entry in histogram:
        entry["r0"] = r0_value  # 将 r0 加入每个时间点的数据
    
    return {"metrics": metrics,"histogram":histogram}
    # return {"metrics": metrics}

def extract_cell_data(files, cell_index):
    """
    从多个JSON文件中提取指定cell的数据并合并
    :param files: 四个JSON文件的路径
    :param cell_index: 指定的cell索引（从0开始）
    :return: 合并后的cell数据字典
    """
    cell_data = {}

    for file_path in files:
        # 加载每个JSON文件的数据
        if file_path == 'Statistics_results.json':
            data = process_statistics_data(file_path,cell_index=cell_index)
            cell_data.update(data) 
        elif file_path == 'Correlation_results.json':
            # 根据cell_index选择相应模块的相关性矩阵
            module_index = cell_index // 13  # 每13个电芯一个模块
            correlation_results = load_json(file_path)
            module_data = correlation_results["modules"][module_index]

            # 更新 cell_data 只包含 realPartCorrelation 和 imagPartCorrelation
            cell_data["realPartCorrelation"] = module_data["realPartCorrelation"]
            cell_data["imagPartCorrelation"] = module_data["imagPartCorrelation"]
        else:
            data = load_json(file_path)
            if 0 <= cell_index < len(data):
                cell_data.update(data[f"cell_{cell_index + 1}"])  # 合并数据，不使用文件名作为key
            else:
                print(f"文件 {file_path} 中没有找到该cell，索引超出范围。")

    return cell_data


if __name__ == "__main__":
# 设置文件路径
    # files = [
    #     'Bode_results.json',
    #     'nyquist_results.json',
    #     'DRTandECM_results.json',
    #     'Statistics_results.json',
    #     'Correlation_results.json'
    # ]


    # for cell_index in range(10):
    # # 提取数据
    #     merged_data = extract_cell_data(files, cell_index)

    # # 保存合并后的数据为新JSON文件
    #     save_json(merged_data, f"./testdata/merged_cell_{cell_index + 1}.json")

    #     print(f"Cell数据已经合并并保存为 merged_cell_{cell_index + 1}.json")

    

    # 基本参数
    num_cells = 104
    num_modules = 8
    num_freqs = 51
    n = 10
    freq_index = 31
    container_id = 1
    cluster_id = 1
    group_id = 1
    total_packs = 4

    for pack_id in range(1, total_packs + 1):
        print(f"==== 正在处理 pack {pack_id} ====")

        # 执行计算
        bode_data = compute_bode_phase(container_id, cluster_id, pack_id)
        nyquist_data = plot_Nyqusit(container_id, cluster_id, pack_id, num_cells, num_freqs, n)
        drt_data = cal_DRTandECM(container_id, cluster_id, pack_id)
        stat_data = cal_Statistics(container_id, cluster_id, pack_id, n)
        corr_data = calculate_correlation(container_id, cluster_id, pack_id, num_cells, num_modules, num_freqs, n, freq_index)

        # 保存为临时文件（文件名必须固定匹配 extract_cell_data 中的判断）
        save_json(stat_data, 'Statistics_results.json')
        save_json(corr_data, 'Correlation_results.json')
        save_json(bode_data, 'Bode_results.json')
        save_json(nyquist_data, 'Nyquist_results.json')
        save_json(drt_data, 'DRT_results.json')

        files = ['Statistics_results.json', 'Correlation_results.json',
                'Bode_results.json', 'Nyquist_results.json', 'DRT_results.json']

        # 输出目录
        output_dir = f"./testdata/pack{pack_id}"
        os.makedirs(output_dir, exist_ok=True)

        # 遍历电芯合并并保存
        for cell_index in range(num_cells):
            merged_data = extract_cell_data(files, cell_index)
            output_path = os.path.join(output_dir, f"merged_cell_{cell_index + 1}.json")
            save_json(merged_data, output_path)
            print(f"✅ pack{pack_id} 的 cell {cell_index + 1} 已保存：{output_path}")


