<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29
  Time: 16:40
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
    <style>
        body{
            background-image: url("images/timg.jpg");
        }
    </style>
</head>
<body>
    <%
        session.getAttribute("invited");
    %>
    <table>
        <tr>
            <th>应聘需求</th>
            <th>应聘地址</th>
            <th>应聘电话</th>
            <th>应聘时间</th>
            <th>应聘</th>
        </tr>
        <c:forEach items="${sessionScope.invited}" var="i">
            <tr>
                <td>${i.t_recruitment.re_need}</td>
                <td>${i.t_recruitment.re_address}</td>
                <td>${i.t_recruitment.re_phone}</td>
                <td>${i.i_time}</td>
                <td>
                    <c:if test="${i.i_state==0}">
                        <a href="updateInvited?id=${i.i_id}&state=1">前去应聘</a>
                        <a href="updateInvited?id=${i.i_id}&state=-1">放弃应聘</a>
                    </c:if>
                    <c:if test="${i.i_state==-1}">
                        ${"放弃应聘"}
                    </c:if>
                    <c:if test="${i.i_state==1}">
                        ${"准备去应聘"}
                    </c:if>
                    <c:if test="${i.i_state==2}">
                        ${"恭喜你被录用了"}
                    </c:if>
                    <c:if test="${i.i_state==-2}">
                        ${"很遗憾你没有被录用"}
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
