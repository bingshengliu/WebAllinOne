import numpy as np
import tools.DRT_Lasso_RL as DRT_Lasso_RL
import numpy as np
import json
import tools.ECM_para as ECM_para

import tools.EIS_features_250408 as EIS_features_250408
from tools.repo import fetch_latest_measurement_data
from itertools import islice
def cal_DRTandECM(container_id,cluster_id,pack_id):
    # 初始化结果
    all_results = {}

    raw_data = fetch_latest_measurement_data(container_id,cluster_id,pack_id)
    
    results = {}
    for cell_id, values in raw_data.items():
        print(f"Processing cell {cell_id}")
        # 取出数据
        frequencies = np.array(values["frequencies"])
        real_parts = np.array(values["real_parts"])
        imag_parts = np.array(values["imag_parts"])

        # 组织成 DRT 输入的格式
        eis_data = np.column_stack((frequencies, real_parts, imag_parts))

        # 参数设定
        coeff = 1
        lambda0 = 10 ** -6
        Reg_type = "Lasso"

        # 调用 DRT 反演
        realpart, imagpart, freq, mu_Z_re, mu_Z_im, mu_Z_re2, mu_Z_im2, freq_fine, gamma_ridge_fine, epsilon, x_ridge = DRT_Lasso_RL.main(
            eis_data,
            lambda0,
            coeff,
            Reg_type
        )

        # 目前选取的数据特征点
        Rct_num = EIS_features_250408.main(freq, mu_Z_re2, mu_Z_im2)

        R0, Rct, Cdl, W = ECM_para.ECM_para_get(x_ridge, mu_Z_re2, mu_Z_im2, Rct_num)

        # 存储结果，gamma_ridge_fine * 1e6 放大
        results[f"cell_{cell_id}"] = {
            "drtPlot": [
                {
                    "relaxT": freq_fine[i],
                    "yT": gamma_ridge_fine[i] * 1e6
                }
                for i in range(len(freq_fine))
            ],
            "equivalentCircuitDiagram": {
                "rct": Rct,
                "cdl": Cdl,
                "zw": W,
                "r0": R0
            }
        }

    json_result = json.dumps(results, indent=4)
    output_file = f"DRTandECM_results.json"
    with open(output_file, "w", encoding="utf-8") as f:
        f.write(json_result)
    
    print(f"计算完成，结果已保存至 {output_file}")
    
    return results


if __name__ == "__main__":
    container_id = 1
    cluster_id = 1
    pack_id = 1
    cal_DRTandECM(container_id,cluster_id,pack_id)  
