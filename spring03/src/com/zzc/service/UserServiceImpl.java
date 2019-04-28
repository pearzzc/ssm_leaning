package com.zzc.service;

import com.zzc.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl  implements UserService{
    private UserDao userDao;
    @Resource(name="userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void delete() {
        userDao.delete();
    }
}
