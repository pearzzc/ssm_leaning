package com.mystore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mystore.domian.Goods;
import com.mystore.utils.JdbcUtil;

public class GoodsDao {

	public List<Goods> findAllGoods() {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select *from goods";
		List<Goods> allGoods = null;
		try {
			allGoods = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allGoods;
	}

}
