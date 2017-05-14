package com.mrr.test.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.mrr.test.R;
import com.mrr.test.adapter.MyRecAdapter;
import com.mrr.test.adapter.MyStAdapter;
import com.mrr.test.bean.NewsBean;
import com.mrr.test.bean.UserBean;
import com.mrr.test.present.ThreePresent;
import com.mrr.test.view.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/14.
 */
public class ThridActivity extends BaseActivity<ThreePresent> implements MyListView {
    @BindView(R.id.re_View)
    RecyclerView reView;

    @Override
    protected int setLayout() {
        return R.layout.next_layout;
    }

    @Override
    protected void getData() {
        myPresent.frechData();
    }

    @Override
    protected ThreePresent getPresent() {
        return new ThreePresent(this);
    }

//这是第二层的数据
    @Override
    public void showData(ArrayList<NewsBean> list) {

    }

    @Override
    public void showUserData(UserBean userBean) {
        List<UserBean.ResultBean.DataBean> list = userBean.getResult().getData();
        reView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置适配器
        reView.setAdapter(new MyStAdapter(this,list));
    }
    //拿到头条的数据


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
