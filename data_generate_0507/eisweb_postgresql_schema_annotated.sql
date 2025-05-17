-- Active: 1743993260628@@localhost@5432@mydb
-- Active: 1743993260628@@localhost@5432@mydb@public
-- 原始结构表：container
CREATE TABLE IF NOT EXISTS container (
    container_id SERIAL PRIMARY KEY,
    location TEXT,
    description TEXT
);

-- battery_cluster
CREATE TABLE IF NOT EXISTS battery_cluster (
    cluster_id SERIAL PRIMARY KEY,
    container_id INTEGER,
    description TEXT,
    CONSTRAINT fk_cabinet_container FOREIGN KEY (container_id) REFERENCES container(container_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- battery_pack
CREATE TABLE IF NOT EXISTS battery_pack (
    pack_id SERIAL PRIMARY KEY,
    cluster_id INTEGER,
    description TEXT,
    dispersion_rate REAL,
    pack_saftety_rate REAL,
    real_time_id TEXT,
    CONSTRAINT fk_pack_cluster FOREIGN KEY (cluster_id) REFERENCES battery_cluster(cluster_id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- eis_measurement
CREATE TABLE IF NOT EXISTS eis_measurement (
    measurement_id SERIAL PRIMARY KEY,
    cell_id INTEGER,
    real_time_id TEXT,
    frequency REAL,
    real_impedance REAL,
    imag_impedance REAL,
    voltage REAL,
    container_number INTEGER,
    cluster_number INTEGER,
    pack_number INTEGER
);

CREATE INDEX IF NOT EXISTS idx_cell_id_creation_time ON eis_measurement(cell_id, real_time_id);

-- generated_info
CREATE TABLE IF NOT EXISTS generated_info (
    generated_info_id SERIAL PRIMARY KEY,
    measurement_id INTEGER,
    dispersion_rate REAL,
    temperature REAL,
    real_time_id TEXT,
    cell_id INTEGER,
    sei_rate INTEGER,
    dendrites_rate INTEGER,
    electrolyte_rate INTEGER,
    polar_rate REAL,
    conduct_rate REAL,
    CONSTRAINT fk_info_measurement FOREIGN KEY (measurement_id) REFERENCES eis_measurement(measurement_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX IF NOT EXISTS idx_info_measurement ON generated_info(measurement_id);

-- pack_statistics（新增）
CREATE TABLE IF NOT EXISTS pack_statistics (
    stat_id SERIAL PRIMARY KEY,
    container_id INTEGER,
    cluster_id INTEGER,
    pack_id INTEGER,
    real_time_id TEXT,
    abs_impedance_mean REAL,
    impedance_std REAL,
    coefficient_variation REAL,
    dispersion REAL,
    resistance_1000hz REAL,
    max_abs_impedance REAL,
    min_abs_impedance REAL,
    max_impedance_std REAL,
    min_impedance_std REAL,
    max_coefficient_variation REAL,
    min_coefficient_variation REAL,
    temperature REAL,
    status TEXT CHECK (status IN ('正常', '轻度衰退', '严重衰退')),
    suggestion TEXT,
    alert_text TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- cell_statistics（新增）
CREATE TABLE IF NOT EXISTS cell_statistics (
    stat_id SERIAL PRIMARY KEY,
    container_id INTEGER,
    cluster_id INTEGER,
    pack_id INTEGER,
    group_id INTEGER,
    cell_id INTEGER,
    real_time_id TEXT,
    abs_impedance_mean REAL,
    impedance_std REAL,
    coefficient_variation REAL,
    resistance_1000hz REAL,
    phase REAL,
    imp_mean_vs_max_pct REAL,
    imp_mean_vs_min_pct REAL,
    imp_mean_vs_avg_pct REAL,
    imp_std_vs_max_pct REAL,
    imp_std_vs_min_pct REAL,
    imp_std_vs_avg_pct REAL,
    nyquist_plot TEXT,
    bode_plot TEXT,
    drt_plot TEXT,
    imp_mean_conf_matrix TEXT,
    imp_std_conf_matrix TEXT,
    eq_circuit_data TEXT,
    long_waveform_data TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- === 字段中文注释 ===
-- pack_statistics 表字段注释
COMMENT ON COLUMN pack_statistics.stat_id IS '主键，自增编号';
COMMENT ON COLUMN pack_statistics.container_id IS '所属容器编号';
COMMENT ON COLUMN pack_statistics.cluster_id IS '所属电池集群编号';
COMMENT ON COLUMN pack_statistics.pack_id IS '所属电池包编号';
COMMENT ON COLUMN pack_statistics.real_time_id IS '对应EIS原始数据的时间戳标识';
COMMENT ON COLUMN pack_statistics.abs_impedance_mean IS '当前电池包中电池的阻抗均值（绝对值）';
COMMENT ON COLUMN pack_statistics.impedance_std IS '当前电池包中电池阻抗的标准差';
COMMENT ON COLUMN pack_statistics.coefficient_variation IS '阻抗变异系数';
COMMENT ON COLUMN pack_statistics.dispersion IS '阻抗离散度';
COMMENT ON COLUMN pack_statistics.resistance_1000hz IS '1000Hz频率下的阻抗';
COMMENT ON COLUMN pack_statistics.max_abs_impedance IS '该电池包内最大单体电池的阻抗';
COMMENT ON COLUMN pack_statistics.min_abs_impedance IS '该电池包内最小单体电池的阻抗';
COMMENT ON COLUMN pack_statistics.temperature IS '电池包的平均温度（℃）';
COMMENT ON COLUMN pack_statistics.status IS '状态分类：正常、轻度衰退、严重衰退';
COMMENT ON COLUMN pack_statistics.suggestion IS '系统生成的建议文本';
COMMENT ON COLUMN pack_statistics.alert_text IS '附加警告/提示信息';
COMMENT ON COLUMN pack_statistics.created_at IS '记录创建时间';

-- cell_statistics 表字段注释
COMMENT ON COLUMN cell_statistics.stat_id IS '主键，自增编号';
COMMENT ON COLUMN cell_statistics.container_id IS '所属容器编号';
COMMENT ON COLUMN cell_statistics.cluster_id IS '所属电池集群编号';
COMMENT ON COLUMN cell_statistics.pack_id IS '所属电池包编号';
COMMENT ON COLUMN cell_statistics.group_id IS '所在组编号';
COMMENT ON COLUMN cell_statistics.cell_id IS '电池单体编号';
COMMENT ON COLUMN cell_statistics.real_time_id IS 'EIS原始数据时间戳标识';
COMMENT ON COLUMN cell_statistics.abs_impedance_mean IS '该单体电池阻抗均值';
COMMENT ON COLUMN cell_statistics.impedance_std IS '该单体电池阻抗标准差';
COMMENT ON COLUMN cell_statistics.coefficient_variation IS '变异系数';
COMMENT ON COLUMN cell_statistics.resistance_1000hz IS '1000Hz频率下的阻抗';
COMMENT ON COLUMN cell_statistics.phase IS '相位角';
COMMENT ON COLUMN cell_statistics.imp_mean_vs_max_pct IS '阻抗均值 / 所有单体最大值的百分比';
COMMENT ON COLUMN cell_statistics.imp_mean_vs_min_pct IS '阻抗均值 / 所有单体最小值的百分比';
COMMENT ON COLUMN cell_statistics.imp_mean_vs_avg_pct IS '阻抗均值 / 所有单体均值的百分比';
COMMENT ON COLUMN cell_statistics.imp_std_vs_max_pct IS '标准差 / 所有单体最大值的百分比';
COMMENT ON COLUMN cell_statistics.imp_std_vs_min_pct IS '标准差 / 所有单体最小值的百分比';
COMMENT ON COLUMN cell_statistics.imp_std_vs_avg_pct IS '标准差 / 所有单体均值的百分比';
COMMENT ON COLUMN cell_statistics.nyquist_plot IS 'Nyquist图数据（freq, real, imag）';
COMMENT ON COLUMN cell_statistics.bode_plot IS 'Bode图数据（freq, phase）';
COMMENT ON COLUMN cell_statistics.drt_plot IS 'DRT图数据（relax_t, y_t）';
COMMENT ON COLUMN cell_statistics.imp_mean_conf_matrix IS '阻抗均值的13x13混淆矩阵';
COMMENT ON COLUMN cell_statistics.imp_std_conf_matrix IS '标准差的13x13混淆矩阵';
COMMENT ON COLUMN cell_statistics.eq_circuit_data IS '等效电路模型参数数组';
COMMENT ON COLUMN cell_statistics.long_waveform_data IS '三组10000点的大数组数据';
COMMENT ON COLUMN cell_statistics.created_at IS '记录创建时间';