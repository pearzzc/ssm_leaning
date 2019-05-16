<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
aaa
<%--out对象也有自己的缓冲区 --%>
<%--response对象有自己的缓冲区 --%>
<%--只有response 才有响应能力，即价格out对象的缓存去内容拼接在response 对象之后--%>
<%="bbb" %>
<% out.write("ccc");

response.getWriter().write("ddd");
%>

</body>
</html>