package com.zzc.test;

import com.zzc.domain.Books;
import com.zzc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class Test2 {
    //根据用户id进行查询。findUserById
    @org.junit.Test
    public void test() throws IOException {
        /*使用抽出的工具类*/
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        Books books = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(books);

        //5、关闭sqlsession资源
        MybatisUtil.closeSqlSession();
    }
}
