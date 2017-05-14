package com.rxjava.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rxjava.test.R;
import com.rxjava.test.bean.UserBean;
import com.rxjava.test.present.MyPresent;
import com.rxjava.test.view.MyListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/12.
 */

public class NextActivity extends AppCompatActivity implements MyListView {

    @BindView(R.id.text_next)
    TextView textNext;
 //   private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_layout);
        ButterKnife.bind(this);
        //找控件
        // textNext = (TextView) findViewById(R.id.text_next);
        //获得控制器
        new MyPresent(NextActivity.this).french();
    }

    @Override
    public void getListData(ArrayList<UserBean> list) {
        textNext.setText(list.get(0).getName());
    }
}
