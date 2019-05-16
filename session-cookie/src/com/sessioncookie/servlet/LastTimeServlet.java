package com.sessioncookie.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LastTimeServlet")
public class LastTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���÷������Ļ�����Ϣ�ı�����ʽ
		response.setContentType("text/html;charset=utf-8");
		//����ʱ���࣬������Ӧ��ʱ����и�ʽ��
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String format = simpleDateFormat.format(date);
		
		//����Cookie���󣬣��Ƿ�����д���������һ����Ϣ����������н��л��棩
		 Cookie cookie = new Cookie("lastTime",format);
		 response.addCookie(cookie);
		 
		 String lasttime = null;
		 //�������е�cookie �����ҵ�ָ������Cookie ��Ϣ
		 Cookie[] cookies = request.getCookies();
		 if(cookies!=null) {
			 for (Cookie cookie2 : cookies) {
				if (cookie2.getName().equals("lastTime")) {
					lasttime = cookie2.getValue();
				}
			}
		 }
		 	
		 if(lasttime!= null) {
			 response.getWriter().write("�ϴε����ʱ���ǣ�"+lasttime);
		 }else {
			 response.getWriter().write("���ǵ�һ�ε��룡");
		 }
	}
}
