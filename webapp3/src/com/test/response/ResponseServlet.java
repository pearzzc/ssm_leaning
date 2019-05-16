package com.test.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置响应行
		response.setStatus(200);
		
		/*//设置相应相应头
		response.addHeader("name", "zzx");
		response.addIntHeader("age", 100);
		response.addDateHeader("now_time", new Date().getTime());
		*/
		//设置响应头
		response.setHeader("name", "zzz");
		response.setIntHeader("age", 12);
		response.setDateHeader("now_time", new Date().getTime());
		
		//设置重定向
		/*	response.setHeader("refresh","3;url=http://www.baidu.com");*/
		//设置response缓冲区的编码形式UTF-8;
		response.setCharacterEncoding("UTF-8");
		//告诉浏览器用什么样的编码去进行接受信息
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.getWriter().write("张三");
	}

}
