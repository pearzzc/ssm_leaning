package com.zzc.demo03;

public class User {

    /* :默认调用无参的构造方法
     public User() {
        System.out.println("默认在创建对象是：调用无参的构造方法");
    }
     */
    public static User createUser(){
        System.out.println("调用静态的工厂创建对象");
        return new User();
    }
}
