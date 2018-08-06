<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/3
  Time: 13:01
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
    <%
        session.getAttribute("empAndTrain");
        int totalPages= (int) session.getAttribute("totalPages");
        int currentPage= (int) session.getAttribute("currentPage");
    %>
    <c:if test="${fn:length(sessionScope.empAndTrain)==0}">
        ${"没有培训信息"}
    </c:if>
    <c:if test="${fn:length(sessionScope.empAndTrain)!=0}">
        <div>
            <table>
                <tr>
                    <th>培训主题</th>
                    <th>培训内容</th>
                    <th>培训地址</th>
                    <th>培训开始时间</th>
                    <th>培训结束时间</th>
                    <th>培训发布时间</th>
                </tr>
                <c:forEach items="${sessionScope.empAndTrain}" var="i">
                    <tr>
                        <td>${i.train.t_name}</td>
                        <td>${i.train.t_content}</td>
                        <td>${i.train.t_address}</td>
                        <td>${i.train.t_starttime}</td>
                        <td>${i.train.t_endtime}</td>
                        <td>${i.train.t_time}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
            <a href="getEmpTrain?currentPage=<%=currentPage>1?currentPage-1:1%>">上一页</a>
            <a href="getEmpTrain?currentPage=<%=currentPage<totalPages?currentPage+1:totalPages%>">下一页</a>
            <a href="getEmpMain" >返回</a>
        </div>
    </c:if>
</body>
</html>
