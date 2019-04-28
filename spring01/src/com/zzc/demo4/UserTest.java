package com.zzc.demo4;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user2 = (User) applicationContext.getBean("user2");
        System.out.println("user2的地址是:"+user2);
    }
}
