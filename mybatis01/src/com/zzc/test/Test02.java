package com.zzc.test;

import com.zzc.domain.Orders;
import com.zzc.domain.OrdersCustom;
import com.zzc.domain.User;
import com.zzc.mapper.UserMapper;
import com.zzc.mapper.UserMapperOrders;
import com.zzc.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test02 {
    @Test
    public void test1() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapperOrders userMapperOrders = sqlSession.getMapper(UserMapperOrders.class);
        List<OrdersCustom> orderUsers = userMapperOrders.findOrderUser();
        for (OrdersCustom orderUser : orderUsers) {
            System.out.println(orderUser);
        }
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void test2() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapperOrders userMapperOrders = sqlSession.getMapper(UserMapperOrders.class);
        List<Orders> orderUserMap = userMapperOrders.findOrderUserMap();
        for (Orders ordersCustom : orderUserMap) {
            System.out.println(ordersCustom);
        }
    }

    /*一对多*/
    @Test
    public void test3() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapperOrders userMapperOrders = sqlSession.getMapper(UserMapperOrders.class);
        List<Orders> map = userMapperOrders.findOrdersAndOrderDetailResultMap();
        for (Orders orders : map) {
            System.out.println(orders);
        }
        MybatisUtil.closeSqlSession();
    }

    @Test
    public void test4() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapperOrders user = sqlSession.getMapper(UserMapperOrders.class);
        List<User> userAndItemsResultMap = user.findUserAndItemsResultMap();
        for (User user1 : userAndItemsResultMap) {
            System.out.println(user1);
        }
    }
    @Test
    public void test5() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapperOrders userMapperOrders = sqlSession.getMapper(UserMapperOrders.class);
        List<Orders> ordersUserLazyLoading = userMapperOrders.findOrdersUserLazyLoading();
        for (Orders orders : ordersUserLazyLoading) {
            User user = orders.getUser();
            System.out.println(user);
        }
        MybatisUtil.closeSqlSession();
    }
    @Test
    public void test() throws Exception {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //下边查询使用一个SqlSession
        //第一次发起请求，查询id为1的用户
        User user1 = userMapper.findUserById(1);
        System.out.println(user1);

//		如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。

        //更新user1的信息
        user1.setUsername("测试用户22");
        userMapper.updateUser(user1);
        //执行commit操作去清空缓存
        sqlSession.commit();

        //第二次发起请求，查询id为1的用户
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);

        MybatisUtil.closeSqlSession();
    }
}
