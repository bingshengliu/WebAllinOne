import os
import shutil

# 配置
source_folder = 'eisdata_0507/data_generate(52)'  # 原始数据文件夹
target_root = 'eisdata_0507/data_generate(52)'  # 输出根目录，例如：'output/pack1', 'output/pack2', ...
cells_per_pack = 52
measurements_per_cell = 50
total_cells = 416
total_packs = (total_cells + cells_per_pack - 1) // cells_per_pack  # 向上取整

# 创建目标文件夹
for pack_num in range(1, total_packs + 1):
    pack_folder = os.path.join(target_root, f'pack{pack_num}')
    os.makedirs(pack_folder, exist_ok=True)

# 重命名并移动文件
for cell_id in range(1, total_cells + 1):
    pack_index = (cell_id - 1) // cells_per_pack + 1
    new_cell_id = (cell_id - 1) % cells_per_pack + 1  # 每组内编号从1开始
    for meas_id in range(1, measurements_per_cell + 1):
        original_name = f"{cell_id}-{meas_id}.txt"
        original_path = os.path.join(source_folder, original_name)
        if not os.path.exists(original_path):
            print(f"Warning: file {original_name} not found, skipping.")
            continue
        new_name = f"{new_cell_id}-{meas_id}.txt"
        new_path = os.path.join(target_root, f'pack{pack_index}', new_name)
        shutil.copy2(original_path, new_path)
