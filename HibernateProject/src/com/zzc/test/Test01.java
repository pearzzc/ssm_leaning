package com.zzc.test;

import com.zzc.domain.Customer;
import com.zzc.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import java.util.List;


public class Test01 {
    @Test
    public void testHibernite(){
        Session session = HibernateUtils.openSession();
        Customer customer = new Customer();
        customer.setCust_name("周冲");
        customer.setCust_level("1");
        customer.setCust_mobile("159892");
        customer.setCust_industry("java");
        customer.setCust_phone("1213");
        customer.setCust_sourse("hah");

        //对数据进行保存
        session.save(customer);
        //对数据的关闭
        session.close();
    }
    @Test
    public void testHibernite02(){
        Session session = HibernateUtils.openSession();
        //查询数据
        Customer customer = session.get(Customer.class, 12L);
        System.out.println(customer);
        //对数据的关闭
        session.close();
    }
    @Test
    public void testHibernite03(){
        Session session = HibernateUtils.openSession();
        //C3P0不会自动进行事务的提交
        //开启事务
        Transaction transaction = session.beginTransaction();
        /*//更新操作
        Customer customer = new Customer();
        customer.setCust_id(1L);
        customer.setCust_name("大西瓜");*/
        //更新操作2
        Customer customer = session.get(Customer.class, 12L);
        customer.setCust_name("java leaner");

        session.update(customer);
        //提交事务
        transaction.commit();
        //对数据的关闭
        session.close();
    }
    @Test
    //删除操作
    public void test04(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

       /* Customer customer = session.get(Customer.class, 1L);
        session.delete(customer);*/
        Customer customer = new Customer();
        customer.setCust_id(12L);
        session.delete(customer);
        transaction.commit();
        session.close();
    }
    @Test
    //查询或更新
    public void test05(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();//瞬时态
        customer.setCust_id(5L);
        customer.setCust_name("hjsdsa");
        customer.setCust_mobile("123456");
        session.saveOrUpdate(customer);//持久态,对象在持久态时数据可自己更新
        transaction.commit();
        session.close();
    }

    /*
    查询所有的信息HQL
     */
    @Test
    public void test06(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from com.zzc.domain.Customer");
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }

        transaction.commit();
        session.close();
    }
}
