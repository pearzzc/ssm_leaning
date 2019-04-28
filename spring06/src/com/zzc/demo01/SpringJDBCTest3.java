package com.zzc.demo01;

import com.zzc.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//注解形式：加载核心配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJDBCTest3 {
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

    @Test
    /**
     * 查询一个对象
     */
    public void test4(){
        Account account = jdbcTemplate.queryForObject("select *from account where id = ?", new MyRowMaping(), "11");
        System.out.println(account);
    }

    /**
     * 查一组数据
     */

    @Test
    public void test5(){
        List<Account> query = jdbcTemplate.query("select * from account", new MyRowMaping());
        for (Account account : query) {
            System.out.println(account);
        }
    }
    //使用要实现相应的接口，接口的泛型类是模型类，模型类提供setget 方法 Spring 会自动将其封装成对象
    class MyRowMaping implements RowMapper<Account>{

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getDouble("money"));
            return account;
        }
    }
}
