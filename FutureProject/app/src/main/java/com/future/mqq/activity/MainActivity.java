package com.future.mqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.future.mqq.R;
import com.future.mqq.fragment.CourseFragment;
import com.future.mqq.fragment.FirstFragment;
import com.future.mqq.fragment.MyFragment;
import com.future.mqq.model.FirstModel;
import com.future.mqq.present.FirstPresent;
import com.future.mqq.utils.UrlConnect;
import com.future.mqq.view.FirstView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements FirstView{


    @Bind(R.id.fl)
    FrameLayout fl;
    @Bind(R.id.radio_learn)
    RadioButton radioLearn;
    @Bind(R.id.radio_course)
    RadioButton radioCourse;
    @Bind(R.id.radio_me)
    RadioButton radioMe;
    @Bind(R.id.radio_activity)
    RadioGroup radioActivity;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    //写个图片的集合
    private ArrayList<ImageView> listm = null;
    private FragmentManager manager;
    private FirstFragment f1;
    private CourseFragment fc;
    private MyFragment fm;
    private SharedPreferences.Editor edit;
    private SharedPreferences spf;
    private int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FirstPresent present = new FirstPresent(this, MainActivity.this);


        if(FirstModel.sp.getBoolean(UrlConnect.ISFIRSTINSTALL,false)==false){
            present.getModelDatas();
        }
        else{
            Intent intent = getIntent();
            num = intent.getIntExtra("num",0);


            showFragment();
        }


        //设置点击事件
        //将fragment放入activity中

    }

    private void showFragment() {
        manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        f1 = new FirstFragment();
        fc = new CourseFragment();
        fm = new MyFragment();
        beginTransaction.add(R.id.fl, f1);
        beginTransaction.add(R.id.fl, fc);
        beginTransaction.add(R.id.fl, fm);
        beginTransaction.show(f1);
        beginTransaction.hide(fc);
        beginTransaction.hide(fm);
        //提交
        beginTransaction.commit();
        radioLearn.setSelected(true);
        radioLearn.setTextColor(Color.YELLOW);

        //调用显示和隐藏的方法
        if(num==0){
        showAndHide(f1,fc,fm);
        }else if(num==3){
         showAndHide(fm,fc,f1);

        }
    }

    //写个显示和隐藏的方法
    private void showAndHide(Fragment f1, Fragment f2, Fragment f3) {
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.show(f1);
        beginTransaction.hide(f2);
        beginTransaction.hide(f3);
        beginTransaction.commit();

    }


    @OnClick({R.id.radio_learn, R.id.radio_course, R.id.radio_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_learn:
                //设置选择器
                radioLearn.setSelected(true);
                radioCourse.setSelected(false);
                radioMe.setSelected(false);
                radioLearn.setTextColor(Color.YELLOW);
                radioCourse.setTextColor(Color.BLACK);
                radioMe.setTextColor(Color.BLACK);
                //调用切换的方法
                showAndHide(f1,fc,fm);

                break;
            case R.id.radio_course:
                radioLearn.setSelected(false);
                radioCourse.setSelected(true);
                radioMe.setSelected(false);
                radioCourse.setTextColor(Color.YELLOW);
                radioLearn.setTextColor(Color.BLACK);
                radioMe.setTextColor(Color.BLACK);
                showAndHide(fc,f1,fm);


                break;
            case R.id.radio_me:
              if(!LogActivity.log){
                    //如果登陆的状态是false
                    //跳转到登陆的界面
                    Intent in=new Intent(MainActivity.this,LogActivity.class);
                    in.putExtra("log_num",0);
                    startActivity(in);

                }

                //设置
                radioLearn.setSelected(false);
                radioCourse.setSelected(false);
                radioMe.setSelected(true);
                radioMe.setTextColor(Color.YELLOW);
                radioCourse.setTextColor(Color.BLACK);
                radioLearn.setTextColor(Color.BLACK);
                showAndHide(fm,f1,fc);

                break;
        }
    }


    @Override
    public void showFirst(Boolean b) {
        showFragment();
    }
}
