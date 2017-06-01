package com.future.mqq.present;

import android.content.Context;

import com.future.mqq.bean.JingBean;
import com.future.mqq.bean.MyCourseBean;
import com.future.mqq.bean.OrderBean;
import com.future.mqq.model.CourseModel;
import com.future.mqq.model.MyCourseModel;
import com.future.mqq.view.CourseView;

/**
 * Created by lenovo on 2017/5/26.
 */

public class CoursePresent {
    private CourseView courseView;
    private CourseModel model;
    private Context context;
    private String object_id;

    public CoursePresent(CourseView courseView,Context context,String object_id) {
        this.courseView = courseView;
        model=new MyCourseModel();
        this.context=context;
        this.object_id=object_id;
    }
    //写个调取数据的方法
    public void getDatas(){
         model.getOnCourse(new CourseModel.OnCourseLienter() {
             @Override
             public void getListtry(MyCourseBean bean) {
                 courseView.showCourse(bean);

             }


         },context,object_id);
    }

    public void getTopDa(){
        model.getOnTopDatas(new CourseModel.OnTopLiener() {
            @Override
            public void getTop(JingBean jingBean) {
                courseView.showTop(jingBean);
            }
        },context,object_id);
    }

    public void getOrderDatas(){
        model.getOrderDatas(new CourseModel.OnOrderListener() {
            @Override
            public void getOrderSn(OrderBean orderBean) {
                courseView.showOrder(orderBean);
            }
        });
    }
}
