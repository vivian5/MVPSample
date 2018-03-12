package com.zyt.mvpsample.wethermvp.view;

/**
 * @author zhouyuting
 * @date 2018/3/7 15:53
 */

public interface IWetherView {
    public void onInfoUpdate(String info);

    public void showDialog();

    public void hideDialog();
}
