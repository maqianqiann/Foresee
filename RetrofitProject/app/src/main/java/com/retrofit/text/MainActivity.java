package com.retrofit.text;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.retrofit.text.bean.Info;
import com.retrofit.text.bean.LogBean;
import com.retrofit.text.bean.MyServer1;
import com.retrofit.text.bean.NewsInfo;
import com.retrofit.text.bean.Person;
import com.retrofit.text.component.DaggerMainCommponent;
import com.retrofit.text.component.DaggerMyComponent;
import com.retrofit.text.component.MainCommponent;
import com.retrofit.text.component.MyComponent;
import com.retrofit.text.moduel.AppModuel;
import com.retrofit.text.moduel.MyModuel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    //获得对象
    @Inject
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text_a);
     /*   //创建一个对象
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Content.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // 加上这句话
                .build();

        //创建接口对象
        MainServer server = retrofit.create(MainServer.class);
        Call<NewsInfo> call = server.getDatas();
        call.enqueue(new Callback<NewsInfo>() {
            @Override
            public void onResponse(Call<NewsInfo> call, Response<NewsInfo> response) {
                String s = response.body().toString();
                Toast.makeText(MainActivity.this, "请求"+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<NewsInfo> call, Throwable t) {

            }
        });*/

          //创建桥梁对象，创建父桥梁
        MyComponent build = DaggerMyComponent.builder().appModuel(new AppModuel(this)).build();
        //创建子桥梁的对象
        MainCommponent commponent = DaggerMainCommponent.builder().myComponent(build).myModuel(new MyModuel()).build();
        commponent.inject(this);
        person.name="小白";
        Log.i("xxx",person.name);

        //getServers();
        loadServer();
        logServer();
    }

    private void logServer() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Content.BASE_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        MyServer1 server1 = retrofit.create(MyServer1.class);
        Call<LogBean> call = server1.login("sj", "1998");
        call.enqueue(new Callback<LogBean>() {
            @Override
            public void onResponse(Call<LogBean> call, Response<LogBean> response) {
                Log.i("log",response.body().str);
            }

            @Override
            public void onFailure(Call<LogBean> call, Throwable t) {

            }
        });

    }

    private void getServers() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyServer1 server1 = retrofit.create(MyServer1.class);
        Call<Info> call = server1.getServer("top",0,1,20);
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                List<Info.TngouBean> list = response.body().getTngou();
                String description = list.get(0).getDescription();
                  text.setText(description+"");
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {


            }
        });
    }

    private void loadServer() {
        //获得Retrofit的对象
        Retrofit fit=new Retrofit.Builder().baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyServer1 server1 = fit.create(MyServer1.class);
        Call<Info> call = server1.load("cook", 0, 1, 5);
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                String s = response.body().getTngou().get(0).getDescription();
                Toast.makeText(MainActivity.this, "post"+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });
    }


}
