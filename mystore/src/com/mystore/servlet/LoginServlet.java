package com.mystore.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mystore.domian.User;
import com.mystore.utils.JdbcUtil;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ý��ܵı����ʽ����ȡ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//ʹ��queryRunner �������ݿ�Ŀ��ٵ���ɾ��ģ���DButil�������ݿ������
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		User user =null;
		String sql = "select * from user where uname=? and password=? ";
		try {
			user = queryRunner.query(sql, new BeanHandler<User>(User.class),name,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user!=null) {
			response.getWriter().write("����ɹ�����������ҳ");
			response.setHeader("refresh", "3;url=/mystore/index.html");
		}else {
			response.getWriter().write("����ʧ�ܣ���������������ҳ��");
			response.setHeader("refresh", "3;url=/mystore/login.html");
		}
	}

}
