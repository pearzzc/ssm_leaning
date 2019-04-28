package com.zzc.test;

import com.zzc.dao.UserDao;
import com.zzc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestDao {
    @Resource(name = "userDao")
    private UserDao userDao;
    @Test
    public void testFindUserById() throws Exception {
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername() throws Exception {
        List<User> users = userDao.findUserByUsername("明");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testInsertUser()throws Exception{
        User user = new User();
        user.setUsername("沙哈受到国际奥赛飞洒");
        user.setSex("男");
        user.setAddress("jiji");
        user.setBirthday(new Date());
        userDao.insertUser(user);
    }
    @Test
    public void testDeleteUser()throws Exception{
        userDao.deleteUser(31);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("大佬哈");
        user.setAddress("大佬个111");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }
}
