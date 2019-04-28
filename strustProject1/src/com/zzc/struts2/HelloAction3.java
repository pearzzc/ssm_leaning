package com.zzc.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction3 extends ActionSupport {
    public String execute() throws Exception {
        System.out.println("Hello3--------");
        return "success";
    }
}
