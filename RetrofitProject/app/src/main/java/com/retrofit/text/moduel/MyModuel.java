package com.retrofit.text.moduel;

import android.content.Context;

import com.retrofit.text.bean.Person;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 2017/5/11.
 *这是子容器，将父容器传来的对象放入子容器中
 */


 @Module
public class MyModuel {
    //子容器的实例的对象需要上下文，这里的上下文是父容器传来的上下文
    @Provides
    Person providesPerson(Context context){
        return  new Person(context);
    }

}
