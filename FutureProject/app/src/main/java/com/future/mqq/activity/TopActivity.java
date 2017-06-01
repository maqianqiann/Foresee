package com.future.mqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.future.mqq.R;
import com.future.mqq.adapter.TopAdapter;
import com.future.mqq.bean.JingBean;
import com.future.mqq.bean.MyCourseBean;
import com.future.mqq.bean.OrderBean;
import com.future.mqq.present.CoursePresent;
import com.future.mqq.view.CourseView;

import java.util.List;

/**
 * Created by lenovo on 2017/5/26.
 */
public class TopActivity extends AppCompatActivity implements CourseView{
    private ImageView z_x_pic;
    private ImageView z_x_fan;
    private TextView n_text;
    private ImageView z_x_fen;
    private TextView z_x_text1;
    private TextView z_x_text2;
    private ImageView z_x_xin;
    private TextView z_x_num;
    private TextView z_x_text3;
    private TextView z_x_text4;
    private RecyclerView z_x_rec;
    private String object_id;
    private String image;
    private String title;
    private String title2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiang_mian);
        Intent intent = getIntent();
        object_id = intent.getStringExtra("object_id");
        image = intent.getStringExtra("image");
        title = intent.getStringExtra("title");
        title2 = intent.getStringExtra("title2");
        new CoursePresent(this,TopActivity.this,object_id).getTopDa();

        initView();
    }

    private void initView() {
        z_x_pic = (ImageView) findViewById(R.id.z_x_pic);
        z_x_fan = (ImageView) findViewById(R.id.z_x_fan);
        n_text = (TextView) findViewById(R.id.n_text);
        z_x_fen = (ImageView) findViewById(R.id.z_x_fen);
        z_x_text1 = (TextView) findViewById(R.id.z_x_text1);
        z_x_text2 = (TextView) findViewById(R.id.z_x_text2);
        z_x_xin = (ImageView) findViewById(R.id.z_x_xin);
        z_x_num = (TextView) findViewById(R.id.z_x_num);
        z_x_text3 = (TextView) findViewById(R.id.z_x_text3);
        z_x_text4 = (TextView) findViewById(R.id.z_x_text4);
        z_x_rec = (RecyclerView) findViewById(R.id.z_x_rec);

        //设置数据
        Glide.with(this).load(image).into(z_x_pic);
        z_x_text1.setText(title);
        z_x_text2.setText(title2);
        //返回的点击事件
        z_x_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

    @Override
    public void showCourse(MyCourseBean bean) {

    }

    @Override
    public void showTop(JingBean bean) {
        List<JingBean.DataBean.CourseBean> list = bean.getData().getCourse();
        //设置布局管理者
        z_x_rec.setLayoutManager(new LinearLayoutManager(TopActivity.this,LinearLayoutManager.VERTICAL,false));
        //设置适配器
       z_x_rec.setAdapter(new TopAdapter(TopActivity.this,list));

    }

    @Override
    public void showOrder(OrderBean orderBean) {

    }
}
