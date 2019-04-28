package com.zzc.demo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)applicationContext.getBean("user");
        User user2 = (User)applicationContext.getBean("user");
        System.out.println(user2);
       user.sayHello();
        System.out.println(user);
    }
}
