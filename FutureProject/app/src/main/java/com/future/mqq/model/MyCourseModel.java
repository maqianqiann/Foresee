package com.future.mqq.model;

import android.content.Context;
import android.util.Log;

import com.future.mqq.bean.JingBean;
import com.future.mqq.bean.MyCourseBean;
import com.future.mqq.bean.OrderBean;
import com.future.mqq.utils.ApiServer;
import com.future.mqq.utils.ModelUtils;
import com.future.mqq.utils.UrlConnect;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/5/26.
 */

public class MyCourseModel implements CourseModel {
    @Override
    public void getOnCourse(final OnCourseLienter onCourseLienter, Context context, String object_id) {
        String dev_id=ModelUtils.getLocaldeviceId(context);
        int ver_code=ModelUtils.getVer_code(context);
        String tick=ModelUtils.getTick();
        String  appKey = ModelUtils.getAppKey(FirstModel.sp);
        String privateKey = ModelUtils.getPrivateKey(FirstModel.sp);


        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(privateKey)
                .append(appKey)
                .append(dev_id)
                .append(ver_code)
                .append(tick)
                .append(object_id)
        ;
        //进行加密处理
        String md51 = ModelUtils.md5(stringBuffer.toString());
        String sign= md51.toUpperCase();
        Log.i("xxxxxac",sign);
        //进行网络请求
        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        Flowable<MyCourseBean> flowable = server.getCourse(appKey, dev_id, ver_code, tick, object_id, sign);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<MyCourseBean>() {
                    @Override
                    public void onNext(MyCourseBean myCourseBean) {
                         onCourseLienter.getListtry(myCourseBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getOnTopDatas(final OnTopLiener topLiener, Context context, String object_id) {

        String dev_id=ModelUtils.getLocaldeviceId(context);
        int ver_code=ModelUtils.getVer_code(context);
        String tick=ModelUtils.getTick();
        String  appKey = ModelUtils.getAppKey(FirstModel.sp);
        String privateKey = ModelUtils.getPrivateKey(FirstModel.sp);

        StringBuffer stringBuffer1=new StringBuffer();
        stringBuffer1.append(privateKey)
                .append(appKey)
                .append(dev_id)
                .append(ver_code)
                .append(tick)
                .append(object_id)
        ;
        //进行加密处理
        String md52 = ModelUtils.md5(stringBuffer1.toString());
        String sign2= md52.toUpperCase();
        Log.i("xxxxxac",sign2);
        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        Flowable<JingBean> flowable1 = server.getJing(appKey, dev_id, ver_code, tick, object_id, sign2);
        flowable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<JingBean>() {
                    @Override
                    public void onNext(JingBean jingBean) {
                        topLiener.getTop(jingBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getOrderDatas(final OnOrderListener onOrderListener) {
        //将数据传到服务器，进行第一次的交互，拿到与支付订单的信息
        //注意token的时效性，当过了时效就需要重新登录，并且后台重新提供给我们一个新的token，这个token就是客户端登录的一个标识
        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL4);
        Flowable<OrderBean> flowable = server.getOrder(465 + "", "1", "c63ef1e05ba3d494033bc79d2ce654dd", "15718812708",975, 3672, 1, "这是什么", "15718812708", 1);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<OrderBean>() {
                    @Override
                    public void onNext(OrderBean orderBean) {
                        Log.i("xxxorder",orderBean.getData().getOrder_sn()+"");
                          onOrderListener.getOrderSn(orderBean);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
