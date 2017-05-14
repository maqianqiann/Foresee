package com.mvvm.text;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mvvm.text.bean.Person;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Person person;      //获取注解的对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //提交代码第二次
        //快乐的小码农

       //建立注解的桥梁
        MainComponent build = DaggerMainComponent.builder().mainMoudule(new MainMoudule("aaa")).build();
        build.inject(this);
        //设置需要在注入之后
       /* person.setName("小码农");
        person.setAddress("北京");*/
        Log.i("person",person.toString()+person.name);

    }
}
