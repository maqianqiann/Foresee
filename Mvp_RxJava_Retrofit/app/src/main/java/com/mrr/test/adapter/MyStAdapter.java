package com.mrr.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mrr.test.R;
import com.mrr.test.activity.ThridActivity;
import com.mrr.test.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/14.
 */

public class MyStAdapter extends RecyclerView.Adapter<MyStAdapter.ViewHolder>{

    private Context context;
    private List<UserBean.ResultBean.DataBean> listUser;
    public MyStAdapter(Context context, List<UserBean.ResultBean.DataBean> listUser) {
        this.context=context;
        this.listUser=listUser;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(listUser.get(position).getTitle());
        Glide.with(context).load(listUser.get(position).getThumbnail_pic_s()).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView im;
        private final TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.im_item);
            title = (TextView) itemView.findViewById(R.id.title_item);
        }
    }
}
