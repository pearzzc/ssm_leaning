package com.zzc.web;

import com.zzc.service.MyService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先得到对应的servletContext 对象
        ServletContext servletContext = this.getServletContext();
        //将上一步得到的对象作为参数 WebApplicationContext 对象
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //在通过Servlet对象获得由Spring管理的对象
        MyService myService = (MyService)applicationContext.getBean("myService");
        myService.save();
    }

}
