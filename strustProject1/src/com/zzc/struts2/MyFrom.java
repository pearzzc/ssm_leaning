package com.zzc.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class MyFrom extends ActionSupport {

    public String execute() {
        //获取参数
        ActionContext context = ActionContext.getContext();
        HttpParameters parameters = context.getParameters();
        //获取所有参数
        Set<Map.Entry<String, Parameter>> entries = parameters.entrySet();

        for (Map.Entry<String, Parameter> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(Arrays.toString(entry.getValue().getMultipleValues()));
        }

        String user = parameters.get("user").getValue();
        String psw = parameters.get("nick").getValue();
        String[] hobis = parameters.get("hobby").getMultipleValues();
        System.out.println(Arrays.toString(hobis));


//       向域对象中写入数据
        context.put("zzc","周泽冲");
        context.getSession().put("zaq",user);
        return SUCCESS;
    }

}
