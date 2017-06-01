package com.future.mqq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * Created by lenovo on 2017/5/26.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder>{

    private Context context;
   private List<ListTryBean.DataBean.TryBean> list;

    public ViewAdapter(Context context, List<ListTryBean.DataBean.TryBean> list) {
        this.context=context;
        this.list=list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(context).inflate(R.layout.item_course,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //进行赋值
        holder.name.setText(list.get(position).getTitle2());
        holder.person.setText(list.get(position).getSpeaker());
        Glide.with(context).load(list.get(position).getImage()).into(holder.im);
        holder.title.setText(list.get(position).getTitle());
        Log.i("xxxxobjec",list.get(position).getObject_id());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //创建viewhODLER
     class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView im;
        private final TextView title;
        private final TextView name;
        private final TextView person;

        public MyViewHolder(final View itemView) {
            super(itemView);
            //找到控件
            im = (ImageView) itemView.findViewById(R.id.course_titleimage);
            title = (TextView) itemView.findViewById(R.id.course_title_item);
            name = (TextView) itemView.findViewById(R.id.courseitem_classname);
            person = (TextView) itemView.findViewById(R.id.courseitem_name);

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
