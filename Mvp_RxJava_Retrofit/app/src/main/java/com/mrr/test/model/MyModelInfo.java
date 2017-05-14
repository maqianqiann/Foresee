package com.mrr.test.model;

import com.mrr.test.api.Api;
import com.mrr.test.bean.DataInfo;
import com.mrr.test.bean.NewsBean;
import com.mrr.test.bean.UserBean;
import com.mrr.test.utils.ApiServer;
import com.mrr.test.utils.MyRetrofit;

import java.util.ArrayList;

import io.reactivex.Flowable;
import retrofit2.Retrofit;

/**
 * Created by lenovo on 2017/5/13.
 */

public class MyModelInfo implements MyModel {
    @Override
    public Flowable getDatas(String name) {
         //创建被观察的对象
        Flowable<DataInfo> flowable = MyRetrofit.getIntence().getRetrofit(Api.BASE_URL).create(ApiServer.class).getDataInfo(name);

        return flowable;
    }

    @Override
    public Flowable<ArrayList<NewsBean>> getNewsDatas(String square, String retrofit) {
        //获得
        Retrofit retrofit1 = MyRetrofit.getIntence().getRetrofit(Api.BASE_URL);
        Flowable<ArrayList<NewsBean>> flowable = MyRetrofit.getIntence().getServer(ApiServer.class).getNewsData(square, retrofit);
        return flowable;
    }

    @Override
    public Flowable<UserBean> getUsersDatas() {
        //获得Retrofit的对象
        Retrofit retrofit = MyRetrofit.getIntence().getRetrofit(Api.BASE_PATH);
        Flowable<UserBean> flowable = MyRetrofit.getIntence().getServer(ApiServer.class).getUserData();
        return flowable;
    }
}
