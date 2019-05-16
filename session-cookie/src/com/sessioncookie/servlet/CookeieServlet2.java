package com.sessioncookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookeieServlet2")
public class CookeieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Cookie cookie = new Cookie("lk", "it66");
		cookie.setMaxAge(0);
		response.addCookie(cookie);*/
		Cookie[] cookies = request.getCookies();
		if (cookies!= null) {
			for (Cookie cookie : cookies) {
				//ªÒ»°cookie√˚
				String name = cookie.getName();
				if (name.equals("lk")) {
					response.getWriter().write(cookie.getValue());
				}
			}
		}
	}

}
