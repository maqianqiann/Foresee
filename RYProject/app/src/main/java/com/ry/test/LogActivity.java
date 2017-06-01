package com.ry.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by lenovo on 2017/5/17.
 */
public class LogActivity extends AppCompatActivity{
    String tooken="uI5KHzWt5oRltie0UEDh7RWUIXnVdaC8idCPbGSLmc3dk5KZQ8pZnOp/VxTdFlbON1q/ufeBjZZ5uLrSaqCeZw==";
    String string="V9Gtce9ASztdztPGTKH/6hWUIXnVdaC8idCPbGSLmc3dk5KZQ8pZnAhyq45Lbvn6EeLj/lb0k5p5uLrSaqCeZw==";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect(string);


            }
        });

    }
    private void connect(String token) {

        if (getApplicationInfo().packageName.equals(MyApp.getCurProcessName(getApplicationContext()))) {

            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                @Override
                public void onTokenIncorrect() {

                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                @Override
                public void onSuccess(String userid) {
                    Log.d("LoginActivity", "--onSuccess" + userid);
                    startActivity(new Intent(LogActivity.this, MainActivity.class));
                    finish();
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                }
            });
        }
    }
}
