package utils;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by lenovo on 2017/5/15.
 * 实现接口重写里面的方法返回的对象
 */

public class MyRetrofit implements RetrofitInterface {


    @Override
    public Retrofit getRetrofit() {
        //创建对象日志拦截器
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("message",message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);

        //创建Ok的对象
        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
        //创建Retrofit的对象
   Retrofit  retrofit = new Retrofit.Builder()
             .baseUrl(Api.BASE_URL)
             .client(client)
             .addConverterFactory(GsonConverterFactory.create())
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .build();


        return retrofit;
    }
}
