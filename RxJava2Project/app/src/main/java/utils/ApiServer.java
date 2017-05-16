package utils;

import bean.NewsBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lenovo on 2017/5/15.
 * 这是网络请求方式的类，返回的是一个被观察者
 */

public interface ApiServer {

    @GET("users/{user}")
    Flowable<NewsBean> getFlowable(@Path("user") String user);

}
