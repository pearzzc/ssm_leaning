package com.zzc.Dao;

import com.zzc.domain.Account;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao{
    @Override
    public void save(Account account) {
//        System.out.println("到达dao层"+account);
        this.getHibernateTemplate().save(account);
    }

    @Override
    public void delete(Account account) {
        this.getHibernateTemplate().delete(account);
    }

    @Override
    public void update(Account account) {
        this.getHibernateTemplate().update(account);
    }

    @Override
    public Account findByID(Integer id) {
        Account account = this.getHibernateTemplate().get(Account.class, id);
        return account;
    }

    @Override
    public List<Account> findAll() {
        //使用QBZ
        /*List<Account> list = (List<Account>)this.getHibernateTemplate().find("from account");*/
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Account.class);
        List<Account> list = (List<Account>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
}
