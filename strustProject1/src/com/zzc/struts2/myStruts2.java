package com.zzc.struts2;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

//让Action实现一些接口，让接口提供的一些方法，设置一些具体的值
public class myStruts2 extends ActionSupport implements ServletRequestAware, ServletContextAware {
    //设置私有属性
    private HttpServletRequest httpServletRequest;
    private ServletContext servletContext;

    public String execute(){
        Map<String, String[]> parameterMap = this.httpServletRequest.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] values = parameterMap.get(key);
            System.out.println(key+" "+ Arrays.toString(values));
        }
        this.httpServletRequest.setAttribute("requestname","request");
        this.httpServletRequest.getSession().setAttribute("sessiomname","sesson");
        this.servletContext.setAttribute("contextname","context");
        return SUCCESS;
    }
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.servletContext = servletContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.httpServletRequest = httpServletRequest;
    }
}
