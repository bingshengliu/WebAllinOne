import numpy as np
import json
from tools.repo import fetch_latest_measurement_data
import matplotlib.pyplot as plt
def compute_bode_phase(container_id,cluster_id,pack_id):
    data_from_db = fetch_latest_measurement_data(container_id,cluster_id,pack_id)
    results = {}

    for cell_id, cell_data in data_from_db.items():
        frequencies = np.array(cell_data["frequencies"])
        real_parts = np.array(cell_data["real_parts"])
        imag_parts = np.array(cell_data["imag_parts"])

        # 计算相位角（单位：度）
        phase_angle = np.arctan2(imag_parts, real_parts) * (180 / np.pi)
        magnitude = np.sqrt(real_parts**2 + imag_parts**2)


        # --- 绘制完整Bode图 ---
        # fig, ax1 = plt.subplots(figsize=(8, 6))

        # color1 = 'tab:blue'
        # ax1.set_xlabel('Frequency (Hz)')
        # ax1.set_ylabel('Magnitude (Ohm)', color=color1)
        # ax1.semilogx(frequencies, magnitude, color=color1, marker='o', linestyle='-', label='Magnitude')
        # ax1.tick_params(axis='y', labelcolor=color1)
        # ax1.grid(True, which='both', linestyle='--')

        # # 创建右侧Y轴
        # ax2 = ax1.twinx()  
        # color2 = 'tab:red'
        # ax2.set_ylabel('Phase (Degrees)', color=color2)
        # ax2.semilogx(frequencies, phase_angle, color=color2, marker='x', linestyle='--', label='Phase')
        # ax2.tick_params(axis='y', labelcolor=color2)

        # plt.title(f'Bode Plot - Cell {cell_id}')
        # fig.tight_layout()  
        # plt.show()

        results[f"cell_{cell_id}"] = {
            "bodePlot": [
                {
                    "phase": phase_angle[i],
                    "frequency": frequencies[i],
                    "amplitude": magnitude[i]
                }
                for i in range(len(frequencies))
            ]
        }
    json_result = json.dumps(results, indent=4)
    # 写入文件
    output_file = "Bode_results.json"
    with open(output_file, "w", encoding="utf-8") as f:
        f.write(json_result)

    print(f"计算完成，结果已保存至 {output_file}")
        
    return results


if __name__ == "__main__":
    container_id = 1
    cluster_id = 1
    pack_id = 1
    results = compute_bode_phase(container_id,cluster_id,pack_id)
