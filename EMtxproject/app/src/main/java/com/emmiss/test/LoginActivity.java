package com.emmiss.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/16.
 */

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.ec_edit_username)
    EditText ecEditUsername;
    @Bind(R.id.ec_edit_password)
    EditText ecEditPassword;
    @Bind(R.id.ec_btn_sign_up)
    Button ecBtnSignUp;
    @Bind(R.id.ec_btn_sign_in)
    Button ecBtnSignIn;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //设置点击事件
        //注册的方法
        singUp();
        //登陆的方法
        singIn();

    }

    //登陆的方法
    private void singIn() {
        ecBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog = new ProgressDialog(LoginActivity.this);
                mDialog.setMessage("正在登陆，请稍后...");
                mDialog.show();
                String username = ecEditUsername.getText().toString().trim();
                String password = ecEditPassword.getText().toString().trim();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "用户名和密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }

                EMClient.getInstance().login(username, password, new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mDialog.dismiss();

                                // 加载所有会话到内存
                                EMClient.getInstance().chatManager().loadAllConversations();

                                // 登录成功跳转界面
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String error) {

                    }

                    @Override
                    public void onProgress(int progress, String status) {

                    }
                });
            }
        });

    }

    //注册的方法
    private void singUp() {
        //注册的按钮
        ecBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String name = ecEditUsername.getText().toString().trim();
                        String pwd = ecEditPassword.getText().toString().trim();
                        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                            Toast.makeText(LoginActivity.this, "用户名和密码不能为空", Toast.LENGTH_LONG).show();
                            return;
                        }
                        try {
                            //进行注册,进行注册数据
                            EMClient.getInstance().createAccount(name,pwd);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (!LoginActivity.this.isFinishing()) {
                                     //   mDialog.dismiss();
                                    }
                                    Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                                }
                            });


                        } catch (Exception e) {
                            e.printStackTrace();

                        }


                    }
                }).start();;



            }
        });
    }
}
