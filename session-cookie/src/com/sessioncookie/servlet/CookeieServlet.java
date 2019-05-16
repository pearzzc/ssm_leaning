package com.sessioncookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookeieServlet")
public class CookeieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("lk", "it66");
		/*
		 * 默认情况下：cookie的有效级别是：回话级别。即关闭浏览器就会自动将cookie的信息进行删除
		 */
		//自己设置cookie 的有效时间
		//cookie.setMaxAge(60);
		//设置接受cookie的路径
		//cookie.setPath("/session-cookie/CookeieServlet2");
		response.addCookie(cookie);
	}

}
