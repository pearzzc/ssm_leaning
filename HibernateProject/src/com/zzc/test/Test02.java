package com.zzc.test;

import com.zzc.domain.Customer;
import com.zzc.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Test02 {
    @Test
    public void test02(){
        //1.获取session 对象
        Session session = HibernateUtils.getCurrentSession();
        //2.开启事务
        Transaction transaction = session.beginTransaction();
        //进行个更具id的查询操作
        Customer customer = session.get(Customer.class,1L);
        //将第一次查寻到的数据放到一级缓存区中
        System.out.println(customer);

        //以后使用的时候会首先看一级缓存中有没有对应的数据
        customer.setCust_name("周泽冲");
        Customer customer2 = session.get(Customer.class,1L);
        System.out.println(customer2);
        //比较是不是在同一块区域
        System.out.println(customer==customer2);

        //3.进行事务的提交工作
        transaction.commit();
        //4.关闭session的资源
        session.close();
    }


}
