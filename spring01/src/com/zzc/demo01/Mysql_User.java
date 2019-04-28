package com.zzc.demo01;

public class Mysql_User implements UserDao {
    @Override
    public void save() {
        System.out.println("mysql-save");
    }

    @Override
    public void delete() {
        System.out.println("mysql-delete");
    }
}
