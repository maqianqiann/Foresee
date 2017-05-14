package com.rxjava.test.utils;

import com.rxjava.test.bean.UserBean;

import java.util.List;

/**
 * Created by lenovo on 2017/5/12.
 */

public interface MyModel1 {

    //写个接口回调的方法
    void loadDatas(OnDatasLineners onDatasLineners);



    //写个内部接口
    interface OnDatasLineners{
        //回调的方法
        void complete(List<UserBean> list);


    }

}