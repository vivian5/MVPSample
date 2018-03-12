package com.zyt.mvpsample.wethermvp.model;

/**
 * @author zhouyuting
 * @date 2018/3/7 15:57
 */

public class IWetherImpl implements IWetherModel{
    String info;

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info=info;
    }
}
