package com.zzc.mapper;

import com.zzc.domain.User;
import com.zzc.domain.UserQueryVo;

import java.util.List;

public interface UserMapper {

    public User findUserById(int id)throws Exception;

    public List<User> findUserByName(String username)throws Exception;

    public void addUser(User user)throws Exception;

    public void deleteUSerById(int id)throws Exception;

    public void updateUser(User user)throws Exception;

    //用户信息综合查询
    public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;

    //根据id查询用户信息，使用resultMap输出
    public User findUserByIdResultMap(int id) throws Exception;

}
