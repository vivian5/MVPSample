package com.zyt.mvpsample.wethermvp.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zyt.mvpsample.R;
import com.zyt.mvpsample.wethermvp.presenter.WetherPresenter;

/**
 * @author zhouyuting
 * @date 2018/3/7 16:44
 */

public class WetherActivity extends Activity implements IWetherView {
    private TextView txt_info;
    private WetherPresenter mPresenter;
    private Button btn;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wether);
        initView();
    }

    private void initView() {
        txt_info = findViewById(R.id.txt_info);
        btn = findViewById(R.id.btn);
        mPresenter = new WetherPresenter(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.requestWetherInfo();
            }
        });
    }

    @Override
    public void onInfoUpdate(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txt_info.setText(info);
            }
        });
    }

    @Override
    public void showDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (null != mDialog && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
                mDialog = ProgressDialog.show(WetherActivity.this, "", "正在获取中。。。");
            }
        });
    }

    @Override
    public void hideDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (null != mDialog && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
            }
        });
    }
}
