package com.retrofit.text.moduel;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 2017/5/11.
 * 父容器
 * 用于存放实例的容器,这存放的是一个上下文的实例对象，对外提供时方便使用
 */
@Module
public class AppModuel {
       //创建一个实例化的对象
    Context context;
    //对外提供Context对象

    public AppModuel(Context context) {
        this.context = context;
    }

    @Provides
    Context providesConext(){
        return context;
    }

}
