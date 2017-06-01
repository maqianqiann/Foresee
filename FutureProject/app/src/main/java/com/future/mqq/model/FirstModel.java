package com.future.mqq.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.future.mqq.bean.FirstBean;
import com.future.mqq.present.FirstPresent;
import com.future.mqq.utils.ApiServer;
import com.future.mqq.utils.ModelUtils;
import com.future.mqq.utils.UrlConnect;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

import static android.content.Context.MODE_PRIVATE;
import static com.future.mqq.utils.ModelUtils.getDataRequestApi;

/**
 * Created by lenovo on 2017/5/31.
 */

public class FirstModel {

  FirstPresent present=null;
    public static final String UrlConnect_PUBLIC_KEY="312045ED9D036BEED16E96F3878E222ED7E58AC9";
    public static SharedPreferences sp;
    public static SharedPreferences.Editor editor;

    private Context context;
    public FirstModel(FirstPresent present,Context context) {
        this.present = present;
        this.context=context;
        sp = context.getSharedPreferences("con", MODE_PRIVATE);
        editor = sp.edit();
    }


    //建立首次握手的方法
   public void firstHand(String type,String dev_id,int ver_code,String tick ){
        //拼接字符串
        StringBuffer string=new StringBuffer();
        string.append(UrlConnect_PUBLIC_KEY)
                .append(type)
                .append(dev_id)
                .append(ver_code)
                .append(tick)
        ;
        //进行一个加密
        String md5 = ModelUtils.md5(string.toString());
        //將加密的文件變成大写
        String aCase = md5.toUpperCase();
        Log.i("xxx",aCase);

        //进行网络请求
        ApiServer server = getDataRequestApi(UrlConnect.BESE_URL);
        //调用请求的方法
        Flowable<FirstBean> flowable = server.firstHand(type, dev_id, ver_code, tick, aCase);
        //开启线程的分布
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<FirstBean>() {
                    @Override
                    public void onNext(FirstBean firstBean) {

                        //拿到AppKey和Appid
                        String key = firstBean.getData().getPrivate_key();
                        String app_key = firstBean.getData().getApp_id();
                        Log.i("xxx",key+"id"+app_key);

                        //将获得的数据保存起来
                        editor.putString(UrlConnect.PRIVATE_KEY,key);
                        editor.putString(UrlConnect.APP_KEY,app_key);
                        //记录请求
                        editor.putBoolean(UrlConnect.ISFIRSTINSTALL,true);
                        //提交
                        editor.commit();
                        present.getFirst(true);

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
