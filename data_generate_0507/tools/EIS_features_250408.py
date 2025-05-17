import numpy as np


def main(freq, realdata, imagdata):
    gradient_imag = np.gradient(-imagdata, axis=0)
    Rct_num = np.zeros((1, 2))
    freq_num = np.zeros((1, 2))
    Rct_num[0, 1] = len(imagdata) - 1
    for num in range(len(imagdata) - 1):
        # 若系数为0 则认定20Hz及1Hz为标准位置
        if np.abs(freq[num + 1, 0] - 20) < np.abs(freq[int(freq_num[0, 0]), 0] - 20):
            freq_num[0, 0] = num + 1
        if np.abs(freq[num + 1, 0] - 1) < np.abs(freq[int(freq_num[0, 1]), 0] - 1):
            freq_num[0, 1] = num + 1

        if 0.1 <= freq[num, 0] <= 1000:
            # 斜率由正到负
            if gradient_imag[num, 0] >= 0 >= gradient_imag[num + 1, 0]:
                Rct_num[0, 0] = num
            elif gradient_imag[num, 0] <= 0 <= gradient_imag[num + 1, 0]:
                Rct_num[0, 1] = num

    if Rct_num[0, 0] == 0:
        Rct_num[0, 0] = freq_num[0, 0]
    if Rct_num[0, 1] == 0:
        Rct_num[0, 1] = freq_num[0, 1]

    return Rct_num
