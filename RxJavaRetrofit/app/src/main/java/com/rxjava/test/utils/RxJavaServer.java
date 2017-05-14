package com.rxjava.test.utils;

import com.rxjava.test.bean.GuangBean;
import com.rxjava.test.bean.NewsBean;
import com.rxjava.test.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by lenovo on 2017/5/12.
 * 创建一个接口，定义请求的方法，并且将被观察者创建
 */

public interface RxJavaServer {

    //没有请求参数的get请求
    //返回一个被观察者的对象
   @GET("ads/cptj")
   Observable<GuangBean> getDatas();

    //进行有参数的请求
    @GET("users/{user}")
    Observable<UserBean> getUserDatas(@Path("user") String user);

    //进行有参数的请求，最外层是个集合
    @GET("repos/{square}/{retrofit}/contributors")
    Observable<List<NewsBean>> getNewsDatas(@Path("square") String square,@Path("retrofit") String retrofit);

}
