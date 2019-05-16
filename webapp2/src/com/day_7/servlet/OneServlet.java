package com.day_7.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day_7.domian.User;

/**
 * Servlet implementation class OneServlet
 */
@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * 直接这样写会报空指针异常 ，因为this对象调用额ServletContext 对象是来源于父类的init 方法的config对象
	 * 在本类中重写了父类的init 方法会使得父类的init 方法中的参数 config 对象位空
	 * 从而产生空指针异常
	 * 
	 * 解决的方法就是在本类的init方法中独傲能够用父类的init方法 并为将此类的config 对象参数传给父类的init
	 * 方法
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OneServlet...");
		//整个web 应用的上下文对象
		ServletContext servletContext = this.getServletContext();
		System.out.println(servletContext);
		//绝对路径：getRealPath();
		//他会将当前路径与web根路径进行拼接，加载一个文件必须要使用绝对路径
		String realPath = servletContext.getRealPath("p1.png");
		System.out.println(realPath);
		
		//使用类加载器 获取字节码路径，到字节码文件中获取文件的路径
		String path =User.class.getClassLoader().getResource("b.txt").getPath();
		System.out.println(path);
			
		FileInputStream in = new FileInputStream(realPath);
		ServletOutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer))!=-1) {
			/*System.out.println(len);
			System.out.println(Arrays.toString(buffer));
			System.out.println(new String(buffer,0,len));*/
			out.write(buffer, 0, len);
			
		}
		in.close();
	}
}
