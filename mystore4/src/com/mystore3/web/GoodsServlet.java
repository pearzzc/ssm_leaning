package com.mystore3.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mystore3.domain.Category;
import com.mystore3.domain.Goods;
import com.mystore3.service.CategoryService;
import com.mystore3.service.GoodsService;


@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
	
	public String findListGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> findAllGoods = goodsService.findAllGoods();
			Collections.reverse(findAllGoods);
			request.setAttribute("allGoods", findAllGoods);
			return "admin/main.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String delGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.deleteGoods(id);
			return "/GoodsServlet?action=findListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String addULGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CategoryService categoryService = new CategoryService();
		try {
			//找到商品分类
			List<Category> category = categoryService.findCategory();
			//存储数据到request域中
			request.setAttribute("category", category);
			//转发到edit.jsp
			return "/admin/add.jsp";
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public String addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			GoodsService goodsService = new GoodsService();
			goods.setG_image("goods1.png");
			goodsService.addGoods(goods);
			return "/GoodsServlet?action=findListGoods";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public String editUIGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		try {
			//1.获取商品信息
			GoodsService goodsService = new GoodsService();
			Goods goods = goodsService.findGoodsWithId(id);
			request.setAttribute("goods", goods);
			//2.获取分类信息
			CategoryService categoryService = new CategoryService();
			List<Category> categorys = categoryService.findCategory();
			request.setAttribute("category",categorys);
			//2.转发的edit.JSP页面
			return "/admin/edit.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String editGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setG_image("goods1.png");
			GoodsService goodsService = new GoodsService();
			goodsService.updateGoods(goods);
			return "/GoodsServlet?action=findListGoods";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
