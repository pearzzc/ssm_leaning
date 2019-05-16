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
	 * ֱ������д�ᱨ��ָ���쳣 ����Ϊthis������ö�ServletContext ��������Դ�ڸ����init ������config����
	 * �ڱ�������д�˸����init ������ʹ�ø����init �����еĲ��� config ����λ��
	 * �Ӷ�������ָ���쳣
	 * 
	 * ����ķ��������ڱ����init�����ж����ܹ��ø����init���� ��Ϊ�������config ����������������init
	 * ����
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OneServlet...");
		//����web Ӧ�õ������Ķ���
		ServletContext servletContext = this.getServletContext();
		System.out.println(servletContext);
		//����·����getRealPath();
		//���Ὣ��ǰ·����web��·������ƴ�ӣ�����һ���ļ�����Ҫʹ�þ���·��
		String realPath = servletContext.getRealPath("p1.png");
		System.out.println(realPath);
		
		//ʹ��������� ��ȡ�ֽ���·�������ֽ����ļ��л�ȡ�ļ���·��
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
