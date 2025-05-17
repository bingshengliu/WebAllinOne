import numpy as np
from tools.repo import fetch_latest_measurement_data
import matplotlib.pyplot as plt

import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import multivariate_normal
from tools.repo import fetch_latest_n_measurement_data
from tools.data_process import prepare_data_matrices
import json
from scipy.ndimage import gaussian_filter

def boundary_scale_out(x1, x2, n, num_points):
    """外扩尺度"""
    delta_x = x2 - x1
    x_start = x1 - n/2 * delta_x
    x_end = x2 + n/2 * delta_x
    x = np.linspace(x_start, x_end, num_points + 1)
    return x

def pdf_std_mean(re0, im0):
    stdre_time = np.var(re0, axis=1, ddof=0)
    stdim_time = np.var(im0, axis=1, ddof=0)
    meanre_time = np.mean(re0, axis=1)
    meanim_time = np.mean(im0, axis=1)

    x = boundary_scale_out(np.min(re0), np.max(re0), 2,200)
    y = boundary_scale_out(np.max(im0) - (np.max(re0) - np.min(re0)), np.max(im0), 2,100)

    X1, Y1 = np.meshgrid(x, y)
    pdfz = np.zeros(X1.shape[0] * Y1.shape[1])

    fig, ax = plt.subplots(figsize=(8, 6))

    for i in range(re0.shape[0]):  # 特征数量
        XY = np.column_stack((X1.ravel(), Y1.ravel()))
        cov = np.array([[500 * (stdre_time[i]), 0], [0, 500 * (stdim_time[i])]])
        rv = multivariate_normal([meanre_time[i], meanim_time[i]], cov)
        z = rv.pdf(XY)
        z_max = np.max(z)
        if z_max <= 1:
            continue
        z_normalized = z / z_max
        pdfz = np.maximum(pdfz, z_normalized)
        ax.plot([x * 1e6 for x in re0[i, :]], [x * 1e6 for x in im0[i, :]], 'ok', linewidth=3, markersize=8)

    pdfz = pdfz.reshape(X1.shape)
    pdfz = gaussian_filter(pdfz, sigma=5)
    X1 = X1 * 1e6
    Y1 = Y1 * 1e6
    p = ax.pcolormesh(X1, Y1, pdfz, shading='auto', cmap='jet')

    # ax.set_aspect('equal')
    # plt.colorbar(p, ax=ax)
    # plt.xlabel('Real(Z) [uOhm]')
    # plt.ylabel('Imag(Z) [uOhm]')
    # plt.title('PDF Std-Mean Map')
    # plt.show()

    return pdfz, X1, Y1


def plot_Nyqusit(container_id,cluster_id,pack_id,num_cells, num_freqs,n):
    # 读取数据
    data_from_db = fetch_latest_n_measurement_data(container_id,cluster_id,pack_id,n)
    re_all, im_all = prepare_data_matrices(data_from_db, num_cells, num_freqs)

    re_all = np.array(re_all)  # 形状: (104, 50, 101)
    im_all = np.array(im_all)

    re_all = re_all[:, :, ::-1]
    im_all = im_all[:, :, ::-1]
    # re_all = re_all[:, :, 40:]  # (104, 50, 61)
    # im_all = im_all[:, :, 40:]

    re_all = re_all.transpose(0, 2, 1)  # (104, 61, 50)
    im_all = im_all.transpose(0, 2, 1)  # (104, 61, 50)

    results = {}

    for i in range(num_cells):  # 104个电芯
    # for i in range(10):  # 104个电芯

        re = re_all[i]   # (61, 50)
        im = im_all[i]   # (61, 50)
        
        pdfz, x, y = pdf_std_mean(re, im)
        
        merged = []
        h, w = pdfz.shape
        for yi in range(h):
            for xi in range(w):
                merged.append([x[yi, xi], y[yi, xi], pdfz[yi, xi]])

        results[f'cell_{i+1}'] = {
            "nyquistPlot": {
                "metrics": [
                    {
                        "realImpedance": re[i, 0] * 1e6,  # 计算real part并乘以1e6
                        "imaginaryImpedance": im[i, 0] * 1e6  # 计算imag part并乘以1e6
                    }
                    for i in range(len(re))
                ],
                "xAxisRange": {
                    "min": np.min(x),  # 计算最小值并转换为int
                    "max": np.max(x) # 计算最大值并转换为int
                },
                "yAxisRange": {
                    "min": np.min(y),  # 计算最小值并转换为int
                    "max": np.max(y) # 计算最大值并转换为int
                },
                "heatMap": merged
        }
}


    # 转成JSON字符串
    json_result = json.dumps(results, indent=4)

    # 写入文件
    output_file = "nyquist_results.json"
    with open(output_file, "w", encoding="utf-8") as f:
        f.write(json_result)

    print(f"计算完成，结果已保存至 {output_file}")

    return results

    

if __name__ == "__main__":
    num_cells = 104
    num_freqs = 101
    #hitory times
    n = 50
    container_id = 1
    cluster_id = 1
    pack_id = 1
    json_result = plot_Nyqusit(container_id,cluster_id,pack_id,num_cells,num_freqs,n)