package com.mystore3.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystore3.service.GoodsService;


@WebServlet("/GoodsDelServlet")
public class GoodsDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.deleteGoods(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/GoodsListServlet").forward(request, response);
	}
}
