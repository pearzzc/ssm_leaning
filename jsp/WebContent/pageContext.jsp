<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//设置pageContext域对象的值
	pageContext.setAttribute("pageContext", "pageContext的信息");		
	//给指定数据域存数据
	pageContext.setAttribute("request", "请求域的数据", pageContext.REQUEST_SCOPE);
	//session数据域存对象
	pageContext.setAttribute("session", "相应的数据域", pageContext.SESSION_SCOPE);
%>


<%=pageContext.getAttribute("pageContext")
%>
<br/>
<%=request.getAttribute("request")
%><br/>
<%=session.getAttribute("session")
%><br/>
<%
String requestValue= (String)pageContext.getRequest().getAttribute("request");
out.println("在请求域中的数据： "+requestValue);

%>
</body>
</html>