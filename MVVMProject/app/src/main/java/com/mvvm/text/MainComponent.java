package com.mvvm.text;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 这是中间的桥梁
 * Created by lenovo on 2017/5/9.
 */
@Singleton
@Component (modules = MainMoudule.class)
public interface MainComponent {

      //定义注入的方法
    void inject(MainActivity activity);


}
