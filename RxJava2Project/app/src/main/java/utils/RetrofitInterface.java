package utils;

import retrofit2.Retrofit;

/**
 * Created by lenovo on 2017/5/15.
 * 这是创建一个接口，调用返回的都是一个Retrofit的对象
 */

public interface RetrofitInterface {
    Retrofit getRetrofit();


}
