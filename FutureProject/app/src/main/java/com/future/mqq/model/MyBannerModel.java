package com.future.mqq.model;

import android.content.Context;
import android.util.Log;

import com.future.mqq.bean.BannerBeans;
import com.future.mqq.bean.ChoseBean;
import com.future.mqq.bean.ListTryBean;
import com.future.mqq.bean.MyTopicBean;
import com.future.mqq.utils.ApiServer;
import com.future.mqq.utils.ModelUtils;
import com.future.mqq.utils.UrlConnect;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/5/23.
 */

public class MyBannerModel implements BannerModel {

    private String appKey;
    private String privateKey;



    @Override
    public void LoadData(Context context, final OnDataLineners onDataLineners) {

        String dev_id=ModelUtils.getLocaldeviceId(context);
        int ver_code=ModelUtils.getVer_code(context);
        String tick=ModelUtils.getTick();
        appKey = ModelUtils.getAppKey(FirstModel.sp);
        privateKey = ModelUtils.getPrivateKey(FirstModel.sp);
        Log.i("xxxp",privateKey);
        Log.i("xxxver",ver_code+"");
        Log.i("xxxtick",tick+"");
        Log.i("xxxa",appKey);
        StringBuffer str=new StringBuffer();
        str.append(privateKey)
                .append(appKey)
                .append(dev_id)
                .append(ver_code)
                .append(tick)
        ;

        //进行加密处理
        String md5 = ModelUtils.md5(str.toString());
        String aCase = md5.toUpperCase();
        Log.i("xxxxxac",aCase);

        //进行拼接参数
        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        //进行获取数据
        Flowable<BannerBeans> flowable = server.getListBanner(appKey,dev_id, ver_code, tick, aCase);
        //开启线程管理
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BannerBeans>() {
                    @Override
                    public void onNext(BannerBeans bannerBeans) {
                        Log.i("xxxban",bannerBeans.toString());
                        ArrayList<BannerBeans> list=new ArrayList<BannerBeans>();
                        list.add(bannerBeans);
                        //拿到数据
                        onDataLineners.getData(list);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

         //获取免费试听列表的数据


        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(privateKey)
                .append(appKey)
                .append(dev_id)
                .append(ver_code)
                .append(tick)
                .append(10)
                .append(0);
        //进行加密处理
        String md51 = ModelUtils.md5(stringBuffer.toString());
        String sign= md51.toUpperCase();
        Log.i("xxxxxac",sign);


        //获取接口对象
        ApiServer server1 = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        Flowable<ListTryBean> flowable1 = server1.getListTry(appKey, dev_id, ver_code, tick, 10, 0, sign);
        //进行分配线程
        flowable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ListTryBean>() {
                    @Override
                    public void onNext(ListTryBean listTryBean) {
                        //拿到数据
                        onDataLineners.getListTry(listTryBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //获取接口对象
        ApiServer server2 = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        Flowable<ChoseBean> flowable2 = server2.getChoose(appKey, dev_id, ver_code, tick, 10, 0, sign);
        //进行分配线程
        flowable2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ChoseBean>() {
                    @Override
                    public void onNext(ChoseBean choseBean) {
                        onDataLineners.getChoose(choseBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        StringBuffer stringBuffer1=new StringBuffer();
        stringBuffer1.append(privateKey)
                .append(appKey)
                .append(dev_id)
                .append(ver_code)
                .append(tick)
                .append(10)
                .append(0);
        //进行加密处理
        String md52 = ModelUtils.md5(stringBuffer1.toString());
        String sign1= md52.toUpperCase();
        Log.i("xxxxxac",sign1);

        ApiServer server3 = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        Flowable<MyTopicBean> topic = server3.getTopic(appKey, dev_id, ver_code, tick, 10, 0, sign);
        topic.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<MyTopicBean>() {
                    @Override
                    public void onNext(MyTopicBean topicBean) {
                         onDataLineners.getTopic(topicBean);

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
