package com.mystore3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = null;
		if("add".equals(action)) {
			path=add(request,response);
		}else if("del".equals(action)){
			path=del(request,response);
		}else if("update".equals(action)) {
			path=update(request,response);
		}
		if(path!=null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}
	protected String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Ìí¼Ó");
		return "add.jsp";
	}
	
	protected String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("É¾³ý");
		return "del.jsp";
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("¸üÐÂ");
		return "update.jsp";
	}
}
