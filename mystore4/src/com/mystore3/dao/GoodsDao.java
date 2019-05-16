package com.mystore3.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mystore3.domain.Goods;
import com.mystore3.utils.JdbcUtil;

public class GoodsDao {
	//1��ȡ���е����е���Ʒ
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
	public List<Goods> getAllGoods() throws SQLException{
		List<Goods> allGoods = null;
		String sql = "select * from goods";
		allGoods = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
		return allGoods;
	}
	
	//2. ����id��ȡ����ĳ����Ʒ
	public void addGoods(Goods goods) throws SQLException {
		String sql = "insert into goods(g_name,g_price,g_image,g_desc,g_is_hot,g_cid) values(?,?,?,?,?,?)";
		queryRunner.update(sql,goods.getG_name(),goods.getG_price(),goods.getG_image(),goods.getG_desc(),
				goods.getG_is_hot(),goods.getG_cid());
	}
	//3.����idɾ��ĳ����Ʒ
	public void delGoods(int id) throws SQLException {
		String sql = "delete from goods where g_id=?";
		queryRunner.update(sql,id);
	}
	
	//3.�޸�ĳ����Ʒ����Ϣ
	public void updateGoods(Goods goods) throws SQLException {
		String sql = "update goods set g_name=?,g_price=?,g_image=?,g_desc=?,g_is_hot=?,g_cid=? where g_id=?";
		queryRunner.update(sql,goods.getG_name(),goods.getG_price(),goods.getG_image(),goods.getG_desc(),
				goods.getG_is_hot(),goods.getG_cid(),goods.getG_id());
	}

	public Goods findGoodsWithId(String id) throws Exception {
		String sql = "select * from goods where g_id=?";
		Goods goods = queryRunner.query(sql, new BeanHandler<Goods>(Goods.class),Integer.parseInt(id));
		return goods;
		
	}
}
