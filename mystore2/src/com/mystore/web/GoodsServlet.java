package com.mystore.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mystore.domian.Goods;
import com.mystore.service.GoodsService;
import com.mystore.utils.JdbcUtil;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据库连接
		/*QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select *from goods";
		List<Goods> allGoods = null;
		try {
			allGoods = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allGoods", allGoods);
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);*/
		GoodsService goodsService = new GoodsService();
		List<Goods> allGoods = goodsService.findAllGoods();
		
		request.setAttribute("allGoods", allGoods);
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
	}

}
