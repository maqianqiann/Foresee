package com.mrr.test.view;

import com.mrr.test.bean.NewsBean;
import com.mrr.test.bean.UserBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/5/14.
 * 创建recycleView的view视图
 *
 */

public interface MyListView {
    //获得数据的接口
   void  showData(ArrayList<NewsBean> list);
   //获得头条的具体的数据
   void showUserData(UserBean userBean);

}
