package com.zzc.demo01;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public void save() {
        System.out.println("在数据库中保存数据");
    }

    @Override
    public void update() {
        System.out.println("在数据库中跟新数据");
    }
}
