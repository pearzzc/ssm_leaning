package com.mystore.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.mystore.domian.User;
import com.mystore.utils.JdbcUtil;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String checkcode = request.getParameter("checkcode");
		String word = (String) this.getServletContext().getAttribute("checkCode");
		if(checkcode.equals(word)) {
			response.getWriter().write("注册成功，即将跳转登入页面");
			Map<String, String[]> parameterMap = request.getParameterMap();
			User user = new User();
			try {
				BeanUtils.populate(user, parameterMap);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			user.setUid(UUID.randomUUID().toString());//设置uuid号，用于唯一标识
			QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "insert into user values(?,?,?,?)";
			try {
				queryRunner.update(sql,user.getUid(),user.getUname(),user.getPassword(),user.getPhone());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.setHeader("refresh", "3;url=/mystore2/login.jsp");
			System.out.println(user);
		}else {
			response.getWriter().write("验证错误，将重新跳到验证页面");
			response.setHeader("refresh", "3;url=/mystore2/regist.jsp"); 
		}
	}

}
