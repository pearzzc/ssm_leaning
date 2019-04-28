package com.zzc.mapper;

import com.zzc.domain.Orders;
import com.zzc.domain.OrdersCustom;
import com.zzc.domain.User;

import java.util.List;

public interface UserMapperOrders {
    //一对一映射查询, 查询订单，关联查询用户信息:ResultType
    public List<OrdersCustom> findOrderUser() throws Exception;

    //一对一映射查询
    public List<Orders> findOrderUserMap() throws Exception;

    //ResultMap -对多映射
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    //多对多的高级映射
    //查询用户购买商品信息
    public List<User> findUserAndItemsResultMap() throws Exception;

    //测试延迟加载
    //查询订单，关联用户查询，用户查询用的是延迟加载
    public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
