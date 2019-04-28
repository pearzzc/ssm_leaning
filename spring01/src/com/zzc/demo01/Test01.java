package com.zzc.demo01;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01(){
       //加载核心配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //通过反射实现类对象的实例化，用xml 配置文件管理类
        UserDao userDao = (UserDao)classPathXmlApplicationContext.getBean("userDao");
        UserDao userDao2 = (UserDao)classPathXmlApplicationContext.getBean("userDao");
        //经过测试我们可以知道，spring 管理的类 默认是单例模式
        System.out.println(userDao);
        System.out.println(userDao2);
        userDao.save();
        userDao.delete();

    }
}
