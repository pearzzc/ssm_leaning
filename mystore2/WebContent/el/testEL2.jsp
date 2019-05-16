<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.mystore.domian.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${1==1 }">我的JSTL</c:if>
	<% 
		request.setAttribute("count", 100);
	%>
	<c:if test="${count>50 }">
		大于50
	</c:if>
	<c:if test="${count<50 }">
		小于50
	</c:if>
	<br/>
	<%--简单的 jstl 标签 遍历的应用 --%>
	<c:forEach begin="0" end="3" var="i">
		${i }
	</c:forEach>
	<hr>
	<!-- 遍历字符串的集合 -->
	<%
		List<String> lists = new ArrayList<String>();
		lists.add("aa");
		lists.add("bb");
		lists.add("cc");
		lists.add("dd");
		
		request.getSession().setAttribute("lists", lists);
	%>
	
	<c:forEach items="${lists }" var="str">
		${str }
	</c:forEach>
	<hr>
	
	<%
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setUname("zhouzechong01");
		
		User user2 = new User();
		user2.setUname("zhouzechong02");
		
		users.add(user1);
		users.add(user2);
		request.setAttribute("users", users);
		
	%>
	<c:forEach items="${users }" var="username">
		${username.uname }
	</c:forEach>
	<hr>
	<% 
		Map<String,String> strMap = new HashMap<String,String>();
		strMap.put("a", "abc");
		strMap.put("b", "bc");
		strMap.put("c", "c");
		
		request.setAttribute("zzx", strMap);
	%>
	<c:forEach items="${zzx }" var="namezzc">
		${namezzc.key }:${namezzc.value }
	</c:forEach>
</body>
</html>