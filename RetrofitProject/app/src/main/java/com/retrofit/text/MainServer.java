package com.retrofit.text;

import com.retrofit.text.bean.Info;
import com.retrofit.text.bean.NewsInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/5/10.
 */

public interface MainServer {

    //写个get的请求
    @GET ("toutiao/index?type=shehui&key=32b9973df2e6ee0c2bf094b61c7d7844")
    //定义个方法
    Call<NewsInfo> getDatas();

}
