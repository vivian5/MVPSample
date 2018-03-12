package com.zyt.mvpsample.basemvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author zhouyuting
 * @date 2018/3/7 14:24
 */

public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends Activity {
    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }

    public abstract T initPresenter();
}
