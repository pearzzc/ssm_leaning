package com.zzc.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void delete() {
        System.out.println("从数据库中没删除数据");
    }
}
