import numpy as np
def prepare_data_matrices(latest_data, num_cells, num_freqs):
    real_time_ids_sorted = sorted(latest_data.keys(), reverse=True)  # 时间从最近到最远
    n = len(real_time_ids_sorted)

    re_all = np.zeros((num_cells, n, num_freqs))
    im_all = np.zeros((num_cells, n, num_freqs))
    
    for time_idx, real_time_id in enumerate(real_time_ids_sorted):
        cell_data = latest_data[real_time_id]
        for cell_id in range(1, num_cells + 1):  # cell_id从1开始
            if cell_id in cell_data:
                real_parts = np.array(cell_data[cell_id]["real_parts"])
                imag_parts = np.array(cell_data[cell_id]["imag_parts"])
                re_all[cell_id - 1, time_idx, :] = real_parts
                im_all[cell_id - 1, time_idx, :] = imag_parts
            else:
                # 如果某个cell_id在这一组数据里缺失，默认填0
                re_all[cell_id - 1, time_idx, :] = np.zeros(num_freqs)
                im_all[cell_id - 1, time_idx, :] = np.zeros(num_freqs)
    
    return re_all, im_all
