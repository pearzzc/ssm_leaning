package com.zzc.demo02;

import org.junit.Test;

public class CglibProxyTest {
    @Test
    public void test(){
        //创建一个实现类的对象
        UserDao userDao = new UserDao();
        //将实现类作为参数，调用代理类的构造方法，创建代理类的实例化对象
        CglibProxy cglibProxy = new CglibProxy(userDao);
        //用代理对象，得到一个实现类的子类的对象
        UserDao proxy = cglibProxy.createProxy();
        proxy.delete();
    }
}
