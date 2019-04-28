package com.zzc.demo03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void test(){
        //加载核心配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //找到对应的类
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
