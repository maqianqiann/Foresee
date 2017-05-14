package com.mrr.test.present;

import com.mrr.test.bean.DataInfo;
import com.mrr.test.model.MyModel;
import com.mrr.test.model.MyModelInfo;
import com.mrr.test.view.MyView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by lenovo on 2017/5/13.
 */

public class MyPresent {
    private MyView myView;
    private MyModel model;

    public MyPresent(MyView myView) {
        this.myView = myView;
        model=new MyModelInfo();
    }
    //定义个进行操作的方法
    public void fresh(String name){
        Flowable flowable = model.getDatas(name);
        //设置在不同的线程进行操作
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DataInfo>() {
                    @Override
                    public void onNext(DataInfo dataInfo) {
                        myView.show(dataInfo);
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
