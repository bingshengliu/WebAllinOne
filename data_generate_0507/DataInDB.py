import os
import numpy as np
import psycopg2
from datetime import datetime, timedelta
from tools.dbconfig import DB_CONFIG

import psycopg2
from datetime import datetime, timedelta
from calendar import monthrange
# 连接 PostgreSQL 数据库
def get_db_connection():
    return psycopg2.connect(**DB_CONFIG)

# 插入数据到数据库
def insert_measurement_data(data_to_insert):
    conn = get_db_connection()
    cursor = conn.cursor()
    
    insert_query = """
    INSERT INTO eis_measurement (
        cell_id, creation_time, frequency, real_impedance, imaginary_impedance,
        voltage, temperature, container_id, cluster_id, pack_id
    ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
    """
    
    cursor.executemany(insert_query, data_to_insert)
    conn.commit()
    cursor.close()
    conn.close()


def create_monthly_partitions_for_dates(real_time_ids):
    conn = get_db_connection()
    cursor = conn.cursor()

    # 收集唯一年月
    months = set()
    for rt in real_time_ids:
        dt = datetime.strptime(rt, "%Y-%m-%d %H:%M:%S")
        ym = (dt.year, dt.month)
        months.add(ym)

    for year, month in sorted(months):
        partition_name = f"eis_measurement_{year}{month:02d}"
        first_day = datetime(year, month, 1)
        last_day = datetime(year, month, monthrange(year, month)[1]) + timedelta(days=1)

        cursor.execute(f"""
            CREATE TABLE IF NOT EXISTS {partition_name}
            PARTITION OF eis_measurement
            FOR VALUES FROM (%s) TO (%s);
        """, (first_day, last_day))

    conn.commit()
    cursor.close()
    conn.close()


def process_and_insert_data(data_folder, container_number, cluster_number, pack_number, num_measurements, num_cells):
    data_to_insert = []
    start_time = datetime.now()
    real_time_ids = [
        (start_time - timedelta(days=i)).strftime("%Y-%m-%d %H:%M:%S")
        for i in range(num_measurements)
    ]

    # ✅ 自动创建按月分区
    create_monthly_partitions_for_dates(real_time_ids)

    for cell_id in range(1, num_cells + 1):
        for measure_id in range(1, num_measurements + 1):
            real_time_id = real_time_ids[measure_id - 1]
            file_path = os.path.join(data_folder, f"{cell_id}-{measure_id}.txt")
            if not os.path.exists(file_path):
                print(f"警告: 文件 {file_path} 不存在，跳过该测量数据。")
                continue

            data = np.loadtxt(file_path)
            frequencies, real_parts, imag_parts = data[:, 0], data[:, 1], data[:, 2]

            for freq, real_imp, imag_imp in zip(frequencies, real_parts, imag_parts):
                data_to_insert.append((
                    cell_id, real_time_id, freq, real_imp, imag_imp,
                    None,  # voltage
                    None,  # temperature
                    container_number, cluster_number, pack_number
                ))
                
        if len(data_to_insert) >= 5000:
            insert_measurement_data(data_to_insert)
            data_to_insert = []

    if data_to_insert:
        insert_measurement_data(data_to_insert)

    print("数据插入完成。")


# 主函数
def main():
    data_folder = "eisdata_0507/data_generate(104)/pack4" # 请修改为你的 txt 文件所在目录
    container_number = 1  # 固定值，请根据实际情况设置
    cluster_number = 1    # 固定值，请根据实际情况设置
    pack_number = 4      # 固定值，请根据实际情况设置
    num_measurements  = 50
    num_cells = 104
    process_and_insert_data(data_folder, container_number, cluster_number, pack_number,num_measurements,num_cells)

if __name__ == "__main__":
    main()
