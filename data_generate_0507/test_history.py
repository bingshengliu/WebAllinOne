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

# 处理104个电芯的所有测量数据
for cell_id in range(1, 105):  # 1 到 104
    historical_data = []
    for measure_id in range(1, 51):  # 1 到 50 次测量
        file_path = os.path.join(data_folder, f"{cell_id}-{measure_id}.txt")
        if not os.path.exists(file_path):
            print(f"警告: 文件 {file_path} 不存在，跳过该测量数据。")
            continue
        
        # 读取数据
        data = np.loadtxt(file_path)
        frequencies, real_parts, imag_parts = data[:, 0], data[:, 1], data[:, 2]
        
        # 计算阻抗幅值和相位角
        magnitude = np.sqrt(real_parts**2 + imag_parts**2)
        
        # 计算均值、标准差
        mean_impedance = np.mean(magnitude)
        std_impedance = np.std(magnitude)
        
        # 查找10 Hz 频率对应的阻抗信息
        target_freq_10Hz = 10.0
        idx_10Hz = np.argmin(np.abs(frequencies - target_freq_10Hz))
        magnitude_10Hz = magnitude[idx_10Hz]
        
        # 记录该次测量数据
        historical_data.append({
            "measurement": measure_id,
            "mean_impedance": mean_impedance,
            "std_impedance": std_impedance,
            "magnitude_10Hz": magnitude_10Hz
        })
    
    # 存储历史数据
    results[f"{cell_id}_历史数据"] = historical_data

# 保存为JSON文件
output_file = "impedance_results_history.json"
with open(output_file, "w", encoding="utf-8") as f:
    json.dump(results, f, indent=4)

print(f"计算完成，结果已保存至 {output_file}")
