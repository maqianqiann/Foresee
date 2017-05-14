package com.mrr.test.present;

import com.mrr.test.bean.UserBean;
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
 * 这是第三个界面的控制器
 */

public class ThreePresent {
    //初始化对象
    private MyListView listView;
    private MyModel model;
    private ArrayList<UserBean> list=new ArrayList<>();

    public ThreePresent(MyListView listView) {
        this.listView = listView;
        model=new MyModelInfo();
    }
    //写个数据请求的方法
    public void frechData(){
        //使用model的对象去调用方法
        Flowable<UserBean> flowable = model.getUsersDatas();
        //设置开启的线程
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<UserBean>() {
                    @Override
                    public void onNext(UserBean userBean) {
                        //拿到数据
                        list.add(userBean);
                        //使用view进行添加
                        listView.showUserData(userBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
