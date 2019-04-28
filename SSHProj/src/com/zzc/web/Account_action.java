package com.zzc.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzc.domain.Account;
import com.zzc.service.AccountService;


public class Account_action extends ActionSupport implements ModelDriven<Account> {
    private Account account = new Account();

    private AccountService accountService;
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Account getModel() {
        return account;
    }

    public String save(){
        //使用原始的方法
//        AccountService accountService = new AccountServiceImpl();
//        accountService.save(account);
        //使用Spring管理业务层类
       /* ServletContext servletContext = ServletActionContext.getServletContext();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        accountService.save(account);*/
       accountService.save(account);
        return null;
    }

}

