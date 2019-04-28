package com.zzc.test;

import com.zzc.dao.BooksMapper;
import com.zzc.domain.Books;
import com.zzc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test6 {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BooksMapper booksMapper = sqlSession.getMapper(BooksMapper.class);
        Books books = booksMapper.findBoooksById(1);
        System.out.println(books);
    }

}
