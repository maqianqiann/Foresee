package com.rxjava.test.view;

import com.rxjava.test.bean.UserBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/5/12.
 * 创建view视图层的接口
 */

public interface MyListView {

    void getListData(ArrayList<UserBean> list);
}
