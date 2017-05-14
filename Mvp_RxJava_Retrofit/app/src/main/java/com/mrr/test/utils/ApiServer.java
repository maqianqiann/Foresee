package com.mrr.test.utils;

import com.mrr.test.bean.DataInfo;
import com.mrr.test.bean.NewsBean;
import com.mrr.test.bean.UserBean;

import java.util.ArrayList;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lenovo on 2017/5/13.
 * 这是请求方式的接口，返回的是个被观察者的对象
 */

public interface ApiServer {
    @GET("users/{user}")
    Flowable<DataInfo> getDataInfo(@Path("user") String user);
    @GET("repos/{square}/{retrofit}/contributors")
    Flowable<ArrayList<NewsBean>> getNewsData(@Path("square") String square,@Path("retrofit") String retrofit);

    @GET("toutiao/index?type=shehui&key=32b9973df2e6ee0c2bf094b61c7d7844")
    Flowable<UserBean> getUserData();
}
