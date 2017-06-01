package com.future.mqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.future.mqq.R;
import com.future.mqq.activity.ListTryActivity;
import com.future.mqq.adapter.FirstAdapter2;
import com.future.mqq.bean.BannerBeans;
import com.future.mqq.bean.ChoseBean;
import com.future.mqq.bean.ListTryBean;
import com.future.mqq.bean.MyTopicBean;
import com.future.mqq.present.BannPresent;
import com.future.mqq.view.BannerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/26.
 */

public class ZhuanFragment extends Fragment implements BannerView{

    private View view;
    private RecyclerView recycle_view_fragment;
    private ListTryActivity activity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (ListTryActivity) getActivity();

        view = View.inflate(activity, R.layout.view_fragment, null);
        initView(view);
        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //创建p的对象
        new BannPresent(this,activity).fresh();


    }

    private void initView(View view) {
        //初始化布局
        recycle_view_fragment = (RecyclerView) view.findViewById(R.id.recycle_view_fragment);
        //设置布局管理者
        recycle_view_fragment.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        //设置数据



    }

    @Override
    public void setBannerData(ArrayList<BannerBeans> list) {

    }

    @Override
    public void showListTry(ListTryBean listTryBean) {

    }

    @Override
    public void showChoose(ChoseBean choseBean) {

    }

    @Override
    public void showZhuan(MyTopicBean topicBean) {
        List<MyTopicBean.DataBean.TopicBean> beanList = topicBean.getData().getTopic();
        recycle_view_fragment.setAdapter(new FirstAdapter2(activity,beanList));


    }

  /*  public static ViewFragment getInstance(String name,int topic){
        ViewFragment f=null;
        if(f==null){
            f=new ViewFragment();
        }
        Bundle bundle=new Bundle();
        bundle.putInt();

    }*/
}
