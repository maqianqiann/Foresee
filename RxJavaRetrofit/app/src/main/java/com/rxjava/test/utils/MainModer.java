package com.rxjava.test.utils;

import com.rxjava.test.api.Api;
import com.rxjava.test.bean.UserBean;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/5/12.
 */

public class MainModer implements MyModel {
    @Override
    public void getDatasModel(final OnRxJavaLisener onLinen) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RxJavaServer server = retrofit.create(RxJavaServer.class);

        //调起方法获得被观察者的对象
        Observable<UserBean> observable = server.getUserDatas("baiiu");
        //设置运行的线程
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<UserBean, UserBean>() {
                    @Override
                    public UserBean call(UserBean userBean) {
                        return userBean;
                    }//将被观察者订阅观察者
                }).subscribe(new Observer<UserBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserBean userBean) {

                ArrayList<UserBean> lists=new ArrayList<>();
                lists.add(userBean);
                onLinen.complete(lists);
            }
        });
    }
}
