package com.zzc.demo03;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl  implements AccountDao {
    //这一步可以简化 extends JdbcDaoSupport/在这里我直接用最直观的测试
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addmoney(String name, Double money) {
        jdbcTemplate.update("update account set money= money+? where name =?",money,name);
    }

    @Override
    public void minusmoney(String name, Double money) {
        jdbcTemplate.update("update account set money = money-? where name=?",money,name);
    }
}
