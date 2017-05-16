package model;

import bean.NewsBean;
import io.reactivex.Flowable;
import retrofit2.Retrofit;
import utils.ApiServer;
import utils.MyRetrofit;

/**
 * Created by lenovo on 2017/5/15.
 */

public class MyModelC implements MyModel {
    @Override
    public void getNewsBean() {

    }

    @Override
    public Flowable<NewsBean> getDatas(String name) {
        //去调用返回这个对象的类
        //调用方法
        MyRetrofit retrofit=new MyRetrofit();
        Retrofit retrofit1 = retrofit.getRetrofit();
        ApiServer server = retrofit1.create(ApiServer.class);
        Flowable<NewsBean> flowable = server.getFlowable(name);


        return flowable;
    }
}
