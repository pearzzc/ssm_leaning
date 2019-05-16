<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include><%--动态指令：动态包含 --%>
<h1>身体</h1>
<%@ include file="footer.jsp" %><%--静态指令：静态包含 --%>
<%--转发指令 --%>
<jsp:forward page="test.jsp"></jsp:forward>
</body>
</html>