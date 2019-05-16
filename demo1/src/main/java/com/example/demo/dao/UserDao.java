package com.example.demo.dao;


import com.example.demo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user where user.id=#{id}")
    User findUserById(int id);

    @Delete("delete from user where user.id=#{id}")
    void deleteUserById(int id);

    @Insert("insert into user(name,password,age,sex,address) values(#{name},#{password},#{age},#{sex},#{address})")
    void addUser(User user);

    /*@Update("update user set user.name=#{name},user.password=#{password},user.age=#{age},user.sex=#{sex},user.address=#{address} where user.id =#{id}")*/
    //使用配置文件进行配置
    void update(User user);

    @Select("select * from user")
    List<User> findAllUser();

    @Select("select * from user where user.name like #{name}")
    User findUserByName(String name);
}
