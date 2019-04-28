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

        //��ȡֵջ����������Ҫ֪��ֵջ�ĺ��ľ���OGNL  ���·�������λ�� ���� �� �Ǹ���
        // ����:��ŵ�ǰaction��ص�����
        // �Ǹ��������һЩ����������ص����ݺ������� �� request session application
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
