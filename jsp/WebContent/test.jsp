<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 这种定义的变量在类的Service方法中 -->
<%--jsp 注释 --%>
<% 

//实弹射击
String name ="司马懿"; %>
<%=name %>
<!--这种形式在翻译的过程中为类的成员变量  -->
<%!String name ="simayi" ;%>
</body>
</html>