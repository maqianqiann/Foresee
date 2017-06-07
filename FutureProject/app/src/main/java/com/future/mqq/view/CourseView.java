package com.future.mqq.view;

import com.future.mqq.bean.JingBean;
import com.future.mqq.bean.MyCourseBean;
import com.future.mqq.bean.OrderBean;

/**
 * Created by lenovo on 2017/5/26.
 * 获得的是课程订单的的View
 * 以及课程的信息
 */

public interface CourseView {


    void showCourse(MyCourseBean bean);
    void showTop(JingBean bean);
    void showOrder(OrderBean orderBean);
}
