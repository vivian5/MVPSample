package com.zyt.mvpsample.wethermvp.presenter;

import com.zyt.mvpsample.wethermvp.model.IWetherImpl;
import com.zyt.mvpsample.wethermvp.model.IWetherModel;
import com.zyt.mvpsample.wethermvp.view.IWetherView;

/**
 * @author zhouyuting
 * @date 2018/3/7 16:00
 */

public class WetherPresenter {
    private IWetherView mView;
    private IWetherModel mModel;

    public WetherPresenter(IWetherView mView) {
        this.mView = mView;
        mModel = new IWetherImpl();
    }

    public void requestWetherInfo() {
        getNetworkInfo();
    }

    public void showDialog() {
        if (null != mView) {
            mView.showDialog();
        }
    }

    public void upDateWetherInfo(String info) {
        if (null != mView) {
            mView.onInfoUpdate(info);
        }
    }

    public void hideDialog() {
        if (null != mView) {
            mView.hideDialog();
        }
    }

    public void setInfo(String info) {
        mModel.setInfo(info);
    }

    public String getInfo() {
        return mModel.getInfo();
    }

    public void getNetworkInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                showDialog();
                try {
                    Thread.sleep(5000);
                    String info="21度，晴转多云";
                    setInfo(info);
                    upDateWetherInfo(getInfo());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    hideDialog();
                }
            }
        }).start();
    }
}
