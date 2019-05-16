package com.mystore3.service;

import java.sql.SQLException;
import java.util.List;

import com.mystore3.dao.CategoryDao;
import com.mystore3.domain.Category;

public class CategoryService {

	public List<Category> findCategory() throws SQLException {
		CategoryDao categoryDao = new CategoryDao();
		List<Category> category = categoryDao.findCategory();
		return category;
	}

}
