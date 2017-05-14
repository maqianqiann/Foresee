package com.mrr.test.utils;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mrr.test.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/5/13.
 */

public class MyRetrofit implements RetrofitInterface {
    private Retrofit retrofit;
    //单例模式
    private static MyRetrofit myRetrofit=null;
    //私有的构造方法
    private MyRetrofit(){
    }
    //对外提供的方法
    public static MyRetrofit getIntence(){
        if(myRetrofit==null){
            //同步方法
            synchronized (MyRetrofit.class){
                if(myRetrofit==null){
                    myRetrofit=new MyRetrofit();
                }
            }

        }
        return myRetrofit;
    }


    @Override
    public Retrofit getRetrofit(String base) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(final String message) {
                //打印retrofit日志
                Log.i("RetrofitLog", "retrofitBack = " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //进行获得retrofit的对象
        OkHttpClient client=new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(base)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    @Override
    public <T> T getServer(Class<T> tClass) {
        //返回接口对象
        return retrofit.create(tClass);
    }
}
