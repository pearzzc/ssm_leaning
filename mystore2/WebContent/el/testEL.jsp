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
//用域对象存储数据
	pageContext.setAttribute("name", "pageContext");
	request.setAttribute("name", "request");
	session.setAttribute("name", "session");
	application.setAttribute("name", "appliction");
	
%>

<%--用el的内置对象进行数据的获取：主要从四大数据域进行数据的获取：PageContext、request、session、appliction --%>
${pageScope.name}<br/>
${requestScope.name}<br/>
${sessionScope.name}<br/>
${applicationScope.name}<br/>
<hr>
${1+2}<br/>
${empty name }<br/>
</body>
</html>