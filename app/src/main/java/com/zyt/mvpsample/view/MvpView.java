package com.zyt.mvpsample.view;

import java.util.List;

/**
 * @author zhouyuting
 * @date 2018/3/7 10:32
 */

public interface MvpView {
    /**
     * 显示loading progress
     */
    void showLoading();

    /**
     * 隐藏loading
     */
    void hideLoading();

    /**
     * ListView初始化
     */
    void setListItem(List<String> data);

    /**
     * Toast消息
     */
    void showMessage(String message);

}
