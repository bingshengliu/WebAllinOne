# 主函数
import numpy as np
import psycopg2
import matplotlib.pyplot as plt
from tools.repo import fetch_latest_n_measurement_data
from tools.data_process import prepare_data_matrices
import numpy as np
import json
import matplotlib.pyplot as plt

def calculate_correlation(container_id,cluster_id,pack_id,num_cells, num_modules, num_freqs, n, freq_index):
    data_from_db = fetch_latest_n_measurement_data(container_id,cluster_id,pack_id,n)
    re_all, im_all = prepare_data_matrices(data_from_db, num_cells, num_freqs)
    
    re_all = np.array(re_all)  # (104, 50, 101)
    im_all = np.array(im_all)  # (104, 50, 101)
    
    # 取出最近n次每个电芯在freq_index频率下的实部和虚部阻抗
    data_corre = re_all[:, :, freq_index]  # (104, 50)
    data_corim = im_all[:, :, freq_index]  # (104, 50)

    # 定义结果存储
    result = {"modules": []}

    # 104个电芯，拆成8组，每组13个
    cells_per_module = num_cells // num_modules
    cells_per_module = int(cells_per_module)

    for module_idx in range(num_modules):
        start_idx = module_idx * cells_per_module
        end_idx = start_idx + cells_per_module
        
        # 取出当前模组的电芯数据
        module_data_re = data_corre[start_idx:end_idx, :]  # (13, 50)
        module_data_im = data_corim[start_idx:end_idx, :]  # (13, 50)
        
        # 计算相关系数矩阵 (13×13)
        Rre = np.corrcoef(module_data_re)
        Rim = np.corrcoef(module_data_im)

        # 归一化函数
        def normalize_to_range(mat, lower=0.9, upper=1.0):
            min_val = np.min(mat)
            max_val = np.max(mat)
            normalized = lower + (mat - min_val) * (upper - lower) / (max_val - min_val)
            return normalized

        # 归一化到 [0.9, 1]
        Rre = normalize_to_range(Rre, 0.9, 1.0)
        Rim = normalize_to_range(Rim, 0.9, 1.0)
        
        # 将相关性矩阵转化为三元组形式
        def convert_to_triplets(matrix):
            triplets = []
            num_rows, num_cols = matrix.shape
            for i in range(num_rows):
                for j in range(num_cols):
                    triplets.append([i, j, matrix[i, j]])
            return triplets
        
        # 转换为三元组格式
        real_part_triplets = convert_to_triplets(Rre)
        imag_part_triplets = convert_to_triplets(Rim)

        # 保存成 list（因为numpy array不能直接json化）
        module_result = {
            "module_id": module_idx + 1,
            "realPartCorrelation": real_part_triplets,
            "imagPartCorrelation": imag_part_triplets
        }
        
        result["modules"].append(module_result)

    # 转成JSON字符串
    json_result = json.dumps(result, indent=4)

    # 指定输出文件名
    output_file = "Correlation_results.json"

    # 写入文件
    with open(output_file, "w", encoding="utf-8") as f:
        f.write(json_result)

    print(f"计算完成，结果已保存至 {output_file}")
    
    # 返回
    return result




if __name__ == "__main__":
    num_cells = 104
    num_modules = 8
    num_freqs = 101
    #  
    n = 50
    # 选择 10 Hz (假设第 61 个频率点)
    freq_index = 60  # 第 61 个频率点（从 0 开始数）
    container_id = 1
    cluster_id = 1
    pack_id = 1
    result_corr = calculate_correlation(container_id,cluster_id,pack_id,num_cells,num_modules,num_freqs,n,freq_index)