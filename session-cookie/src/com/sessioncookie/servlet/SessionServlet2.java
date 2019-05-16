package com.sessioncookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionServlet2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//获取对应的域对象的值
		/*String attribute = (String) session.getAttribute("jd");
		System.out.println("获取对应 Servlet 信息 的域对象为："+attribute);*/
		//默认情况下 浏览器关闭会清空cookie的值，而浏览器会以cookie的形式将session对象的标识符存在浏览器中
		//所以不是浏览器关闭了Session 对象的域对象就销毁了
		/*
		 * 它销毁的情况大致有三种：
		 * 	关闭服务器；使用session的方法session.invalidate(),手动销毁session 对象的域对象
		 * 还有就是session过期（默认事30分钟）
		 */
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60*2);
		cookie.setPath("/session-cookie");
		response.addCookie(cookie);
		System.out.println(cookie.getValue());
		System.out.println(session);
	}
}
