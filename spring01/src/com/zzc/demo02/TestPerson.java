package com.zzc.demo02;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {
    @Test
    public void test(){
        //加载核心配置文件 会帮助我们创建所有被管理的类的对象
        ClassPathXmlApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = (Person)ApplicationContext.getBean("person");
        System.out.println(person.name);
        //关闭工厂时，所有单例模式的类的对象被销毁
        ApplicationContext.close();
    }
}
