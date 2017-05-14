package com.mrr.test.utils;

import io.reactivex.Flowable;
import retrofit2.Retrofit;



/**
 * Created by lenovo on 2017/5/13.
 * 这是网络请求的接口
 */

public interface RetrofitInterface {
    //网络请求需要获得一个Retrofit对象
    Retrofit getRetrofit(String base);
    //需要获得一个被观察者的对象
    <T> T getServer(Class<T> tClass);
}
