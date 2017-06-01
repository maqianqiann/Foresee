package com.future.mqq.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.future.mqq.R;
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
        view = inflater.inflate(R.layout.fragment_people,null);
        //进行判断的登陆的状态
        activity = (MainActivity) getActivity();
       /* if(!LogActivity.log){
            //如果登陆的状态是false
            //跳转到登陆的界面
            Intent in=new Intent(activity,LogActivity.class);
            startActivity(in);
        }*/

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
