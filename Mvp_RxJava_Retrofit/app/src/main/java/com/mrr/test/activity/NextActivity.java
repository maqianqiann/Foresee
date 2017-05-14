package com.mrr.test.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mrr.test.R;
import com.mrr.test.adapter.MyRecAdapter;
import com.mrr.test.bean.NewsBean;
import com.mrr.test.bean.UserBean;
import com.mrr.test.present.MaPresent;
import com.mrr.test.view.MyListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/14.
 */
public class NextActivity extends BaseActivity<MaPresent> implements MyListView{
    @BindView(R.id.re_View)
    RecyclerView reView;

    @Override
    protected int setLayout() {
        return R.layout.next_layout;
    }

    @Override
    protected void getData() {
        myPresent.getNews("square","retrofit");
    }

    @Override
    protected MaPresent getPresent() {
        return new MaPresent(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showData(ArrayList<NewsBean> list) {
        reView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
        MyRecAdapter adapter = new MyRecAdapter(NextActivity.this,list);
        reView.setAdapter(adapter);
    }

    @Override
    public void showUserData(UserBean userBean) {
    }

}
