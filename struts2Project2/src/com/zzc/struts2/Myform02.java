package com.zzc.struts2;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.Date;

public class Myform02 extends ActionSupport {
    private String username;
    private Date age;
    private String[] hobby;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String execute(){
        System.out.println(username);
        System.out.println(age);
        System.out.println(Arrays.toString(hobby));
        return SUCCESS;
    }
}
