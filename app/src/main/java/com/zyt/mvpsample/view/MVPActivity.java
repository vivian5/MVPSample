package com.zyt.mvpsample.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.zyt.mvpsample.R;
import com.zyt.mvpsample.presenter.MvpPresenter;

import java.util.List;

/**
 * @author zhouyuting
 * @date 2018/3/7 11:23
 */

public class MVPActivity extends Activity implements MvpView, AdapterView.OnItemClickListener {
    private ListView mvpListView;
    private ProgressBar pb;
    MvpPresenter mvpPresenter;
    private TextView showMessageText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvpPresenter.onResume();
    }

    private void initView() {
        mvpListView = findViewById(R.id.mvp_listview);
        pb = findViewById(R.id.mvp_loading);
        showMessageText = findViewById(R.id.show_message);
        mvpPresenter = new MvpPresenter(MVPActivity.this);
        mvpListView.setOnItemClickListener(this);
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setListItem(List<String> data) {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        mvpListView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
//        showMessageText.setText(message);
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mvpPresenter.onItemClick(i);
    }
}
