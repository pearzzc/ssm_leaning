package com.mystore3.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystore3.domain.Category;
import com.mystore3.service.CategoryService;


@WebServlet("/GoodsAddUIServlet")
public class GoodsAddUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryService categoryService = new CategoryService();
		try {
			//�ҵ���Ʒ����
			List<Category> category = categoryService.findCategory();
			//�洢���ݵ�request����
			request.setAttribute("category", category);
			//ת����edit.jsp
			request.getRequestDispatcher("/admin/add.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
