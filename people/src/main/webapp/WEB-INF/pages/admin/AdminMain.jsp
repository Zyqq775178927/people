<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/27
  Time: 18:57
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
    <a href="getRecruit?currentPage=1">查看招聘信息</a>
    <a href="addRecruit">添加招聘信息</a>
    <a href="getR_R">查看应聘信息</a>
    <a href="addEmp">添加员工</a>
    <a href="getdepartmain">部门管理</a>
    <a href="empmains">员工管理</a>
    <a href="trainmain">培训管理</a>
    <a href="salMain">员工薪资结算</a>
</body>
</html>
