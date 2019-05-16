package com.mystore3.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mystore3.domain.Admin;
import com.mystore3.utils.JdbcUtil;

public class AdminDao {

	public Admin checkadmin(String name, String password) throws SQLException {
		//到数据库中查询数据
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select *from admin where name=? and password=?";
		Admin admin = null;
		
		admin = queryRunner.query(sql, new BeanHandler<Admin>(Admin.class),name,password);
		return admin;
	}
}
