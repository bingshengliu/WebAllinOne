import json
import psycopg2
from datetime import datetime
from calCorrelation import calculate_correlation
from calStatistics import cal_Statistics
from calDRTandECM import cal_DRTandECM
from plotNyquist import plot_Nyqusit
from plot_Bode import compute_bode_phase
from tools.dbconfig import DB_CONFIG  # 你已有的数据库配置
from testdataGenerate import load_json
def get_db_connection():
    return psycopg2.connect(**DB_CONFIG)

def insert_pack_statistics(
    container_id, cluster_id, pack_id, real_time_id, pack_data
):
    conn = get_db_connection()
    cursor = conn.cursor()

    insert_query = """
    INSERT INTO pack_statistics (
        container_id, cluster_id, pack_id, real_time_id,
        abs_impedance_mean, impedance_std, coefficient_variation,
        dispersion, impedance_10000hz, impedance_10hz,
        max_abs_impedance, min_abs_impedance,
        max_impedance_std, min_impedance_std,
        max_coefficient_variation, min_coefficient_variation,
        temperature, cellcolors, status,
        suggestion, alert_text
    ) VALUES (%s, %s, %s, %s,
              %s, %s, %s,
              %s, %s, %s,
              %s, %s,
              %s, %s,
              %s, %s,
              %s, %s, %s,
              %s, %s)
    """

    cursor.execute(insert_query, (
        container_id, cluster_id, pack_id, real_time_id,
        pack_data["absImpedanceMean"],
        pack_data["impedanceStdDev"],
        pack_data["coefficientOfVariation"],
        pack_data["dispersion"],
        pack_data["impedance10000Hz"],
        pack_data["impedance10Hz"],
        pack_data["maxAbsImpedance"],
        pack_data["minAbsImpedance"],
        pack_data["maxImpedanceStdDev"],
        pack_data["minImpedanceStdDev"],
        pack_data["maxCoefficientOfVariation"],
        pack_data["minCoefficientOfVariation"],
        None,  # temperature 示例值，如有来源可替换
        json.dumps(pack_data.get("cellColors", [])),
        pack_data.get("pack_degradation_mode", "正常"),
        None,  # suggestion placeholder
        None   # alert_text placeholder
    ))
    
    conn.commit()
    cursor.close()
    conn.close()

def insert_cell_statistics(
    container_id, cluster_id, pack_id, group_id,
    cell_id, real_time_id, metrics, real_corr, imag_corr,
    nyquist, bode, drt, circuit, real10Hz, imag10Hz
):
    conn = get_db_connection()
    cursor = conn.cursor()
    insert_query = """
        INSERT INTO cell_statistics (
            container_id, cluster_id, pack_id, group_id,
            cell_id, real_time_id,
            metrics, real_part_correlation, imag_part_correlation,
            nyquist_plot, bode_plot, drt_plot, equivalent_circuit_diagram,
            realpart10Hz, imagpart10Hz
        ) VALUES (%s, %s, %s, %s, %s, %s,
                  %s, %s, %s,
                  %s, %s, %s, %s,
                  %s, %s)
    """
    cursor.execute(insert_query, (
        container_id, cluster_id, pack_id, group_id,
        cell_id, real_time_id,
        json.dumps(metrics), json.dumps(real_corr), json.dumps(imag_corr),
        json.dumps(nyquist), json.dumps(bode), json.dumps(drt), json.dumps(circuit),
        real10Hz, imag10Hz
    ))
    conn.commit()
    cursor.close()
    conn.close()


def process_statistics_data(stat_data, cell_index):
    cell_id = f"cell_{cell_index+1}"
    metrics = {}

    metrics["maxAbsImpedance"] = stat_data["pack"]["maxAbsImpedance"]
    metrics["minCoefficientOfVariation"] = stat_data["pack"]["minCoefficientOfVariation"]
    metrics["minAbsImpedance"] = stat_data["pack"]["minAbsImpedance"]
    metrics["minImpedanceStdDev"] = stat_data["pack"]["minImpedanceStdDev"]
    metrics["maxCoefficientOfVariation"] = stat_data["pack"]["maxCoefficientOfVariation"]
    metrics["maxImpedanceStdDev"] = stat_data["pack"]["maxImpedanceStdDev"]

    cell_stat = stat_data["cells"][cell_id]
    metrics["impedanceStdDevToMinRatio"] = cell_stat["cross_cell"]["impedanceStdDevToMinRatio"]
    metrics["impedanceMeanToAvgRatio"] = cell_stat["cross_cell"]["impedanceMeanToAvgRatio"]
    metrics["impedanceMeanToMaxRatio"] = cell_stat["cross_cell"]["impedanceMeanTomaxRatio"]
    metrics["impedanceStdDevToMaxRatio"] = cell_stat["cross_cell"]["impedanceStdDevToMaxRatio"]
    metrics["impedanceStdDevToAvgRatio"] = cell_stat["cross_cell"]["impedanceStdDevToAvgRatio"]
    metrics["impedanceMeanToMinRatio"] = cell_stat["cross_cell"]["impedanceMeanToMinRatio"]
    metrics["absImpedanceMean"] = cell_stat["absImpedanceMean"]
    metrics["impedanceStdDev"] = cell_stat["impedanceStdDev"]
    metrics["coefficientOfVariation"] = cell_stat["coefficientOfVariation"]

    return metrics


def extract_and_insert_data(
    cell_index, real_time_id,
    container_id, cluster_id, pack_id,
    bode_data, nyquist_data, drt_data, stat_data, corr_data
):
    cell_id_str = f"cell_{cell_index+1}"
    module_index = cell_index // 13

    # 提取内容
    metrics = process_statistics_data(stat_data, cell_index)
    real_corr = corr_data["modules"][module_index]["realPartCorrelation"]
    imag_corr = corr_data["modules"][module_index]["imagPartCorrelation"]
    nyquist = nyquist_data[cell_id_str]
    bode = bode_data[cell_id_str]
    drt = drt_data[cell_id_str]["drtPlot"]
    circuit = drt_data[cell_id_str]["equivalentCircuitDiagram"]

    histogram = stat_data["cells"][cell_id_str].get("histogram", [])
    real10Hz = histogram[0].get("realPart10Hz", None) if histogram else None
    imag10Hz = histogram[0].get("imagPart10Hz", None) if histogram else None

    # 插入 cell 数据
    insert_cell_statistics(
        container_id, cluster_id, pack_id, module_index,
        cell_index + 1, real_time_id,
        metrics, real_corr, imag_corr,
        nyquist, bode, drt, circuit,
        real10Hz, imag10Hz
    )

    # 插入 pack 数据，仅一次
    if cell_index == 0:
        insert_pack_statistics(
            container_id, cluster_id, pack_id, real_time_id,
            stat_data["pack"]
        )


if __name__ == "__main__":
    # 配置
    num_cells = 104
    num_modules = 8
    num_freqs = 101
    n = 10
    freq_index = 60
    container_id = 1
    cluster_id = 1
    pack_id = 2
    real_time_id = datetime.now()

    # bode_data = compute_bode_phase(container_id,cluster_id,pack_id)
    # nyquist_data = plot_Nyqusit(container_id,cluster_id,pack_id,num_cells, num_freqs, n)
    # drt_data = cal_DRTandECM(container_id,cluster_id,pack_id)
    # stat_data = cal_Statistics(container_id,cluster_id,pack_id,n)
    # corr_data = calculate_correlation(container_id,cluster_id,pack_id,num_cells, num_modules, num_freqs, n, freq_index)
    
    bode_data = load_json('Bode_results.json')
    nyquist_data = load_json('nyquist_results.json')
    drt_data = load_json('DRTandECM_results.json')
    stat_data = load_json('Statistics_results.json')
    corr_data = load_json('Correlation_results.json')

    for cell_index in range(num_cells):  
        extract_and_insert_data(
            cell_index, real_time_id,
            container_id, cluster_id, pack_id,
            bode_data, nyquist_data, drt_data, stat_data, corr_data
        )
        print(f"Cell_{cell_index+1} 数据已插入数据库。")


    