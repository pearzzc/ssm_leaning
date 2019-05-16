package com.mystore3;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystore3.web.BaseServlet;

@WebServlet("/TestServlet2")
public class TestServlet2 extends BaseServlet {
	
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("���");
		return "add.jsp";
	}
	
	public String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("ɾ��");
		return "del.jsp";
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("����");
		return "update.jsp";
	}
	public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("����");
		return "find.jsp";
	}
}
