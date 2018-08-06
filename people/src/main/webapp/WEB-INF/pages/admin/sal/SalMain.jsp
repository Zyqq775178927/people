<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/5
  Time: 12:52
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
    <h3 align="center">欢迎来到薪资结算页面</h3>
    <a href="settlementSal">结算薪资</a>(结算上个月的所有员工薪资)
</body>
</html>
