package com.mystore3.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystore3.domain.Category;
import com.mystore3.domain.Goods;
import com.mystore3.service.CategoryService;
import com.mystore3.service.GoodsService;

@WebServlet("/GoodsEditUIServlet")
public class GoodsEditUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			request.getRequestDispatcher("/admin/edit.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
