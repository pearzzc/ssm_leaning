package com.mystore3.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.mystore3.dao.GoodsDao;
import com.mystore3.domain.Goods;

public class GoodsTest {
	GoodsDao goodsDao = new GoodsDao();
	@Test
	public void testgetAllGoods() throws SQLException {
		List<Goods> allGoods = goodsDao.getAllGoods();
		System.out.println(allGoods);
	}
	
	@Test
	public void  testAddGoods() throws SQLException {
		Goods goods = new Goods();
		goods.setG_name("ÀèÃ÷");
		goods.setG_price(76.0);
		goods.setG_image("goods18.png");
		goods.setG_desc("sd");
		goods.setG_is_hot(1);
		goods.setG_cid(2);
		goodsDao.addGoods(goods);
	}
	@Test
	public void  testDelGoods() throws SQLException {
		
		goodsDao.delGoods(21);
	}
	@Test
	public void  testUpdateGoods() throws SQLException {
		Goods goods = new Goods();
		goods.setG_name("ÀèÃ÷12");
		goods.setG_price(85.2);
		goods.setG_image("goods19.png");
		goods.setG_desc("dsd");
		goods.setG_is_hot(0);
		goods.setG_cid(1);
		goods.setG_id(17);
		goodsDao.updateGoods(goods);
	}
}
