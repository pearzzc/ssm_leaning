<%--
  Created by IntelliJ IDEA.
  User: pear
  Date: 2019/3/22
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:fielderror></c:fielderror>
  <%--从页面获取多个参数，封装成一个集合--%>
  <form action="${pageContext.request.contextPath}/myform3.action">
      <input type="text" name="goodsList[0].name" placeholder="请输入。。。。"><br>
      <input type="text" name="goodsList[0].price" placeholder="请输入。。。。"><br>
      <input type="text" name="goodsList[1].name" placeholder="请输入。。。。"><br>
      <input type="text" name="goodsList[1].price" placeholder="请输入。。。。"><br>
      <input type="submit" value="提交">
  </form>

  </body>
</html>
