package com.test.code;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("code");
		byte[] bytes = word.getBytes("ISO8859-1");
		word = new String(bytes,"UTF-8");
		System.out.println(word);
		
		String checkCode = (String)this.getServletContext().getAttribute("checkCode");
		response.setContentType("text/html;charset=utf-8");
		if (word.equals(checkCode)) {
			response.getWriter().write("验证成功");
		} else {
			response.getWriter().write("验证失败");
		}
	}
}
