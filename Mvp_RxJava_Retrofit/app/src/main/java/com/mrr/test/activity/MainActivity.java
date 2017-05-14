package com.mrr.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mrr.test.R;
import com.mrr.test.bean.DataInfo;
import com.mrr.test.present.MyPresent;
import com.mrr.test.view.MyView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity<MyPresent> implements MyView {

    @BindView(R.id.text_a)
    TextView textA;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected int setLayout() {

        return R.layout.activity_main;
    }

    @Override
    protected void getData() {
        //进行请求数据
        myPresent.fresh("baiiu");
    }

    @Override
    protected MyPresent getPresent() {
        return new MyPresent(this);
    }

    @Override
    public void show(DataInfo dataInfo) {
        Log.i("dataInfo", dataInfo.toString());
        textA.setText(dataInfo.getLogin()+"12");
        Toast.makeText(MainActivity.this, dataInfo.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        textA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,NextActivity.class);
                startActivity(in);
            }
        });
    }
}
