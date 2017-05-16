package com.rxjava.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import bean.NewsBean;
import present.MyPresent;
import view.MyView;

/**
 * Created by lenovo on 2017/5/15.
 */

public class NextActivity extends AppCompatActivity implements MyView{

    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_layout);
        text = (TextView) findViewById(R.id.next_text);

        //实例化Present对象
       new MyPresent(this,NextActivity.this).fresh("baiiu");
    }

    @Override
    public void show(NewsBean bean) {
        //拿到数据
        text.setText(bean.toString());
    }
}
