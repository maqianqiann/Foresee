package com.mrr.test.model;


import com.mrr.test.bean.NewsBean;
import com.mrr.test.bean.UserBean;

import java.util.ArrayList;

import io.reactivex.Flowable;

/**
 * Created by lenovo on 2017/5/13.
 * 业务逻辑的层
 */

public interface MyModel {
    //定义获得数据的一个方法,返回的是一个Flawable对象
    Flowable getDatas(String name);
     //返回的也是一个Flowable对象
    Flowable<ArrayList<NewsBean>> getNewsDatas(String square,String retrofit);

    Flowable<UserBean> getUsersDatas();

}
