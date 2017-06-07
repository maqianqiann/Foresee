package com.future.mqq.model;

import android.content.Context;

import com.future.mqq.bean.JingBean;
import com.future.mqq.bean.MyCourseBean;
import com.future.mqq.bean.OrderBean;

/**
 * Created by lenovo on 2017/5/26.
 */

public interface CourseModel {

    //我的课程的信息
    void getOnCourse(OnCourseLienter onCourseLienter, Context context,String object_id);
      interface OnCourseLienter{
          void getListtry(MyCourseBean bean);


      }

    //这是精选
    void getOnTopDatas(OnTopLiener topLiener, Context context,String object_id);
    interface  OnTopLiener{
        void getTop(JingBean jingBean);
    }

    //这是订单的信息
    void getOrderDatas(OnOrderListener onOrderListener);
    interface  OnOrderListener{
        void getOrderSn(OrderBean orderBean);
    }
}
