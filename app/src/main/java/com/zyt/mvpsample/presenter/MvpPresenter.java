package com.zyt.mvpsample.presenter;

import android.os.Handler;
import android.os.Looper;

import com.zyt.mvpsample.biz.OnRequestListener;
import com.zyt.mvpsample.biz.RequestBiz;
import com.zyt.mvpsample.biz.RequestBiziml;
import com.zyt.mvpsample.view.MvpView;

import java.util.List;

/**
 * @author zhouyuting
 * @date 2018/3/7 10:44
 */

public class MvpPresenter {
    private MvpView mvpView;
    RequestBiz requestBiz;
    private Handler mHandler;

    public MvpPresenter(MvpView mvpView) {
        this.mvpView=mvpView;
        requestBiz=new RequestBiziml();
        mHandler=new Handler(Looper.getMainLooper());
    }
   public void onResume(){
       mvpView.showLoading();
       requestBiz.requestForData(new OnRequestListener() {
           @Override
           public void onSuccess(final List<String> data) {
               mHandler.post(new Runnable() {
                   @Override
                   public void run() {
                       mvpView.hideLoading();
                       mvpView.setListItem(data);
                   }
               });
           }

           @Override
           public void onFailed() {
               mvpView.showMessage("请求失败");
           }
       });
   }
   public void onItemClick(int position){
       mvpView.showMessage("点击了item "+position);
   }


}
