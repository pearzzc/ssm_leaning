package com.zzc.mapper;

import com.zzc.domain.User;
import com.zzc.domain.UserQueryVo;

import java.util.List;

public interface UserMapper {

	//根据id 获取user
	public User findUserById(int id) throws Exception;
	//名字查
	public List<User> findUserByName(String name) throws Exception;
	//查全部
	public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;
	//ResultMap id查
	public User findUserByIdResultMap(int id) throws Exception;
	//插
	public void insertUser(User user) throws Exception;
	//删
	public void deleteUser(int id) throws Exception;
	//更新
	public void updateUser(User user) throws Exception;

	public int findUserCount(String username) throws Exception;
}	
