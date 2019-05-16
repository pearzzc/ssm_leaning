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
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//1.获取请求参数
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		//接受的汉字默认浏览器会以ISO8859-1的编码形式，为使得不出现汉字乱码 要进行转码
		//将原有的汉字转化为二进制
		byte[] bytes01 =name.getBytes("ISO8859-1");
		//将二进制以UTF-8形式重新进行编码
		name = new String(bytes01, "UTF-8");
		
		System.out.println("name="+name+ " password="+password);
		
		//2.使用 DbUtils 连接到数据库中
		QueryRunner queryRunner = new QueryRunner(Dbutils.getDataSourse());
		//准备SQL语句
		String sql = "select * from user where name=? and password=?";
		User user = null;
		try {
			 user = queryRunner.query(sql, new BeanHandler<User>(User.class),name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user!= null) {
			response.getWriter().write("登入成功！！！");
		}else {
			response.getWriter().write("登入失败！！！");
		}
	}
}
