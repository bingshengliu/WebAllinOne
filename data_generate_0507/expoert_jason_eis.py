import os
import json
import numpy as np

# 设置数据文件夹路径
data_folder = "data_generate"  # 请修改为你的txt文件所在目录

# 存储计算结果
results = {}

# 处理104个电芯的第一次测量
for cell_id in range(1, 105):  # 1 到 104
    file_path = os.path.join(data_folder, f"{cell_id}-1.txt")
    if not os.path.exists(file_path):
        print(f"警告: 文件 {file_path} 不存在，跳过该电芯。")
        continue

    # 读取数据
    data = np.loadtxt(file_path)
    frequencies = data[:, 0]
    real_parts = data[:, 1]
    imag_parts = data[:, 2]

    # 计算阻抗幅值和相位角
    magnitude = np.sqrt(real_parts**2 + imag_parts**2)
    phase_angle = np.arctan2(imag_parts, real_parts) * (180 / np.pi)  # 转换为度

    # 构造Nyquist图数据字典（真实部与虚部）
    nyquist_data = {
        "real": real_parts.tolist(),
        "imag": imag_parts.tolist()
    }

    # 构造Bode图数据字典（频率、幅值、相位）
    bode_data = {
        "frequency": frequencies.tolist(),
        "magnitude": magnitude.tolist(),
        "phase": phase_angle.tolist()
    }

    # 存储结果，加入新的图形数据字典
    results[cell_id] = {
        "nyquist": nyquist_data,
        "bode": bode_data
    }

# 保存为JSON文件
output_file = "impedance_results_eis_bode.json"
with open(output_file, "w", encoding="utf-8") as f:
    json.dump(results, f, indent=4)

print(f"计算完成，结果已保存至 {output_file}")
