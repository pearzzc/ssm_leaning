package com.zzc.test;

import com.zzc.domain.User;
import com.zzc.domain.UserQueryVo;
import com.zzc.mapper.UserMapper;
import com.zzc.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMybatis {
    @Test
    public void test1() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User userById = userMapper.findUserById(1);
        System.out.println(userById);
        MybatisUtil.closeSqlSession();
    }
    @Test
    public void test2() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByName("张");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void test3() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("细看退");
        user.setBirthday(new Date());
        user.setAddress("深圳");
        user.setSex("男");
        userMapper.addUser(user);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }
    @Test
    public void test4() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUSerById(26);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void test5() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        user.setUsername("张三");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("北京");
        userMapper.updateUser(user);
        sqlSession.commit();
        MybatisUtil.closeSqlSession();
    }
    @Test
    public void test6() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setUsername("张三");
        user.setSex("男");
        userQueryVo.setUser(user);
        List<User> userList = userMapper.findUserList(userQueryVo);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }
    @Test
    public void test7() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userByIdResultMap = userMapper.findUserByIdResultMap(1);
        System.out.println(userByIdResultMap);
        MybatisUtil.closeSqlSession();
    }
    @Test
    public void test8() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setSex("男");
        user.setUsername("张三");

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(20);
        userQueryVo.setIds(ids);

        userQueryVo.setUser(user);

        List<User> userList = userMapper.findUserList(userQueryVo);
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }
}
