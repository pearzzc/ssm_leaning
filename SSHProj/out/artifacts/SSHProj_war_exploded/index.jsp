<%--
  Created by IntelliJ IDEA.
  User: zechong
  Date: 2019/4/14
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/form_save.action" method="post">
   name: <input type="text" name="name">
   money:<input type="text" name="money">
    <input type="submit" value="提交">
  </form>
  <a href="${pageContext.request.contextPath}/form_delete.action?id=1">删除</a>
  </body>
</html>
