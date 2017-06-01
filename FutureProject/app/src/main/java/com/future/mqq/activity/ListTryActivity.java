package com.future.mqq.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.future.mqq.R;
import com.future.mqq.fragment.ViewFragment;
import com.future.mqq.fragment.ZhuanFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.future.mqq.R.layout.dialog;

/**
 * Created by lenovo on 2017/5/25.
 */
public class ListTryActivity extends AppCompatActivity {
    @Bind(R.id.im_back_include)
    ImageView imBackInclude;
    @Bind(R.id.text_title_include)
    TextView textTitleInclude;
    @Bind(R.id.text_time_include)
    TextView textTimeInclude;
    @Bind(R.id.tab_listtry)
    TabLayout tabListtry;
    @Bind(R.id.viewPage_listtry)
    ViewPager viewPageListtry;
    private boolean flag=true;
    private MyAdapter adapter;
    private ArrayList<Fragment> listf=new ArrayList<>();
    private ArrayList<String>  listt=new ArrayList<>();
    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listtry_list);
        ButterKnife.bind(this);
        textTimeInclude.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        id = intent.getIntExtra("position", 0);
        switch (id){
            case 0:
                textTimeInclude.setText("");
              break;
            case 1:
                textTitleInclude.setText("精品列表");
                break;
            case 2:
                textTitleInclude.setText("精选专辑");

                break;
        }
        //设置数据
        initDatas();
        imBackInclude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initDatas() {
        for (int i = 0; i <2 ; i++) {
            ViewFragment fragment = new ViewFragment();
            listf.add(fragment);

        }
        listf.add(new ZhuanFragment());
        listt.add("免费");
        listt.add("精品");
        listt.add("专辑");


        adapter = new MyAdapter(getSupportFragmentManager());
        //设置tab的类型
        tabListtry.setTabMode(TabLayout.MODE_FIXED);
        //设置字体的颜色
        tabListtry.setTabTextColors(Color.WHITE,Color.BLACK);
        tabListtry.setSelectedTabIndicatorColor(Color.BLACK);
        tabListtry.setupWithViewPager(viewPageListtry);
        tabListtry.setTabsFromPagerAdapter(adapter);


        //viewPager设置数据
        viewPageListtry.setAdapter(adapter);
           viewPageListtry.setCurrentItem(id);
    }
    private class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listf.get(position);
        }

        @Override
        public int getCount() {
            return listf.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listt.get(position);
        }
    }

    @OnClick({R.id.im_back_include, R.id.text_title_include, R.id.text_time_include, R.id.tab_listtry})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_back_include:
                break;
            case R.id.text_title_include:

                break;
            case R.id.text_time_include:
                //设置点击事件
                if(flag){
                    textTimeInclude.setSelected(true);
                 }else{
                    textTimeInclude.setSelected(false);
                }
                flag=!flag;
                //进行弹框
                View view1=View.inflate(ListTryActivity.this, dialog,null);

                PopupWindow pop=new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
                //设置点击空白区域进行消失;
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.setOutsideTouchable(true);
                pop.showAsDropDown(textTimeInclude);
                //找控件
                final TextView time= (TextView) view1.findViewById(R.id.text_dia_time);
                final TextView seven= (TextView) view1.findViewById(R.id.text_dia_seven);
                //设置点击事件
                time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time.setSelected(true);
                        seven.setSelected(false);
                    }
                });
                seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        seven.setSelected(true);
                        time.setSelected(false);
                    }
                });

                break;
            case R.id.tab_listtry:

         break;
        }
    }
}
