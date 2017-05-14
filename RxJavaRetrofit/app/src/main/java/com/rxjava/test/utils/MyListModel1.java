package com.rxjava.test.utils;

import com.rxjava.test.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/12.
 */

public class MyListModel1 implements MyModel1 {
    @Override
    public void loadDatas(OnDatasLineners onDatasLineners) {
        //创建数据
        List<UserBean> list=new ArrayList<>();
        //设置数据

        //调用回调的方法
        onDatasLineners.complete(list);
    }
}
