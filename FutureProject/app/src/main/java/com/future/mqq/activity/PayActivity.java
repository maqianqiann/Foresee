package com.future.mqq.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.future.mqq.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by MaQian on 2017/6/1.
 * 支付的界面
 */
public class PayActivity extends AppCompatActivity {
    @Bind(R.id.paymentTitleBar)
    TextView paymentTitleBar;
    @Bind(R.id.text_)
    TextView text;
    @Bind(R.id.showYuE)
    TextView showYuE;
    @Bind(R.id.iv2)
    ImageView iv2;
    @Bind(R.id.yue)
    TextView yue;
    @Bind(R.id.remainderImg)
    ImageView remainderImg;
    @Bind(R.id.rechargeBtn)
    Button rechargeBtn;
    @Bind(R.id.iv3)
    ImageView iv3;
    @Bind(R.id.weChatImg)
    ImageView weChatImg;
    @Bind(R.id.iv5)
    ImageView iv5;
    @Bind(R.id.alipayImg)
    ImageView alipayImg;
    @Bind(R.id.payBtn)
    Button payBtn;
    @Bind(R.id.activity_payment)
    LinearLayout activityPayment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);


    }
}
