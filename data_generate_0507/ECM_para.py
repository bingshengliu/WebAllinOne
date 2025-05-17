import numpy as np

def ECM_para_get(x_ridge, re2, im2, Rct_num):
    num1 = int(Rct_num[0,0])
    num2 = int(Rct_num[0,1])
    R0 = x_ridge[2,0]  # Python索引从0开始
    Rct = re2[num1,0] - re2[0,0]
    Cdl = max(im2[:num2,0])
    b = im2[num2:, 0]
    A = np.column_stack((re2[num2:,0], np.ones([b.size,1])))


    par, _, _, _ = np.linalg.lstsq(A, b, rcond=None)
    W = -par[0]

    return R0, Rct, Cdl, W