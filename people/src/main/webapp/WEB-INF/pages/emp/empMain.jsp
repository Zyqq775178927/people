<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/3
  Time: 9:35
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
    <a href="getEmpTrain?currentPage=1">查看培训信息</a>
    <a href="clockIn">打卡考勤</a>
</body>
</html>
