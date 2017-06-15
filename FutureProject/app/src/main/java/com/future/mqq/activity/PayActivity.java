package com.future.mqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.future.mqq.R;
import com.future.mqq.pay.PayResult;
import com.future.mqq.pay.PayUtils;
import com.future.mqq.utils.ApiServer;
import com.future.mqq.utils.ModelUtils;
import com.future.mqq.utils.UrlConnect;
import com.future.mqq.wxpay.PayActivity1;

import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by MaQian on 2017/6/1.
 * 支付的界面
 */
public class PayActivity extends Activity implements View.OnClickListener {


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

        alipayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag_wx=false;
                flag_zf=!flag_zf;
                alipayImg.setSelected(true);
                weChatImg.setSelected(false);
            }
        });
        weChatImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag_zf=false;
                flag_wx=!flag_wx;
                alipayImg.setSelected(false);
                weChatImg.setSelected(true);
            }
        });

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
                    Intent in=new Intent(PayActivity.this, PayActivity1.class);
                    startActivity(in);
                }
               else if(flag_zf){
                  //调取支付宝的API  PayTask
                    PayZFB();//客户端的加密
                 // ZFB();// 服务端的加密

                }
                break;
        }
    }

    //写个静态的内部类Handler
    public  static class MyHandler extends Handler {
        //创建弱引用
        WeakReference<Context> weakReference = null;

        public MyHandler(Context context) {
            weakReference = new WeakReference<>(context);

        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //当不为null是进行操作
            if(weakReference.get()!=null){
                if(msg.what==0){
                    // 同步返回需要验证的信息
                    PayResult payResult = new PayResult((String) msg.obj);
                    String resultStatus = payResult.getResultStatus();
                    if(TextUtils.equals(resultStatus, "9000")){
                        Toast.makeText(weakReference.get(), "支付成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(weakReference.get(), "支付不成功", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }
    }
    MyHandler myHandler=new MyHandler(PayActivity.this);

    //支付宝的方法
    private void PayZFB() {
        //拿到订单号
        //获得订单信息
        String orderInfo = PayUtils.getOrderInfo("预知来测试", "单号:"+order, "0.01");
        //进行加密签名
        String sign = PayUtils.sign(orderInfo);
        //通过URLEncoder进行编码
        try {
            sign = URLEncoder.encode(sign, "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //进行一个参数分拼接
        StringBuffer sb=new StringBuffer(orderInfo);
        sb.append("&sign=\"");
        sb.append(sign);
        sb.append("\"&");
        //设置签名的类型
        sb.append(PayUtils.getSignType());
        //获得最终的支付信息,完整的符合支付宝参数规范的订单信息
        final String payInfo = sb.toString();
        //开启子线程去调起支付宝的API
        Runnable payRunnable=new Runnable() {
            @Override
            public void run() {
                //支付宝的API，构造PayTask 对象
                PayTask alipay = new PayTask(PayActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo,true);
                //获得支付宝同步返回的结果
                Log.i("result",result.toString());
                //需要通过发送Message给主线程更新UI
                Message message = myHandler.obtainMessage(0, result);
                //发送
                message.sendToTarget();
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }

    private void ZFB(){
        //到服务器进行订单加密
        //进行网络请求
        ApiServer server = ModelUtils.getDataRequestApi(UrlConnect.LOCAL_URL);
        // Flowable<String> flowable = server.getService("测试", order, "0.01");
        Flowable<String> flowable = server.getPay("测试", order, "0.01");
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<String>() {
                    @Override
                    public void onNext(final String s) {
                        Log.i("service_s",s.toString());
                        Runnable payRunnable=new Runnable() {
                            @Override
                            public void run() {
                                //支付宝的API，构造PayTask 对象
                                PayTask alipay = new PayTask(PayActivity.this);
                                // 调用支付接口，获取支付结果
                                String result = alipay.pay(s,true);
                                //获得支付宝同步返回的结果
                                Log.i("result",result.toString());
                                //需要通过发送Message给主线s程更新UI
                                Message message = myHandler.obtainMessage(0, result);
                                //发送
                                message.sendToTarget();
                            }
                        };
                        Thread payThread = new Thread(payRunnable);
                        payThread.start();

                    }

                    @Override
                    public void onError(Throwable t) {
                       Log.i("Throwable",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
