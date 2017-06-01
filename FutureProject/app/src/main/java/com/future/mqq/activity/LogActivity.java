package com.future.mqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
public class LogActivity extends AppCompatActivity implements View.OnClickListener,LogView {

    public static boolean log = false;

    private EditText login_account;
    private EditText login_password;
    private TextView forgetpassword;
    private Button login;
    private Button regist;
    private ImageView iv1;
    private TextView tv1;
    private RelativeLayout wechat;
    private ImageView iv2;
    private TextView tv2;
    private RelativeLayout qq;
    private String uname;
    private String pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        login_account = (EditText) findViewById(R.id.login_account);
        login_password = (EditText) findViewById(R.id.login_password);
        forgetpassword = (TextView) findViewById(R.id.forgetpassword);
        login = (Button) findViewById(R.id.login);
        regist = (Button) findViewById(R.id.regist);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tv1 = (TextView) findViewById(R.id.tv1);
        wechat = (RelativeLayout) findViewById(R.id.wechat);
        iv2 = (ImageView) findViewById(R.id.iv2);
        tv2 = (TextView) findViewById(R.id.tv2);
        qq = (RelativeLayout) findViewById(R.id.qq);

        login.setOnClickListener(this);
        regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                submit();
                break;
            case R.id.regist:
                //跳转到注册的界面
                Intent in=new Intent(LogActivity.this,RegistActivity.class);
                startActivityForResult(in,10);
                break;
        }
    }

    private void submit() {



        // validate
        String account = login_account.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, "+86", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = login_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "密码不少于6个字", Toast.LENGTH_SHORT).show();
            return;
        }
        //拿到登陆之后返回的值seesion,在后期支付的时候会用到
        //进行一次与后台的交互

        new LogPresent(this,LogActivity.this).getLogDatas(account,password);
        // TODO validate success, do something
        //登陆成功之后，进行记录登陆的状态
        log=true;
        //并且跳转到我的界面
        Intent in=new Intent(LogActivity.this,MainActivity.class);
        in.putExtra("num",3);
        startActivity(in);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            if(requestCode==10&&resultCode==20){
                String uname = data.getStringExtra("uname");
                String pwd = data.getStringExtra("pwd");
                login_account.setText(uname);
                login_password.setText(pwd);
                Log.i("xxx",uname);

            }

        }
    }

    @Override
    public void showRegist(SessionBean sessionBean) {

    }

    //登陆的方法，拿到数据
    @Override
    public void showLog(LogBean logBean) {
        //拿到数据之后,进行数据session的保存
        String session = logBean.getData().getSession();
        Log.i("xxsession",session);
    }

    @Override
    public void showRegistData(CodeBean codeBean) {


    }

}
