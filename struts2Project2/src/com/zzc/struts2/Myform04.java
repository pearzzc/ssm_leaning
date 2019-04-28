package com.zzc.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.zzc.domain.Goods;

import java.util.List;

public class Myform04 extends ActionSupport  {
    private List<Goods> goodsList;


    public String execute(){
        System.out.println(goodsList);
        return null;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

}
