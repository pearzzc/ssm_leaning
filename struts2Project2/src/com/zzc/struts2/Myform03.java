package com.zzc.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzc.domain.User;

public class Myform03 extends ActionSupport implements ModelDriven<User> {
   private User user = new User();

    @Override
    public User getModel() {
        return user;
    }
    public String execute(){
        System.out.println(user);
        return SUCCESS;
    }


}
