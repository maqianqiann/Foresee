package com.future.mqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.future.mqq.R;

/**
 * Created by MaQian on 2017/6/1.
 * 支付的界面
 */
public class PayActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView paymentTitleBar;
    private TextView text_;
    private TextView showYuE;
    private ImageView iv2;
    private TextView yue;
    private CheckBox remainderImg;
    private Button rechargeBtn;
    private ImageView iv3;
    private CheckBox weChatImg;
    private ImageView iv5;
    private CheckBox alipayImg;
    private Button payBtn;
    private String order;
    //定义一个boolean值去判断里面checkbox的状态
    private boolean flag_wx=false;
    private boolean flag_zf=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        //获取数据
        Intent intent = getIntent();
        order = intent.getStringExtra("order");
        //拿到预支付订单的订单号进行其他的操作。
        initView();


    }

    private void initView() {
        paymentTitleBar = (TextView) findViewById(R.id.paymentTitleBar);
        text_ = (TextView) findViewById(R.id.text_);
        showYuE = (TextView) findViewById(R.id.showYuE);
        iv2 = (ImageView) findViewById(R.id.iv2);
        yue = (TextView) findViewById(R.id.yue);
        remainderImg = (CheckBox) findViewById(R.id.remainderImg);
        rechargeBtn = (Button) findViewById(R.id.rechargeBtn);
        iv3 = (ImageView) findViewById(R.id.iv3);
        //微信的checkBox
        weChatImg = (CheckBox) findViewById(R.id.weChatImg);
        iv5 = (ImageView) findViewById(R.id.iv5);
        //选择支付宝的checkbox
        alipayImg = (CheckBox) findViewById(R.id.alipayImg);
        //支付的按钮
        payBtn = (Button) findViewById(R.id.payBtn);

        rechargeBtn.setOnClickListener(this);
        payBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rechargeBtn:

                break;
            case R.id.payBtn:
                //这是确认支付的按钮的监听事件
                //判断选择支付的方式，如果是微信就调起微信的API，
                //点击之后如果是支付宝就调取支付宝的API  PayTask
                if(flag_wx){
                    //代表点击了微信，调起PayReq
                    PayWX();
                }
                if(flag_zf){
                  //调取支付宝的API  PayTask
                    PayZFB();
                }


                break;
        }
    }

    //支付宝的方法
    private void PayZFB() {

    }

    //微信的
    private void PayWX() {


    }
}
