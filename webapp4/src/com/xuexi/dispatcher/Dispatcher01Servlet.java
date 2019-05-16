package com.xuexi.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Dispatcher01Servlet")
public class Dispatcher01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Dispatcher02Servlet");
		request.setAttribute("zzc", "÷‹‘Û≥Â");
		requestDispatcher.forward(request, response);
	}

}
