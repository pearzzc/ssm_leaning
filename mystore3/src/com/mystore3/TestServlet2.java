package com.mystore3;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet2")
public class TestServlet2 extends BaseServlet {
	
	protected String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("添加");
		return "add.jsp";
	}
	
	protected String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("删除");
		return "del.jsp";
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("更新");
		return "update.jsp";
	}
	protected String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("更新");
		return "find.jsp";
	}
}
