package com.mystore3.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mystore3.domain.Category;
import com.mystore3.utils.JdbcUtil;

public class CategoryDao {
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	public List<Category> findCategory() throws SQLException {
		String sql = "select * from category";
		List<Category> category = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
		return category;
	}

}
