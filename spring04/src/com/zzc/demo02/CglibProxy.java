package com.zzc.demo02;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {
    //传入实现类
    private UserDao userDao;

    //构造方法
    public CglibProxy(UserDao userDao) {
        this.userDao = userDao;
    }
    public UserDao createProxy(){
        //创建cglib的核心类对象
        Enhancer enhancer = new Enhancer();

        //采用的是继承的方法来产生代理对象，自动创建实现类的子类
        enhancer.setSuperclass(userDao.getClass());

        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("检测");
                return methodProxy.invokeSuper(o,objects);
            }
        });

        //创建代理对象，返回的是字类对象
        UserDao obj = (UserDao)enhancer.create();
        return obj;
    }
}
