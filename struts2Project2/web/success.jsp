<%--
  Created by IntelliJ IDEA.
  User: pear
  Date: 2019/3/22
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
username:${username}<br>
nick:${nick}<br>
<%--对数组要进行遍历要用到jstl--%>
<c:forEach  items="${hobbies}" var="hobyy">
    ${hobyy}
</c:forEach>

</body>
</html>
