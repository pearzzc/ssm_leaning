package com.zzc.demo01;
/**
 * 记住使用JDK 实现动态代理 是面向接口的
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    //将要被增加功能的类传进来
    private GoodsDao goodsDao;
    //来个构造方法

    public JDKProxy(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
    //产生代理的方法
    public GoodsDao createProxy(){
        //创建代理对象
        GoodsDao userProxy = (GoodsDao)Proxy.newProxyInstance(goodsDao.getClass().getClassLoader(), goodsDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("save".equals(method.getName())){
                    System.out.println("执行回调的方法---");
                    System.out.println("进行日志记入");
                    return method.invoke(goodsDao,args);
                }
                return method.invoke(goodsDao, args);
            }
        });
        return userProxy;
    }
}
