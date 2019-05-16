package com.mystore3.service;

import java.sql.SQLException;
import java.util.List;

import com.mystore3.dao.GoodsDao;
import com.mystore3.domain.Goods;

public class GoodsService {
	GoodsDao goodsDao = new GoodsDao();
	public List<Goods> findAllGoods() throws SQLException {
		
		List<Goods> allGoods = goodsDao.getAllGoods();
		return allGoods;
	}

	public void deleteGoods(String id) throws Exception {
		
		goodsDao.delGoods(Integer.parseInt(id));
	}

	public void addGoods(Goods goods) throws Exception {
		goodsDao.addGoods(goods);
		
	}

	public Goods findGoodsWithId(String id) throws Exception {
		Goods goods = goodsDao.findGoodsWithId(id);
		return goods;
	}

	public void updateGoods(Goods goods) throws Exception {
		goodsDao.updateGoods(goods);
		
	}

}
