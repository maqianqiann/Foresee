package com.future.mqq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.future.mqq.R;
import com.future.mqq.activity.MoreActivity;
import com.future.mqq.bean.ListTryBean;

import java.util.List;

/**
 * Created by lenovo on 2017/5/23.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.MyViewHolder> {


    private Context context;
    private List<ListTryBean.DataBean.TryBean> list;

    public FirstAdapter(Context context, List<ListTryBean.DataBean.TryBean> list) {
        this.context = context;
        this.list=list;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.frist_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      //进行赋值
        holder.desc.setText(list.get(position).getTitle2());
        holder.ks.setText(list.get(position).getSpeaker());
        holder.title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView title;
        private final TextView desc;
        private final TextView ks;
        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_first);
            title = (TextView) itemView.findViewById(R.id.title_first);
            desc = (TextView) itemView.findViewById(R.id.desc_first);
            ks = (TextView) itemView.findViewById(R.id.ks_first);
            //进入课程的详情界面
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    Intent in=new Intent(context,MoreActivity.class);
                    //传值过去
                    in.putExtra("object_id",list.get(position).getObject_id());

                    context.startActivity(in);
                }
            });
        }
    }
}
