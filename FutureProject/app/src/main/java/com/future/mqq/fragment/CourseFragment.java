package com.future.mqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.future.mqq.R;
import com.future.mqq.activity.MainActivity;
import com.future.mqq.adapter.FirstAdapter;
import com.future.mqq.bean.BannerBeans;
import com.future.mqq.bean.ChoseBean;
import com.future.mqq.bean.ListTryBean;
import com.future.mqq.bean.MyTopicBean;
import com.future.mqq.present.BannPresent;
import com.future.mqq.view.BannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/23.
 */

public class CourseFragment extends Fragment implements BannerView{

    @Bind(R.id.course_title)
    TextView courseTitle;
    @Bind(R.id.course_rela)
    RelativeLayout courseRela;
    @Bind(R.id.course_recycle)
    RecyclerView courseRecycle;
    private View view;
    private MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_course, null);
        activity = (MainActivity) getActivity();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         new BannPresent(this,activity).fresh();
        courseRecycle.setLayoutManager(new LinearLayoutManager(activity));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void setBannerData(ArrayList<BannerBeans> list) {

    }

    @Override
    public void showListTry(ListTryBean listTryBean) {
        List<ListTryBean.DataBean.TryBean> list = listTryBean.getData().getTryX();
        courseRecycle.setAdapter(new FirstAdapter(activity,list));
    }

    @Override
    public void showChoose(ChoseBean choseBean) {

    }

    @Override
    public void showZhuan(MyTopicBean topicBean) {

    }
}
