package com.rxjava.test.utils;

import com.rxjava.test.bean.UserBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/5/12.
 */

public interface MyModel {
    void getDatasModel(OnRxJavaLisener onLinen) ;

    interface OnRxJavaLisener{
        void complete(ArrayList<UserBean> list);
    }
}
