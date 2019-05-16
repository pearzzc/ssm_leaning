package com.sessioncookie.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LastTimeServlet")
public class LastTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置服务器的缓存信息的编码形式
		response.setContentType("text/html;charset=utf-8");
		//声明时间类，并将对应的时间进行格式化
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String format = simpleDateFormat.format(date);
		
		//创建Cookie对象，（是服务器写给浏览器的一个信息，在浏览器中进行缓存）
		 Cookie cookie = new Cookie("lastTime",format);
		 response.addCookie(cookie);
		 
		 String lasttime = null;
		 //遍历所有的cookie 从中找到指定名的Cookie 信息
		 Cookie[] cookies = request.getCookies();
		 if(cookies!=null) {
			 for (Cookie cookie2 : cookies) {
				if (cookie2.getName().equals("lastTime")) {
					lasttime = cookie2.getValue();
				}
			}
		 }
		 	
		 if(lasttime!= null) {
			 response.getWriter().write("上次登入的时间是："+lasttime);
		 }else {
			 response.getWriter().write("你是第一次登入！");
		 }
	}
}
