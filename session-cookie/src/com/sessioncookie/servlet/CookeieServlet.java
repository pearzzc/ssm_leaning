package com.sessioncookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookeieServlet")
public class CookeieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("lk", "it66");
		/*
		 * Ĭ������£�cookie����Ч�����ǣ��ػ����𡣼��ر�������ͻ��Զ���cookie����Ϣ����ɾ��
		 */
		//�Լ�����cookie ����Чʱ��
		//cookie.setMaxAge(60);
		//���ý���cookie��·��
		//cookie.setPath("/session-cookie/CookeieServlet2");
		response.addCookie(cookie);
	}

}
