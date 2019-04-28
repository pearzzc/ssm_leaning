<%--
  Created by IntelliJ IDEA.
  User: zhouzechong
  Date: 2019/3/17
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入界面</title>
</head>
<body>
<H1>登入界面</H1>
<form action="myform.action" method="post">
    用户名:<input type="text" placeholder="请输入用户名..." name="user"><br/>
    昵称:<input type="text" placeholder="请输入用户名..." name="nick"><br/>
    爱  好: <input type="checkbox" value="足球" name="hobby">足球
    <input type="checkbox" value="篮球" name="hobby">篮球
    <input type="checkbox" value="乒乓球" name="hobby">乒乓球<br/>
    <input type="submit" value="提交">
</form>

</form>
</body>
</html>
