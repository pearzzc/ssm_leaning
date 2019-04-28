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

  <h1>测试struts2的相关功能</h1>
  <form action="${pageContext.request.contextPath}/myform.action" method="post">
      用户名:<input type="text" placeholder="请输入用户名..." name="username"><br/>
      昵称:<input type="text" placeholder="请输入用户名..." name="nick"><br/>
      爱  好: <input type="checkbox" value="足球" name="hobby">足球
      <input type="checkbox" value="篮球" name="hobby">篮球
      <input type="checkbox" value="乒乓球" name="hobby">乒乓球<br/>
      <input type="submit" value="提交">
  </form>
  <c:fielderror></c:fielderror>
  <h1>set方法测试象形的struts2</h1>
  <form action="${pageContext.request.contextPath}/myform1.action" method="post">
      用户名:<input type="text" placeholder="请输入用户名..." name="username"><br/>
      年龄:<input type="text" placeholder="请输入用户名..." name="age"><br/>
      爱  好: <input type="checkbox" value="足球" name="hobby">足球
      <input type="checkbox" value="篮球" name="hobby">篮球
      <input type="checkbox" value="乒乓球" name="hobby">乒乓球<br/>
      <input type="submit" value="提交">
  </form>
  <h1>模型驱动测的struts2</h1>
  <form action="${pageContext.request.contextPath}/myform2.action" method="post">
      用户名:<input type="text" placeholder="请输入用户名..." name="username"><br/>
      年龄:<input type="text" placeholder="请输入用户名..." name="age"><br/>
      爱  好: <input type="checkbox" value="足球" name="hobby">足球
      <input type="checkbox" value="篮球" name="hobby">篮球
      <input type="checkbox" value="乒乓球" name="hobby">乒乓球<br/>
      <input type="submit" value="提交">
  </form>
  </body>
</html>
