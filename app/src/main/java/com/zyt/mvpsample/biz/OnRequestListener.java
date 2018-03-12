package com.zyt.mvpsample.biz;

import java.util.List;

/**
 * @author zhouyuting
 * @date 2018/3/7 10:47
 */

public interface OnRequestListener {
    void onSuccess(List<String> data);
    void onFailed();
}
