package com.rxjava.text;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rxjava.text.api.Api;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Observable<String> servable;
    private Observer server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_a).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //将其关联起来
                servable = getServable();
                server = getServer();
                //被观察者通过订阅与观察者练习起来
                servable.subscribe(server);
            }

        });

        //创建对象
        Person person=new Person.Builder()
                .name("小白")
                .age(19)
                .address("北京")
                .phone("2121212")
                .build();

        //调用方法
        getRetrofit();

    }



    private Observable<String> getServable() {
        Observable<String> observable =  new Observable<String>() {
            @Override
            protected void subscribeActual(Observer<? super String> observer) {
                observer.onNext("这个数据");
                observer.onNext("hello");
                observer.onNext(load());
                observer.onComplete();//这是完成

            }
        };
        return observable;
    }

    private Observer getServer() {
           return  new Observer() {
               @Override
               public void onSubscribe(Disposable d) {
                   Log.i("xxxd",d.toString());
               }

               @Override
               public void onNext(Object value) {
                   //在这里将数据传过来
                   Log.i("xxxresult",value.toString());
               }

               @Override
               public void onError(Throwable e) {
                   Log.i("xxxresult",e.getMessage());

               }
               @Override
               public void onComplete() {

               }
           };
    }

    //这是网络请求的数据
    public String  load(){
        return "json data";
    }

    @Override
    protected void onPause() {
        super.onPause();
        //进行取消订阅
        servable.unsubscribeOn((Scheduler) server);
    }


    //创建Retrofit的对象
    public void getRetrofit(){
      /*  Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()
            //    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())*/
    }
}
