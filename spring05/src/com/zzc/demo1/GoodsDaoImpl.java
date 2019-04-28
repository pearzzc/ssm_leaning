package com.zzc.demo1;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public void add() {
        System.out.println("增加");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void find() {
        System.out.println("查找");
        /*int i =1/0;*/
    }

    @Override
    public void update() {
        System.out.println("更新");
    }
}
