<%--
  Created by IntelliJ IDEA.
  User: pear
  Date: 2019/3/27
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:property value="name"></s:property>
<s:property value="#reqname"></s:property>
<s:property value="#session.Sessionname"></s:property>
<s:property value="#application.applicationname"></s:property>
<s:debug></s:debug>
<h1>Success</h1>
</body>
</html>
