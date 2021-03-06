package com.mystore3;


import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		
		String path = null;
		//用反射进行改进
		
		try {
			Class<?> clazz = this.getClass();
			Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			method.setAccessible(true);
			if(method != null) {
				path = (String) method.invoke(this, request,response);
				
				if(path!=null) {
					request.getRequestDispatcher(path).forward(request, response);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
