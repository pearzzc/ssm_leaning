package com.zzc.denmo5;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试方法
 */
public class StudentTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取实例化对象
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
