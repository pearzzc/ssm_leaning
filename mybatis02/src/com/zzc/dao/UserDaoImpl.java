package com.zzc.dao;

import com.zzc.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    // 通过Spring注入
    private SqlSessionFactory sqlSessionFactory;

    // 将sqlSessionFactory注入
    @Override
    public User findUserById(int id) throws Exception {

        SqlSession sqlSession = this.getSqlSession();

        User user = sqlSession.selectOne("test.findUserById", id);
        return user;

    }

    // 根据用户名称模糊查询用户列表
    @Override
    public List<User> findUserByUsername(String username) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        List<User> list = sqlSession.selectList("test.findUserByName", username);
        return list;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.insert("test.insertUser", user);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.delete("test.deleteUser",id);
    }

    @Override
    public void updateUser(User user) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.update("test.updateUser", user);
    }
}
