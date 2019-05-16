package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    UserDao userDao;
    @Test
    public void testFindById() {
        System.out.println(userDao.findUserById(1));
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setName("dad");
        user.setPassword("12345");
        user.setAge(1);
        user.setAddress("小书包星球");
        user.setSex("a");
        userDao.addUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUserById(3);
    }
    @Test
    public void testUpdateUser(){
        User user = userDao.findUserById(2);
        user.setAddress("火星");
        user.setName("鼠标哈哈哈哈");
        userDao.update(user);
        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        List<User> allUser = userDao.findAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByName(){
        User user = userDao.findUserByName("闪光灯");
        System.out.println(user);
    }
}
