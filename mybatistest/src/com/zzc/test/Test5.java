package com.zzc.test;

import com.zzc.domain.Books;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test5 {
    //根据用户id进行查询。findUserById
    @org.junit.Test
    public void test() throws IOException {
        //跟hibernate一样，需要获取一大堆东西
        // 1、读取配置文件
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行statement，并返回映射结果

        /*
         * test.findUserById:在映射配置文件中，mapper的namespace为test，
         *                     其中有一个select，也就代表查询的statement。
         * 1:输入参数为1
         * 返回的结果类型为User
         */
        Books books = new Books();
        books.setUid(1);
        books.setSal(12.11);
        books.setName("神风对绝");

        sqlSession.update("com.zzc.dao.BooksMapper.update",books);
        sqlSession.commit();
        //5、关闭sqlsession资源
        sqlSession.close();
    }
}
