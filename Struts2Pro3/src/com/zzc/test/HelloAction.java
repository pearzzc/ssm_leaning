package com.zzc.test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.zzc.domain.Goods;

public class HelloAction extends ActionSupport implements ModelDriven<Goods> {
    private Goods goods = new Goods();
    @Override
    public Goods getModel() {
        return goods;
    }
    public String execute(){

        //获取值栈，这里我们要知道值栈的核心就是OGNL  大致分两个部位： 根区 和 非根区
        // 根区:存放当前action相关的数据
        // 非根区：存放一些整个程序相关的数据和数据域 如 request session application
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        goods.setName("zzc");
        goods.setPrice(12.3);
        valueStack.getRoot().push(goods);

        valueStack.pop();
        ActionContext.getContext().put("reqname","reqvalue");
        ActionContext.getContext().getSession().put("Sessionname","SessionValue");
        ActionContext.getContext().getApplication().put("applicationname","reqvalue");
        System.out.println(goods);
        return SUCCESS;
    }

}
