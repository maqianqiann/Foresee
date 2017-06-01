package com.future.mqq.view;

import com.future.mqq.bean.BannerBeans;
import com.future.mqq.bean.ChoseBean;
import com.future.mqq.bean.ListTryBean;
import com.future.mqq.bean.MyTopicBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/5/23.
 */

public interface BannerView {

    //拿到数据的方法
     void setBannerData(ArrayList<BannerBeans> list);

    //拿到免费阅读的数据
    void showListTry(ListTryBean listTryBean);

    //拿到精品的数据
    void showChoose(ChoseBean choseBean);

    void showZhuan(MyTopicBean topicBean);

}
