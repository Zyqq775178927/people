<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 15:45
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
        #d1{
            text-align: center;
        }
    </style>
</head>
<body>
    <%
        session.getAttribute("r_r");
        session.getAttribute("invited");
    %>
    <div>
        <table align="center" id="d1">
            <tr>
                <th>招聘需求</th>
                <th>招聘地址</th>
                <th>是否阅读</th>
                <th>查阅简历</th>
                <th>录用</th>
            </tr>
            <c:forEach items="${sessionScope.r_r}" var="i" varStatus="j">
                <tr>
                    <td>${i.t_recruitment.re_need}</td>
                    <td>${i.t_recruitment.re_address}</td>
                    <td>
                        <c:if test="${i.r_state==0}">
                            ${"未阅读"}
                        </c:if>
                        <c:if test="${i.r_state==1}">
                            ${"已读"}
                        </c:if>
                    </td>
                    <td>
                        <a href="adminGetResume?rb_id=${i.t_resume.rb_id}&r_id=${i.r_id}&re_id=${i.t_recruitment.re_id}">
                            查看简历
                        </a>
                    </td>

                    <td>
                        <c:if test="${invited[j.count-1].i_state==0}">
                            ${"等待应聘者前来应聘"}
                        </c:if>
                        <c:if test="${invited[j.count-1].i_state==1}">
                            <a href="adminUpdateInvited?id=${invited[j.count-1].i_id}&state=2">录用</a>
                            <a href="adminUpdateInvited?id=${invited[j.count-1].i_id}&state=-2">不录用</a>
                        </c:if>
                        <c:if test="${invited[j.count-1].i_state==-1}">
                            ${"应聘者拒绝应聘"}
                        </c:if>
                        <c:if test="${invited[j.count-1].i_state==2}">
                            ${"录用"}
                        </c:if>
                        <c:if test="${invited[j.count-1].i_state==-2}">
                            ${"不录用"}
                        </c:if>
                    </td>
            </c:forEach>

        </table>
    </div>
</body>
</html>
