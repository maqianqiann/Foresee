package com.future.mqq.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by lenovo on 2017/5/23.
 * 创建banner的工具类，继承banner的图片加载的类
 *
 */

public class ImageUtils extends ImageLoader {


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //进行设置
        Glide.with(context).load(path).into(imageView);

    }
}
