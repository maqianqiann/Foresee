package com.mvvm.text;

import com.mvvm.text.bean.Person;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 创建容器，提供实例的对象
 * Created by lenovo on 2017/5/9.
 */
@Module
@Singleton
public class MainMoudule {

  private  String string;

  public MainMoudule(String string) {
      this.string=string;
  }

  //对外提供方法
    @Provides
    Person privoderPerson(){
        return  new Person(string);
    }

    //对外提供注解的方法
    @Provides
    String privoderString(){
        return string;
    }
}
