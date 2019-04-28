package com.zzc.struts2;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

public class MyFrom2 extends ActionSupport {

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] valus = parameterMap.get(key);
            System.out.println(key+" "+ Arrays.toString(valus));
        }

        request.setAttribute("reqName","周泽冲");
        request.getSession().setAttribute("SessionName","zzc");
        ServletActionContext.getServletContext().setAttribute("a","as");
        return SUCCESS;
    }

}
