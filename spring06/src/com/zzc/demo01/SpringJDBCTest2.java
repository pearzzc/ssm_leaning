package com.zzc.demo01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//注解形式：加载核心配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJDBCTest2 {
    //注入属性
    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Test
    /**
     * 插入
     */
    public void test1(){
        jdbcTemplate.update("insert into account values (null ,?,?)","鼠标55","123");
    }
    @Test
    /**
     * 删除
     */
    public void test2(){
        jdbcTemplate.update("delete from account where id=?","7");
    }
    @Test
    /**
     * 更新
     */
    public void test3(){
        jdbcTemplate.update("update account  set name=?,money=? where id=?","zhu",1234,8);
    }
}
