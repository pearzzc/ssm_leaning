package com.zzc.service;

import com.zzc.Dao.AccountDao;
import com.zzc.domain.Account;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(Account account) {
        System.out.println("到达service层 "+account);
        accountDao.save(account);
    }
}
