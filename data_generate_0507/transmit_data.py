import requests
from datetime import datetime, timezone
import json
from pprint import pprint
from testdataGenerate import load_json
from calCorrelation import calculate_correlation
from calStatistics import cal_Statistics
from calDRTandECM import cal_DRTandECM
from plotNyquist import plot_Nyqusit
from plot_Bode import compute_bode_phase


def generate_transmit_payload(
    cell_index, real_time_id,
    container_id, cluster_id, pack_id,
    bode_data, nyquist_data, drt_data, stat_data, corr_data
):
    cell_id_str = f"cell_{cell_index+1}"
    module_index = cell_index // 13

    cell_stat = stat_data["cells"][cell_id_str]
    histogram = cell_stat.get("histogram", [])
    real10Hz = histogram[0].get("realPart10Hz", 0) if histogram else 0
    imag10Hz = histogram[0].get("imagPart10Hz", 0) if histogram else 0

    # 构造 Cell 数据
    cell_item = {
        "containerId": str(container_id),
        "clusterId": str(cluster_id),
        "packId": str(pack_id),
        "groupId": str(module_index),
        "cellId": str(cell_index + 1),
        "realTimeId": real_time_id.isoformat(),
        "absImpedanceMean": cell_stat["absImpedanceMean"],
        "impedanceStdDev": cell_stat["impedanceStdDev"],
        "coefficientOfVariation": cell_stat["coefficientOfVariation"],
        "phase": 0,  # 如有计算值可替换
        "impedanceMeanToMaxRatio": cell_stat["cross_cell"]["impedanceMeanTomaxRatio"],
        "impedanceMeanToMinRatio": cell_stat["cross_cell"]["impedanceMeanToMinRatio"],
        "impedanceMeanToAvgRatio": cell_stat["cross_cell"]["impedanceMeanToAvgRatio"],
        "impedanceStdDevToMaxRatio": cell_stat["cross_cell"]["impedanceStdDevToMaxRatio"],
        "impedanceStdDevToMinRatio": cell_stat["cross_cell"]["impedanceStdDevToMinRatio"],
        "impedanceStdDevToAvgRatio": cell_stat["cross_cell"]["impedanceStdDevToAvgRatio"],
        "bodePlot": bode_data[cell_id_str]["bodePlot"],
        "nyquistPlot": nyquist_data[cell_id_str]["nyquistPlot"],
        "DrtPlot": drt_data[cell_id_str]["drtPlot"],
        "realPartCorrelation": corr_data["modules"][module_index]["realPartCorrelation"],
        "imagPartCorrelation": corr_data["modules"][module_index]["imagPartCorrelation"],
        "equivalentCircuitDiagram": drt_data[cell_id_str]["equivalentCircuitDiagram"],
        "creationTime": real_time_id.astimezone().isoformat(),
        "realPart10Hz": real10Hz,
        "imaginaryPart10Hz": imag10Hz,
        "maxImpedanceStdDev": stat_data["pack"]["maxImpedanceStdDev"],
        "minImpedanceStdDev": stat_data["pack"]["minImpedanceStdDev"],
        "maxAbsImpedance": stat_data["pack"]["maxAbsImpedance"],
        "minAbsImpedance": stat_data["pack"]["minAbsImpedance"],
        "maxCoefficientOfVariation": stat_data["pack"]["maxCoefficientOfVariation"],
        "minCoefficientOfVariation": stat_data["pack"]["minCoefficientOfVariation"]
    }

    # 构造 Pack 数据，只构造一次（例如 cell_index == 0）
    pack_item = None
    if cell_index == 0:
        pack = stat_data["pack"]
        pack_item = {
            "containerId": str(container_id),
            "clusterId": str(cluster_id),
            "packId": str(pack_id),
            "realTimeId": real_time_id.isoformat(),
            "maxAbsImpedance": pack["maxAbsImpedance"],
            "minAbsImpedance": pack["minAbsImpedance"],
            "maxCoefficientOfVariation": pack["maxCoefficientOfVariation"],
            "minCoefficientOfVariation": pack["minCoefficientOfVariation"],
            "maxImpedanceStdDev": pack["maxImpedanceStdDev"],
            "minImpedanceStdDev": pack["minImpedanceStdDev"],
            "temperature": 0,  # 若有实际温度可替换
            "absImpedanceMean": pack["absImpedanceMean"],
            "impedanceStdDev": pack["impedanceStdDev"],
            "coefficientOfVariation": pack["coefficientOfVariation"],
            "dispersion": pack["dispersion"],
            "degradationLevel": pack.get("pack_degradation_mode", "Normal"),
            "suggestion": "",
            "alertText": "",
            "characteristicFrequencies": {
                "impedance10Hz": pack["impedance10Hz"],
                "impedance10000Hz": pack["impedance10000Hz"]
            },
            "creationTime": real_time_id.astimezone().isoformat(),
            "cellColors": pack.get("cellColors", {})
        }

    return cell_item, pack_item

if __name__ == "__main__":
    from testdataGenerate import load_json
    num_cells = 104
    num_modules = 8
    num_freqs = 51
    n = 10
    freq_index = 31
    container_id = 1
    cluster_id = 1
    group_id = 1
    pack_id = 4
    real_time_id = datetime.now()

    bode_data = compute_bode_phase(container_id,cluster_id,pack_id)
    nyquist_data = plot_Nyqusit(container_id,cluster_id,pack_id,num_cells, num_freqs, n)
    drt_data = cal_DRTandECM(container_id,cluster_id,pack_id)
    stat_data = cal_Statistics(container_id,cluster_id,pack_id,n)
    corr_data = calculate_correlation(container_id,cluster_id,pack_id,num_cells, num_modules, num_freqs, n, freq_index)
    
    # 读取文件
    # bode_data = load_json('Bode_results.json')
    # nyquist_data = load_json('nyquist_results.json')
    # drt_data = load_json('DRTandECM_results.json')
    # stat_data = load_json('Statistics_results.json')
    # corr_data = load_json('Correlation_results.json')

    cell_list = []
    pack_list = []

    for cell_index in range(num_cells):
        cell_data, pack_data = generate_transmit_payload(
            cell_index, real_time_id,
            container_id, cluster_id, pack_id,
            bode_data, nyquist_data, drt_data, stat_data, corr_data
        )
        cell_list.append(cell_data)
        if pack_data:
            pack_list.append(pack_data)

    final_payload = {
        "cellStatistics": cell_list,
        "packStatistics": pack_list
    }
    print("success imerge")

    output_file = "final_payload.json"
    json_result = json.dumps(final_payload, indent=4)
    with open(output_file, "w", encoding="utf-8") as f:
        f.write(json_result)



    # 发送 POST 请求
    # response = requests.post("http://localhost:8080/api/v1/transmitData", json=final_payload)
    response = requests.post("http://localhost:8080/api/v1/transmit-data", json=final_payload)


    if response.status_code == 201:
        print("数据已成功上传到 Java 后端！")
    else:
        print("上传失败，状态码：", response.status_code)
        print(response.text)
