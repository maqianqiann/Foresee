package com.rxjava.text;

/**
 * Created by lenovo on 2017/5/12.
 * 创建一个建造模式的类
 */

public class Person {

    //定义数据
    private String name;
    private int age;
    private String address;
    private String phone;

    //提供getSet的方法


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //创建一个私有的构造方法,属性是来自于建造者模式的属性

    private Person(Builder builer){
        this.name=builer.name;
        this.age=builer.age;
        this.address=builer.address;
        this.phone=builer.phone;
    }

    //创建一个静态的内部类
    static class Builder{
        //定义的成员变量和外部类的成员变量一致
        private String name;
        private int age;
        private String address;
        private String phone;
        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder age(int age){
            this.age=age;
            return this;
        }
        public Builder address(String address){
            this.address=address;
            return this;
        }
        public Builder phone(String phone){
            this.phone=phone;
            return this;
        }


        //调用外部类的私有的构造方法,属性就是Builder
        public Person build(){
            return new Person(this);
        }


    }

}
