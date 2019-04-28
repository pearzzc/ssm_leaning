package com.zzc.test;


import com.zzc.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test(){
       /* UserService userService = new UserServiceImpl();
        userService.delete();*/
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService =(UserService) applicationContext.getBean("userService");
        userService.delete();
    }
}
