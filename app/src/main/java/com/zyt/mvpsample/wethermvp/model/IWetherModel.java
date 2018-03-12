package com.zyt.mvpsample.wethermvp.model;

/**
 * @author zhouyuting
 * @date 2018/3/7 15:40
 */

public interface IWetherModel {
    /**
     * 提供数据
     */
    public String getInfo();

    /**
     * 存储数据
     *
     * @param info
     */
    public void setInfo(String info);
}
