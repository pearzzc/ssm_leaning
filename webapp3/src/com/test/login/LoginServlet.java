package com.test.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.test.domian.User;
import com.test.utils.Dbutils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ����ʽ
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//1.��ȡ�������
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		//���ܵĺ���Ĭ�����������ISO8859-1�ı�����ʽ��Ϊʹ�ò����ֺ������� Ҫ����ת��
		//��ԭ�еĺ���ת��Ϊ������
		byte[] bytes01 =name.getBytes("ISO8859-1");
		//����������UTF-8��ʽ���½��б���
		name = new String(bytes01, "UTF-8");
		
		System.out.println("name="+name+ " password="+password);
		
		//2.ʹ�� DbUtils ���ӵ����ݿ���
		QueryRunner queryRunner = new QueryRunner(Dbutils.getDataSourse());
		//׼��SQL���
		String sql = "select * from user where name=? and password=?";
		User user = null;
		try {
			 user = queryRunner.query(sql, new BeanHandler<User>(User.class),name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user!= null) {
			response.getWriter().write("����ɹ�������");
		}else {
			response.getWriter().write("����ʧ�ܣ�����");
		}
	}
}