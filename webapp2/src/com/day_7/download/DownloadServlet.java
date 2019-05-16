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
		
		//接收参数，默认的编码形式为ISO-8859-1
		String name = request.getParameter("filename");
		//解决办法:先将name转化为二进制数组
		byte[] bytes = name.getBytes("ISO8859-1");
		//在将二进制数组转化为UTF-8
		name = new String(bytes,"UTF-8");
		System.out.println(name);
		
		//根据文件名获取队形的 mime 类型，使用ServletContext对象
		String mimeType = this.getServletContext().getMimeType(name);
		//告诉服务器对应的mime类型
		response.setContentType(mimeType);
		
		//告诉浏览器以附件的形式进行文件的下载/以附件的形式进行文件的下载浏览器会步识别name中文的汉字
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
		//找到对应的文件路径
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
