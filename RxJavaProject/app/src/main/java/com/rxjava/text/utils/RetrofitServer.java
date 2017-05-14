package com.rxjava.text.utils;

import com.rxjava.text.bean.Guang;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/5/12.
 * 创建一个接口，用来建立请求的方式和RxJava的一个被观察者
 */

public interface RetrofitServer {

    //无参的构造方法，用的是GET的请求的方法
    //返回的是一个被观察的对象
    @GET("ads/cptj")
    Observable<Guang> getDatas();
}
