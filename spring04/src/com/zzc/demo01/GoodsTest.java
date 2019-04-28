package com.zzc.demo01;

import org.junit.Test;

public class GoodsTest {
    @Test
    public void test(){
        GoodsDao goodsDao = new GoodsDaoImpl();
        /*goodsDao.update();
        goodsDao.save();*/
        JDKProxy jdkProxy = new JDKProxy(goodsDao);
        GoodsDao proxy = jdkProxy.createProxy();
        proxy.save();
        proxy.update();
    }
}
