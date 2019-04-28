package com.zzc.demo02;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transformMoney(String from, String to, Double money) {
        accountDao.addmoney(to,money);
        int i = 1/0;
        accountDao.minusmoney(from,money);
    }
}
