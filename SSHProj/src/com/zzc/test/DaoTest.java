package com.zzc.test;

import com.zzc.Dao.AccountDao;
import com.zzc.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class DaoTest {
    @Resource(name = "accountDao")
    private AccountDao accountDao;
    @Test

    public void test(){
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
    @Test
    public void test1() {
        Account account = accountDao.findByID(2);

        account.setMoney(11555d);
        accountDao.update(account);
        System.out.println(account);
    }

    @Test
    public void test2(){
        Account account = new Account();
        account.setMoney(123d);
        account.setName("zzc");
        accountDao.save(account);
    }

    @Test
    public void test3(){
        Account byID = accountDao.findByID(1);
        accountDao.delete(byID);
    }

}
