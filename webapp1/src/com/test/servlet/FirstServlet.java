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
	 * Ĭ��ʱ��һ�η���ʱ�����ô˷���
	 * Ҳ����ʹ�������ļ��������ã����÷������������;ʹ���Servlet����
	 * �����Ķ�����㻺������
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init01...");
		//����ServletConfig ���Ի�ȡһЩ������Ϣ
		String name = arg0.getServletName();
		System.out.println("������ϢServletName:"+name);
		
		//�����Ի�ȡ�����ļ��еĳ�ʼ������
		
		String name01 = arg0.getInitParameter("�����");
		System.out.println("InitParameter="+name01);
		
	}

	//������ÿ�η�������ʱ������ô˷���
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service...");
	}

}
