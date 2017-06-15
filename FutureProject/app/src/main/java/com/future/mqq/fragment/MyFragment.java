package com.future.mqq.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.future.mqq.R;
import com.future.mqq.activity.LogActivity;
import com.future.mqq.activity.MainActivity;

/**
 * Created by lenovo on 2017/5/23.
 */

public class MyFragment extends Fragment {

    private View view;
    private MainActivity activity;
    private SharedPreferences spf;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(!LogActivity.log){
            //如果登陆的状态是false
            //跳转到登陆的界面
            //显示别的节目
            view=inflater.inflate(R.layout.fragemnt_me2,null);
            activity = (MainActivity) getActivity();
          TextView title= (TextView) view.findViewById(R.id.text_title_include);
            title.setText("我的");
            TextView textView = (TextView) view.findViewById(R.id.login_me2_text);
            ImageView im = (ImageView) view.findViewById(R.id.login_me2_im);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(activity,LogActivity.class);
                    startActivity(in);
                }
            });
             im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(activity,LogActivity.class);
                    startActivity(in);
                }
            });

        }else {
            view = inflater.inflate(R.layout.m_main,null);
            TextView m_name= (TextView) view.findViewById(R.id.m_name);
            m_name.setText("已登录");
            TextView title= (TextView) view.findViewById(R.id.text_title_include);
            title.setText("我的");
            //进行判断的登陆的状态
            activity = (MainActivity) getActivity();
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
