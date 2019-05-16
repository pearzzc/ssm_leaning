package com.test.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("Destroy...");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	/**
	 * 默认时第一次访问时，待用此方法
	 * 也可以使用配置文件进行配置：设置服务器已启动就就创建Servlet对象
	 * 创建的对象会陪缓存起来
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init01...");
		//参数ServletConfig 可以获取一些配置信息
		String name = arg0.getServletName();
		System.out.println("配置信息ServletName:"+name);
		
		//还可以获取配置文件中的初始化参数
		
		String name01 = arg0.getInitParameter("周泽冲");
		System.out.println("InitParameter="+name01);
		
	}

	//服务器每次发出请求时都会调用此方法
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service...");
	}

}
