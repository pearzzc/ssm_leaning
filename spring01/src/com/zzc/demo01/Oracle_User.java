package com.zzc.demo01;

public class Oracle_User implements UserDao {
    private String name;

    //用set 方法实现属性的注入
    public void setName(String name) {
        this.name = name;
    }

    public void init(){
        System.out.println("init Oracle");
    }
    public void destroy(){
        System.out.println("destroy Oracle");
    }
    @Override
    public void save() {
        System.out.println("oracle-save");
        System.out.println("name:"+name);
    }

    @Override
    public void delete() {
        System.out.println("oracle-delete");
    }
}
