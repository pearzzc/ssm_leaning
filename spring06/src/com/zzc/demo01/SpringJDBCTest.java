package com.zzc.demo01;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringJDBCTest {
    @Test
    public void test(){
        //创建连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");

        //创建jdbc 模板，传进的参数是数据库的数据源，使用的是：spring内置的对象JDBC 直接进行数据库的语句操作
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //直接使用sql 语句： 传进进的参数，可以先写？ 在后边的可变参数中进行参数的补充
        jdbcTemplate.update("insert into account values (null ,?,?)","周末","123");
    }
}
