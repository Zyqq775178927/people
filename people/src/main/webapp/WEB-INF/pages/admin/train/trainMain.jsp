<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/1
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
    <a href="getAdminMain">返回首页</a>
    <a href="addTrain">添加培训</a>
    <a href="getTrain?currentPage=1">查看培训</a>
</body>
</html>
