package com.future.mqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.future.mqq.R;
import com.future.mqq.bean.CodeBean;
import com.future.mqq.bean.LogBean;
import com.future.mqq.bean.SessionBean;
import com.future.mqq.present.LogPresent;
import com.future.mqq.view.LogView;

/**
 * Created by lenovo on 2017/5/27.
 */
public class RegistActivity extends Activity implements View.OnClickListener ,LogView{
    private EditText regist_phone;
    private EditText regist_num;
    private TextView regist_getnum;
    private EditText regist_password;
    private Button regist_btn;
    private LogPresent present;
    public static String log_session;
    private String reg_session;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist_layout);
        present = new LogPresent(this, RegistActivity.this);
        initView();
    }

    private void initView() {
        regist_phone = (EditText) findViewById(R.id.regist_phone);
        regist_num = (EditText) findViewById(R.id.regist_num);
        regist_getnum = (TextView) findViewById(R.id.regist_getnum);
        regist_password = (EditText) findViewById(R.id.regist_password);
        regist_btn = (Button) findViewById(R.id.regist_btn);

        regist_btn.setOnClickListener(this);

        regist_getnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //进行注册，获得seesion
                String phone = regist_phone.getText().toString().trim();

                int length = phone.length();
                Log.i("length",length+"");
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(RegistActivity.this, "请输入注册的手机号", Toast.LENGTH_SHORT).show();

                }
                if (phone.length()<11){
                    Toast.makeText(RegistActivity.this, "+86,必须是11位手机号", Toast.LENGTH_SHORT).show();

                }
                 else {
                    regist_num.setText("9998");
                    present.getRegist(phone);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist_btn:
                //点击注册的时候进行判断
                submit();
                break;
            case R.id.regist_num:

                break;
        }
    }

    private void submit() {
        // validate
        String num = regist_num.getText().toString().trim();
        if (TextUtils.isEmpty(num)) {
            Toast.makeText(this, "输入你收到的验证码", Toast.LENGTH_SHORT).show();

        }

        String password = regist_password.getText().toString().trim();

        if (TextUtils.isEmpty(password)||password.length()<6) {
            Toast.makeText(this, "密码不少于6个字", Toast.LENGTH_SHORT).show();

        }

      /*  //注册成功跳转到登陆的界面
        Intent intent = new Intent(RegistActivity.this, LogActivity.class);
        startActivity(intent);
        finish();*/

       else{
            if(reg_session!=null){
                String pwd = regist_password.getText().toString().trim();
                //将数据回传给登陆界面
                Intent intent=new Intent();
                intent.putExtra("uname",regist_phone.getText().toString().trim());
                intent.putExtra("pwd",pwd);
                RegistActivity.this.setResult(20,intent);
                finish();
                //进行第二次交互，校对验证码
                present.getRegistData(reg_session,9998,pwd);
            }
        }


    }

    @Override
    public void showRegist(SessionBean sessionBean) {
        //进行判断session是否为null
        reg_session = sessionBean.getData().getSession();
        if(reg_session !=null){
            //成功返回session
            //再去获取验证码，与后台进行再一次的交互，拿到验证码
            Log.i("ses", reg_session +"");

        }
    }

    //登陆的数据
    @Override
    public void showLog(LogBean logBean) {

    }



    @Override
    public void showRegistData(CodeBean codeBean) {

        //进行一个获得登陆的信息，seesion和uname
        //进行一个保存
        log_session=codeBean.getData().getSession();
       Log.i("see_log",log_session);

    }

}
