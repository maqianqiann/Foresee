package com.mrr.test.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mrr.test.R;
import com.mrr.test.activity.NextActivity;
import com.mrr.test.activity.ThridActivity;
import com.mrr.test.bean.NewsBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/5/14.
 */

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.MyViewHolder> {

    private ArrayList<NewsBean> list;
    private Context context;
    public MyRecAdapter(Context context, ArrayList<NewsBean> list) {
        this.list=list;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         holder.title.setText(list.get(position).getLogin());
        Glide.with(context).load(list.get(position).getAvatar_url()).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView im;
        private final TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.im_item);
            title = (TextView) itemView.findViewById(R.id.title_item);
            //设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in=new Intent(context,ThridActivity.class);
                    context.startActivity(in);
                }
            });
        }
    }
}
