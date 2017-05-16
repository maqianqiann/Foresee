package present;

import android.content.Context;

import javax.inject.Inject;

import bean.NewsBean;
import dagger.DaggerMyComonent;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import model.MyModelC;
import view.MyView;

/**
 * Created by lenovo on 2017/5/15.
 * 作为控制器将model的数据和、给view显示
 */

public class MyPresent {

    @Inject
    MyModelC model;
    //获得View对象
    private MyView myView;

    private  Context context;
    public MyPresent(MyView myView, Context context) {
        this.myView = myView;

        this.context=context;
    }
    //写个对外提供的方法
    public void fresh(String name){
        //创建的父桥梁和子桥梁的对象
       /* DaggerAppComonent.Builder builder = DaggerAppComonent.builder();
        AppComonent comonent = builder.appModuel(new AppModuel(context)).build();*/
        //调用注入的方法
        DaggerMyComonent.builder().build().inject(this);


        Flowable<NewsBean> flowable = model.getDatas(name);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<NewsBean>() {
                    @Override
                    public void onNext(NewsBean newsBean) {
                         myView.show(newsBean);
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
