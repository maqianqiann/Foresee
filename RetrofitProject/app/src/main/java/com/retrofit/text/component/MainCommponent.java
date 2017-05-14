package com.retrofit.text.component;

import com.retrofit.text.MainActivity;
import com.retrofit.text.moduel.AppModuel;
import com.retrofit.text.moduel.MyModuel;

import dagger.Component;

/**
 * Created by lenovo on 2017/5/11.
 * 这是子桥梁，连接调用者和容器,并且与父桥梁关联起来
 */

@Component (dependencies = MyComponent.class,modules = MyModuel.class)
public interface MainCommponent {
    //写个注入的方法
    void inject(MainActivity activity);

}
