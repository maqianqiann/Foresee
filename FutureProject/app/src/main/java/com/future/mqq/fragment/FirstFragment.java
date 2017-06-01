package com.future.mqq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.future.mqq.R;
import com.future.mqq.activity.ListTryActivity;
import com.future.mqq.activity.MainActivity;
import com.future.mqq.adapter.FirstAdapter;
import com.future.mqq.adapter.FirstAdapter1;
import com.future.mqq.adapter.FirstAdapter2;
import com.future.mqq.bean.BannerBeans;
import com.future.mqq.bean.ChoseBean;
import com.future.mqq.bean.ListTryBean;
import com.future.mqq.bean.MyTopicBean;
import com.future.mqq.present.BannPresent;
import com.future.mqq.utils.ImageUtils;
import com.future.mqq.view.BannerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.future.mqq.R.id.topic_recyclerview;

/**
 * Created by lenovo on 2017/5/23.
 */

public class FirstFragment extends Fragment implements BannerView{

    @Bind(R.id.mBanner)
    Banner mBanner;
    @Bind(R.id.imageview_sanjiao)
    ImageView imageviewSanjiao;
    @Bind(R.id.imageview_jian)
    ImageView imageviewJian;
    @Bind(R.id.try_all)
    TextView tryAll;
    @Bind(R.id.try_recyclerview)
    RecyclerView tryRecyclerview;
    @Bind(R.id.imageview_sanjiao2)
    ImageView imageviewSanjiao2;
    @Bind(R.id.imageview_jian2)
    ImageView imageviewJian2;
    @Bind(R.id.course_recyclerview)
    RecyclerView courseRecyclerview;
    @Bind(R.id.iv)
    ImageView iv;
    @Bind(R.id.iv2)
    ImageView iv2;
    @Bind(R.id.topic_all)
    TextView topicAll;
    @Bind(topic_recyclerview)
    RecyclerView topicRecyclerview;
    private View view;
    private MainActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learn, null);
        activity = (MainActivity) getActivity();
        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //精选
        view.findViewById(R.id.text_top2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent in=new Intent(activity,ListTryActivity.class);
                   in.putExtra("id",1);
                in.putExtra("position",1);
                startActivity(in);
            }
        });
        //免费
        imageviewJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(activity,ListTryActivity.class);
                in.putExtra("position",0);

                startActivity(in);
            }
        });
        //精选
        imageviewJian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(activity,ListTryActivity.class);
                in.putExtra("position",1);

                startActivity(in);
            }
        });
        //免费
        tryAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(activity,ListTryActivity.class);
                in.putExtra("id",0);
                in.putExtra("position",0);

                startActivity(in);
            }
        });
        //专辑
        topicAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(activity,ListTryActivity.class);
                in.putExtra("id",1);
                in.putExtra("position",2);

                startActivity(in);
            }
        });
        //专辑
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(activity,ListTryActivity.class);
                in.putExtra("position",2);

                startActivity(in);
            }
        });

        new BannPresent(this,activity).fresh();

        //设置适配器
        tryRecyclerview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));

        courseRecyclerview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));

        topicRecyclerview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void setBannerData(ArrayList<BannerBeans> list) {
        mBanner.setImageLoader(new ImageUtils());

        ArrayList<String> lists=new ArrayList<>();
        for (int i = 0; i<3; i++) {
            lists.add(list.get(0).getData().getBanner().get(i).getImage());
            Log.i("xxima",lists.get(i));
        }

        mBanner.setImages(lists);
        mBanner.start();
    }

    @Override
    public void showListTry(ListTryBean listTryBean) {
        List<ListTryBean.DataBean.TryBean> list= listTryBean.getData().getTryX();
        tryRecyclerview.setAdapter(new FirstAdapter(activity,list));

    }

    @Override
    public void showChoose(ChoseBean choseBean) {

        List<ChoseBean.DataBean.CourseBean> list = choseBean.getData().getCourse();
        courseRecyclerview.setAdapter(new FirstAdapter1(activity,list));
    }

    @Override
    public void showZhuan(MyTopicBean topicBean) {
        List<MyTopicBean.DataBean.TopicBean> list = topicBean.getData().getTopic();
        topicRecyclerview.setAdapter(new FirstAdapter2(activity,list));

    }
}
