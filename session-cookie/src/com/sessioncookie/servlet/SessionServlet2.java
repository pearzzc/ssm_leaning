package com.sessioncookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionServlet2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//��ȡ��Ӧ��������ֵ
		/*String attribute = (String) session.getAttribute("jd");
		System.out.println("��ȡ��Ӧ Servlet ��Ϣ �������Ϊ��"+attribute);*/
		//Ĭ������� ������رջ����cookie��ֵ�������������cookie����ʽ��session����ı�ʶ�������������
		//���Բ���������ر���Session �����������������
		/*
		 * �����ٵ�������������֣�
		 * 	�رշ�������ʹ��session�ķ���session.invalidate(),�ֶ�����session ����������
		 * ���о���session���ڣ�Ĭ����30���ӣ�
		 */
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60*2);
		cookie.setPath("/session-cookie");
		response.addCookie(cookie);
		System.out.println(cookie.getValue());
		System.out.println(session);
	}
}
