package com.rxjava.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rxjava.test.R;
import com.rxjava.test.api.Api;
import com.rxjava.test.bean.GuangBean;
import com.rxjava.test.bean.NewsBean;
import com.rxjava.test.bean.UserBean;
import com.rxjava.test.utils.RxJavaServer;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<NewsBean> listn=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initViews();
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.listView);
    //    getNoArgment();
       //  getArgment();
        getNewsArgment();


    }

    private void getNewsArgment() {
        //获得OkHttp的对象
        OkHttpClient client=new OkHttpClient.Builder().build();
        //创建Retrofit的镀锡
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        //进行创建接口
        RxJavaServer server = retrofit.create(RxJavaServer.class);
        //获得Observable的对象
        Observable<List<NewsBean>> observable = server.getNewsDatas("square", "retrofit");
        //设置运行的线程
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //flatMap是一对多的转换，将传入的参数转换为Observable对象
                .flatMap(new Func1<List<NewsBean>, Observable<NewsBean>>() {
                    @Override
                    public Observable<NewsBean> call(List<NewsBean> newsBeen) {
                        return Observable.from(newsBeen);
                    }
                }).subscribe(new Subscriber<NewsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("error",e.getMessage());

            }

            @Override
            public void onNext(NewsBean newsBean) {
                Log.i("error",newsBean.toString());

                listn.add(newsBean);
               //拿到数据
                listView.setAdapter(new MyAdapter(listn));
            }
        });


    }

    private void getArgment() {
       //创建OkHttp的对象
        OkHttpClient client=new OkHttpClient.Builder().build();
        //获得Retrofit的对象
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //获得接口的对象
        RxJavaServer server = retrofit.create(RxJavaServer.class);
        //调起方法获得被观察者的对象
        Observable<UserBean> observable = server.getUserDatas("baiiu");
        //设置运行的线程
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<UserBean, UserBean>() {
                    @Override
                    public UserBean call(UserBean userBean) {
                        return userBean;
                    }//将被观察者订阅观察者
                }).subscribe(new Observer<UserBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserBean userBean) {
                String url = userBean.getFollowing_url();
                ArrayList<String> lists=new ArrayList<String>();
                lists.add(url);

                listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,lists));
            }
        });

    }

    private void getNoArgment() {
        //创建OkHttp的对象
        OkHttpClient client=new OkHttpClient.Builder().build();

        //获得Retrofit的对象
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_PATH)
                .client(client)//交给Ok进行网络请求
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //创建接口的对象
        RxJavaServer server = retrofit.create(RxJavaServer.class);
        //获得Observable对象
        Observable<GuangBean> observable = server.getDatas();
        //指定线程
        //运行在io线程，进行耗时的操作
        observable.subscribeOn(Schedulers.io())
                //运行到主线程
                 .observeOn(AndroidSchedulers.mainThread())
                 .map(new Func1<GuangBean, GuangBean>() {//对其进行转换
                     @Override
                     public GuangBean call(GuangBean guangBean) {
                         return guangBean;
                     }
                 })//进行订阅，订阅观察者,被观察者订阅观察者
           .subscribe(new Subscriber<GuangBean>() {
            @Override
            public void onCompleted() {
                Log.i("error","onCompleted");

            }

            @Override
            public void onError(Throwable e) {
                Log.i("error",e.getMessage());
            }

            @Override
            public void onNext(GuangBean guangBean) {
                //拿到解析的数据
                List<GuangBean.AdsBean> list = guangBean.getAds();
                ArrayList<String> lists=new ArrayList<String>();
                for (int i = 0; i <list.size() ; i++) {
                    String s = list.get(i).getGonggaoren();
                    lists.add(s);
                }
                listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,lists));

            }
        })

        ;

    }
private class MyAdapter extends BaseAdapter{
    ArrayList<NewsBean> listn;
    public MyAdapter(ArrayList<NewsBean> listn) {
        this.listn=listn;
    }

    @Override
    public int getCount() {
        return listn.size();
    }

    @Override
    public Object getItem(int i) {
        return listn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=View.inflate(MainActivity.this,R.layout.item_layout,null);
        TextView title= (TextView)view.findViewById(R.id.title_item);
        ImageView image= (ImageView) view.findViewById(R.id.image_item);
        title.setText(listn.get(i).getLogin());
        Glide.with(MainActivity.this).load(listn.get(i).getAvatar_url()).into(image);

        return view;
    }
}

}
