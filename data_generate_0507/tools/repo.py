from tools.dbconfig import DB_CONFIG
import psycopg2
# 连接 PostgreSQL 数据库
def get_db_connection():
    return psycopg2.connect(**DB_CONFIG)

# 从数据库获取最近一次测量的数据
def fetch_latest_measurement_data(container_id, cluster_id, pack_id):
    conn = get_db_connection()
    cursor = conn.cursor()
    
    query = """
    SELECT cell_id, frequency, real_impedance, imaginary_impedance
    FROM eis_measurement
    WHERE container_id = %s AND cluster_id = %s AND pack_id = %s
      AND creation_time = (
        SELECT MAX(creation_time)
        FROM eis_measurement
        WHERE container_id = %s AND cluster_id = %s AND pack_id = %s
    )
    """
    
    cursor.execute(query, (container_id, cluster_id, pack_id,
                           container_id, cluster_id, pack_id))
    rows = cursor.fetchall()
    conn.close()
    
    data = {}
    for cell_id, frequency, real_impedance, imag_impedance in rows:
        if cell_id not in data:
            data[cell_id] = {"frequencies": [], "real_parts": [], "imag_parts": []}
        data[cell_id]["frequencies"].append(frequency)
        data[cell_id]["real_parts"].append(real_impedance)
        data[cell_id]["imag_parts"].append(imag_impedance)
    
    return data




def fetch_latest_n_measurement_data(container_id, cluster_id, pack_id, n):
    conn = get_db_connection()
    cursor = conn.cursor()
    
    # 1) 拿最近 N 个 distinct creation_time
    query_creation_times = """
    SELECT DISTINCT creation_time
    FROM eis_measurement
    WHERE container_id = %s AND cluster_id = %s AND pack_id = %s
    ORDER BY creation_time DESC
    LIMIT %s
    """
    cursor.execute(query_creation_times, (container_id, cluster_id, pack_id, n))
    creation_times = [row[0] for row in cursor.fetchall()]
    
    # DEBUG 日志
    print("DEBUG: 最近的 creation_times =", creation_times)
    
    if not creation_times:
        conn.close()
        raise ValueError("数据库中没有找到最近的测量数据。")
    
    # 2) 根据拿到的时间戳去拿对应行
    placeholders = ','.join(['%s'] * len(creation_times))
    query = f"""
    SELECT creation_time, cell_id, frequency, real_impedance, imaginary_impedance
    FROM eis_measurement
    WHERE container_id = %s AND cluster_id = %s AND pack_id = %s
      AND creation_time IN ({placeholders})
    ORDER BY creation_time DESC, cell_id ASC, frequency ASC
    """
    params = [container_id, cluster_id, pack_id] + creation_times
    cursor.execute(query, params)
    rows = cursor.fetchall()
    conn.close()
    
    data = {}
    for creation_time, cell_id, frequency, real_impedance, imag_impedance in rows:
        data.setdefault(creation_time, {})\
            .setdefault(cell_id, {"frequencies": [], "real_parts": [], "imag_parts": []})
        data[creation_time][cell_id]["frequencies"].append(frequency)
        data[creation_time][cell_id]["real_parts"].append(real_impedance)
        data[creation_time][cell_id]["imag_parts"].append(imag_impedance)
    
    return data




