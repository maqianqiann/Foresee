package com.future.mqq.present;

import android.content.Context;
import android.util.Log;

import com.future.mqq.bean.BannerBeans;
import com.future.mqq.bean.ChoseBean;
import com.future.mqq.bean.ListTryBean;
import com.future.mqq.bean.MyTopicBean;
import com.future.mqq.model.BannerModel;
import com.future.mqq.model.MyBannerModel;
import com.future.mqq.view.BannerView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/5/24.
 */

public class BannPresent {

    //获得View的对象和Model的对象
    private BannerView view;
    private BannerModel model;
    private Context context;

    public BannPresent(BannerView view,Context context) {
        this.view = view;
        model=new MyBannerModel();
        this.context=context;
    }
    //对外提供一个方法进行
     public void fresh(){
        model.LoadData(context, new BannerModel.OnDataLineners() {
             @Override
             public void getData(ArrayList<BannerBeans> list) {
                 Log.i("xxxlist",list.size()+"");
                 view.setBannerData(list);
             }

            @Override
            public void getListTry(ListTryBean listTryBean) {
                view.showListTry(listTryBean);
            }

            @Override
            public void getChoose(ChoseBean choseBean) {
                view.showChoose(choseBean);
            }

            @Override
            public void getTopic(MyTopicBean topicBean) {
                view.showZhuan(topicBean);
            }
        });


     }
}
