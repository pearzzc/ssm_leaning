package com.test.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������Ӧ��
		response.setStatus(200);
		
		/*//������Ӧ��Ӧͷ
		response.addHeader("name", "zzx");
		response.addIntHeader("age", 100);
		response.addDateHeader("now_time", new Date().getTime());
		*/
		//������Ӧͷ
		response.setHeader("name", "zzz");
		response.setIntHeader("age", 12);
		response.setDateHeader("now_time", new Date().getTime());
		
		//�����ض���
		/*	response.setHeader("refresh","3;url=http://www.baidu.com");*/
		//����response�������ı�����ʽUTF-8;
		response.setCharacterEncoding("UTF-8");
		//�����������ʲô���ı���ȥ���н�����Ϣ
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.getWriter().write("����");
	}

}
