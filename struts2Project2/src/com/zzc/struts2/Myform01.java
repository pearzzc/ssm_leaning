package com.zzc.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Myform01 extends ActionSupport {
    public String execute(){
        //获取参数
        ActionContext context = ActionContext.getContext();
        HttpParameters parameters = context.getParameters();
        Set<Map.Entry<String, Parameter>> entries = parameters.entrySet();
        for (Map.Entry<String, Parameter> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(Arrays.toString(entry.getValue().getMultipleValues()));
        }
        System.out.println("/////////////////////////////////////");
        String username = parameters.get("username").getValue();
        String nick = parameters.get("nick").getValue();
        String[] hobbies = parameters.get("hobby").getMultipleValues();
//       先将其进行打印显示
        System.out.println(username);
        System.out.println(nick);
        System.out.println(Arrays.toString(hobbies));

        context.put("username",username);
        context.put("nick",nick);
        context.put("hobbies",hobbies);

        return SUCCESS;
    }
}
