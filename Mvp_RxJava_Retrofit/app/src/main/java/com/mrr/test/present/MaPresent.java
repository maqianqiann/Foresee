package com.mrr.test.present;

import android.util.Log;

import com.mrr.test.bean.NewsBean;
import com.mrr.test.model.MyModel;
import com.mrr.test.model.MyModelInfo;
import com.mrr.test.view.MyListView;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/5/14.
 * 这是控制器
 */

public class MaPresent {
     MyListView listView;
    private MyModel model;

    public MaPresent(MyListView listView) {
        this.listView = listView;
        model=new MyModelInfo();
    }
    //创建一个方法
    public void getNews(String square,String retrofit){
        final Flowable<ArrayList<NewsBean>> flowable = model.getNewsDatas(square, retrofit);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ArrayList<NewsBean>>() {
                    @Override
                    public void onNext(ArrayList<NewsBean> newsBeen) {
                        Log.i("newsBeen",newsBeen.toString());
                        //拿到数据给View
                        listView.showData(newsBeen);

                    }

                    @Override
                    public void onError(Throwable t) {
                    Log.i("newsBean",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
