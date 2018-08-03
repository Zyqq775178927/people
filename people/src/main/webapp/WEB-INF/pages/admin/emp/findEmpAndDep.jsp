<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/1
  Time: 10:56
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
        session.getAttribute("empLimit");
        session.getAttribute("d_id");
        session.getAttribute("e_state");
        session.getAttribute("position");
        int totalPages= (int) session.getAttribute("totalPages1");
        int currentPage= (int) session.getAttribute("currentPage");
    %>
    <c:if test="${fn:length(sessionScope.empLimit)==0}">
        ${"没有员工"}
    </c:if>
    <c:if test="${fn:length(sessionScope.empLimit)!=0}">
        <div>
        <table>
            <tr>
                <th>员工姓名</th>
                <th>员工出生日期</th>
                <th>员工电话</th>
                <th>员工住址</th>
                <th>员工邮箱</th>
                <th>员工状态</th>
                <th>详细信息</th>
                <th>查询</th>
            </tr>
            <c:forEach items="${sessionScope.empLimit}" var="i">
                <tr>
                    <td>${i.e_username}</td>
                    <td>${i.e_age}</td>
                    <td>${i.e_phone}</td>
                    <td>${i.e_address}</td>
                    <td>${i.e_emain}</td>
                    <td>
                        <c:if test="${i.e_state==0}">
                            ${"试用期"}
                        </c:if>
                        <c:if test="${i.e_state==1}">
                            ${"正式员工"}
                        </c:if>
                    </td>
                    <form>
                        <td>
                            <select name="detail">
                                <option value="1">薪资</option>
                                <option value="2">考勤</option>
                                <option value="3">。。</option>
                            </select>
                        </td>
                        <td>
                            <input type="hidden" name="e_id" value="${i.e_id}"/>
                            <input type="submit" value="查询">
                        </td>
                    </form>
                    <form>
                        <input type="hidden" name="e_id" value="${i.e_id}"/>
                        <td><input type="submit" value="离职"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
        </div>
        <a href="getEmpAndDep?currentPage=<%=currentPage>1?currentPage-1:1%>&d_id=${sessionScope.d_id}&e_state=${sessionScope.e_state}&position=${sessionScope.position}">上一页</a>
        <a href="getEmpAndDep?currentPage=<%=currentPage<totalPages?currentPage+1:totalPages%>&d_id=${sessionScope.d_id}&e_state=${sessionScope.e_state}&position=${sessionScope.position}">下一页</a>
        <a href="getEmpjsp" >返回</a>
    </c:if>
</body>
</html>
