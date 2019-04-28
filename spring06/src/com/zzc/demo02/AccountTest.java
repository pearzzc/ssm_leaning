package com.zzc.demo02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {
    @Resource(name="accountService")
    private AccountService accountService;
    @Test
    public void test(){
        this.accountService.transformMoney("1","2",100.0);
    }
}
