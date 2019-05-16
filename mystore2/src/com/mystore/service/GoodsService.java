package com.mystore.service;

import java.util.List;

import com.mystore.dao.GoodsDao;
import com.mystore.domian.Goods;

public class GoodsService {

	public List<Goods> findAllGoods() {
		GoodsDao goodsDao = new GoodsDao();
		return goodsDao.findAllGoods();
	}

}
