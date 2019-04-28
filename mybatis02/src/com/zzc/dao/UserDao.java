package com.zzc.dao;

import com.zzc.domain.User;

import java.util.List;

public interface UserDao {
    public User findUserById(int id) throws Exception;

    public List<User> findUserByUsername(String username) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;

    public void updateUser(User user) throws Exception;
}
