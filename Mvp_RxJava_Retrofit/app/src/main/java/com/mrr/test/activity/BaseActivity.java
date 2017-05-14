package com.mrr.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mrr.test.present.MyPresent;

/**
 * Created by lenovo on 2017/5/13.
 * 这是基类，降低耦合，方便使用
 */

public abstract class BaseActivity<T> extends AppCompatActivity {
    protected T myPresent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //定义初始化布局的方法
        setContentView(setLayout());
        //创建对象
        myPresent= getPresent();
        getData();


    }

    protected abstract int setLayout();
    //请求数据的方法
    protected  abstract void getData();

    //创建控制器的方法
   protected abstract T getPresent();
}
