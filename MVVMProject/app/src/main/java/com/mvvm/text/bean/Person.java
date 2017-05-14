package com.mvvm.text.bean;

import android.util.Log;

/**
 * Created by lenovo on 2017/5/9.
 */

public class Person {
    //创建bean对象
    public String name;
    public String address;

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   /* public Person() {
        Log.i("Person","创建对象中。。。");
    }*/
    //创建有参构造

    public Person(String name) {
        this.name = name;
        Log.i("Person","创建对象中2。。。");
    }
}
