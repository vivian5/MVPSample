package com.zyt.mvpsample.biz;

import java.util.ArrayList;

/**
 * @author zhouyuting
 * @date 2018/3/7 10:50
 */

public class RequestBiziml implements RequestBiz{

    @Override
    public void requestForData(final OnRequestListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    ArrayList<String> data=new ArrayList<>();
                    for (int i=0;i<8;i++){
                        data.add("item"+i);
                    }
                    if(null!=listener){
                        listener.onSuccess(data);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
