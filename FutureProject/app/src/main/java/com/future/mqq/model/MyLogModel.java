package com.future.mqq.model;

import android.content.Context;
import android.util.Log;

import com.future.mqq.bean.CodeBean;
import com.future.mqq.bean.LogBean;
import com.future.mqq.bean.SessionBean;
import com.future.mqq.utils.ApiServer;
import com.future.mqq.utils.ModelUtils;
import com.future.mqq.utils.UrlConnect;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/5/27.
 */

public class MyLogModel implements LogModel {
    @Override
    public void getRegistData(final OnRegistListener onRegistListener, Context context, String mobile) {
        //进行注册
        //获得接口的对象

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
                .append(mobile)

        ;
        //生成签名
        String md5 = ModelUtils.md5(stringBuffer.toString());
        String sign = md5.toUpperCase();
        Log.i("signmm",sign);


        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        Flowable<SessionBean> flowable = server.getRegist(appKey, dev_id, ver_code, tick, mobile, sign);
        //开启线程的分配
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SessionBean>() {
                    @Override
                    public void onNext(SessionBean sessionBean) {
                        //session
                        Log.i("sess",sessionBean.getData().getSession());
                        onRegistListener.getRegist(sessionBean);
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
    public void getLogData(final OnLogListener onLogListener, Context context, String mobile, String pwd) {
       //进行登陆的的与后台进行交互
        String dev_id=ModelUtils.getLocaldeviceId(context);
        int ver_code=ModelUtils.getVer_code(context);
        String tick=ModelUtils.getTick();
        String  app_id = ModelUtils.getAppKey(FirstModel.sp);
        String privateKey = ModelUtils.getPrivateKey(FirstModel.sp);

        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(privateKey)
                .append(app_id)
                .append(dev_id)
                .append(ver_code)
                .append(tick)
                .append(mobile)
                .append(pwd)
        ;
        //生成签名
        String md5 = ModelUtils.md5(stringBuffer.toString());
        String sign = md5.toUpperCase();
        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        Flowable<LogBean> flowable = server.getLogDatas(app_id, dev_id, ver_code, tick, mobile, pwd, sign);
        //调去方法，进行设置线程的分布
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<LogBean>() {
                    @Override
                    public void onNext(LogBean logBean) {
                        //拿到登陆的对象，回调
                        onLogListener.geLog(logBean);

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
    public void getRegistCode(final OnRegCodeListener onRegCodeListener, Context context, String session, int rand, String passwd) {

        String dev_id=ModelUtils.getLocaldeviceId(context);
        int ver_code=ModelUtils.getVer_code(context);
        String tick=ModelUtils.getTick();
        String  app_id = ModelUtils.getAppKey(FirstModel.sp);
        String privateKey = ModelUtils.getPrivateKey(FirstModel.sp);

        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(privateKey)
                .append(app_id)
                .append(dev_id)
                .append(ver_code)
                .append(tick)
                .append(session)
                .append(rand)
                .append(passwd)



        ;

        //转换进行MD5加密算法
        String md5 = ModelUtils.md5(stringBuffer.toString());
        String sign = md5.toUpperCase();
        //进行校验验证码，并返回登陆时需要的session
        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.BASE_URL3);
        Flowable<CodeBean> flowable = server.getCode(app_id, dev_id, ver_code, tick, session, rand, passwd, sign);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CodeBean>() {
                    @Override
                    public void onNext(CodeBean codeBean) {
                          onRegCodeListener.getRegist1(codeBean);
                        //打印一下登陆获得的session和数据
                        Log.i("logsees",codeBean.getData().getSession()+"uname:"+codeBean.getData().getUname());


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
