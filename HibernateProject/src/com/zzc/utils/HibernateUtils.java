package com.zzc.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//抽取的工具类，在使用Hibernate 框架时的基本步骤是：
/*
1。加载核心配置文件 hibernate.cfg.xml
2.创建sessionFactory对象 相当于JDBC 中的数据库的连接池
3.得到session 对象
 */
public class HibernateUtils {
    public static final SessionFactory sessionfactory;
    static {
        //加载核心配置文件
        Configuration configure = new Configuration().configure();
        //创建sessionFactory   ---JDBC 数据库的连接池
        sessionfactory = configure.buildSessionFactory();
    }

    //返回Session对象
    public static Session openSession(){
        Session session = sessionfactory.openSession();
        return session;
    }
    public static Session getCurrentSession(){
        Session session = sessionfactory.getCurrentSession();
        return session;
    }
}
