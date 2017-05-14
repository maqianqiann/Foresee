package com.retrofit.text.component;

import android.content.Context;

import com.retrofit.text.moduel.AppModuel;

import dagger.Component;

/**
 * Created by lenovo on 2017/5/11.
 * 这是将调用者和容器结合起来的桥梁
 * 这是父容器的桥梁，将上下文进行向下传递
 */
@Component(modules = AppModuel.class)
public interface MyComponent {
    Context proContext();//将上下文向下传递

}
