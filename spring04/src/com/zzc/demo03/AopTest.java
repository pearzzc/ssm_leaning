package com.zzc.demo03;

import com.zzc.demo02.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
    //注入属性
    @Resource(name = "userDao")
    private UserDao userDao;
    @Test
    public void test(){
        /*this.userDao.save();*/
       /* this.userDao.update();*/
        this.userDao.find();
       /* this.userDao.delete();*/
    }
}
