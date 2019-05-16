package com.xuexi.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xuexi.domian.User;


@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求行信息
		//1.获取方法的方法名
		String method = request.getMethod();
		System.out.println("method="+method);
		
		//2.获取请求行的URL和URI
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("URL="+requestURL);
		String requestURI = request.getRequestURI();
		System.out.println("URI="+requestURI);
		
		//获取get参数的相关信息
		String queryString = request.getQueryString();
		System.out.println("getQueryString="+queryString);
		
		//获取项目名称
		String contextPath = request.getContextPath();
		System.out.println("contextPath="+contextPath);
		System.out.println();
		//获取请求头的相关信息
		Enumeration<String> headerNames = request.getHeaderNames();
		/*while (headerNames.hasMoreElements()) {
			String string = (String) headerNames.nextElement();
			System.out.println(string);
		}
		*/
		//获取对应请求头信息的内容
		while (headerNames.hasMoreElements()) {
			String name = (String) headerNames.nextElement();
			String value = request.getHeader(name);
			System.out.println(name+":"+value);
		}
		
		request.setCharacterEncoding("UTF-8");
		//获取一个参数
		String name = request.getParameter("name");
		System.out.println(name);
		
		//获取多个参数
		String[] names = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(names));
		
		//获取所有的参数名
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String string = (String) parameterNames.nextElement();
			System.out.println(string);
		}
		
		//获取所有的参数名和所对应的内容
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Map.Entry<String, String[]> entery : parameterMap.entrySet()) {
			System.out.println(entery.getKey()+":"+Arrays.toString(entery.getValue()));
		}
		User user = new User();
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(user);
	}
}
