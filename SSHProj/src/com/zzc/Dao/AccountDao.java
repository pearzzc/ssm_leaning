package com.zzc.Dao;

import com.zzc.domain.Account;

import java.util.List;

public interface AccountDao {
    public void save(Account account);
    public void delete(Account account);
    public void update(Account account);
    public Account findByID(Integer id);
    public List<Account> findAll();
}
