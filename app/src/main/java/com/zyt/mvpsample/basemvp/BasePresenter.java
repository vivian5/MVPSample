package com.zyt.mvpsample.basemvp;

/**
 * @author zhouyuting
 * @date 2018/3/7 14:11
 */

public abstract class BasePresenter<T> {
    public T mView;

    /**
     * 附加
     *
     * @param mView
     */
    public void attach(T mView) {
        this.mView = mView;
    }

    /**
     * 移除
     */
    public void dettach() {
        mView = null;
    }
}
