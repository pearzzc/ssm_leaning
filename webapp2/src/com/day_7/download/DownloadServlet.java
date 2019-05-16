package com.day_7.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ղ�����Ĭ�ϵı�����ʽΪISO-8859-1
		String name = request.getParameter("filename");
		//����취:�Ƚ�nameת��Ϊ����������
		byte[] bytes = name.getBytes("ISO8859-1");
		//�ڽ�����������ת��ΪUTF-8
		name = new String(bytes,"UTF-8");
		System.out.println(name);
		
		//�����ļ�����ȡ���ε� mime ���ͣ�ʹ��ServletContext����
		String mimeType = this.getServletContext().getMimeType(name);
		//���߷�������Ӧ��mime����
		response.setContentType(mimeType);
		
		//����������Ը�������ʽ�����ļ�������/�Ը�������ʽ�����ļ�������������Ჽʶ��name���ĵĺ���
		String agent = request.getHeader("User-Agent");
		
		String filenameEncoder = "";
		
		if(agent.contains("MSIE")) {
			filenameEncoder = URLEncoder.encode(name, "UTF-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
		}else if(agent.contains("Firefox")) {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filenameEncoder = "?utf-8?B?"+base64Encoder.encode(name.getBytes("utf-8"))+"?=";
		}else {
			filenameEncoder = URLEncoder.encode(name, "UTF-8");
		}
		response.setHeader("Content-Disposition", "attachment;filename="+filenameEncoder);
		//�ҵ���Ӧ���ļ�·��
		String path = this.getServletContext().getRealPath("/download/"+name);
		FileInputStream in = new FileInputStream(path);
		int len =0;
		byte[] buffer = new byte[1024];
		ServletOutputStream out = response.getOutputStream();
		while((len=in.read(buffer))!=-1) {
			out.write(buffer, 0, len);
		}
		in.close();
	}
}
