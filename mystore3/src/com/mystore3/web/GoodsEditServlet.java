package com.mystore3.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mystore3.domain.Goods;
import com.mystore3.service.GoodsService;

@WebServlet("/GoodsEditServlet")
public class GoodsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("Ï²»¶Äã");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			goods.setG_image("goods1.png");
			GoodsService goodsService = new GoodsService();
			goodsService.updateGoods(goods);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/GoodsListServlet").forward(request, response);
	}

}
