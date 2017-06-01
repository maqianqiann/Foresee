package com.future.mqq.model;

import android.content.Context;

import com.future.mqq.bean.BannerBeans;
import com.future.mqq.bean.ChoseBean;
import com.future.mqq.bean.ListTryBean;
import com.future.mqq.bean.MyTopicBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/5/23.
 */

public interface BannerModel {


     void LoadData(Context context, OnDataLineners onDataLineners);
     //声明接口
   interface  OnDataLineners{
         //获得轮播图的数据
          void getData(ArrayList<BannerBeans> list);
         //获取免费试听的数据
         void getListTry(ListTryBean listTryBean);
         //获取精品的数据
         void getChoose(ChoseBean choseBean);

         //获取专辑的数据
         void getTopic(MyTopicBean topicBean);

     }


}
