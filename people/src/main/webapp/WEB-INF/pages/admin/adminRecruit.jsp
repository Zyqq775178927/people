<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 14:33
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
    <script src="jq/jquery.js"></script>
    <script>
        $(function () {
            $("[name='remove']").click(function () {
                var a=$(this).siblings(":eq(0)").val();
                $.ajax({
                    type:"post",
                    url:"removeRecruit",
                    data:{"id":a},
                    success:function () {
                        location.reload();
                    }
                })
            })
            $("[name='release']").click(function () {
                var a=$(this).siblings(":eq(0)").val();
                var b=$(this).siblings(":eq(1)").val();
                $.ajax({
                    type:"post",
                    url:"updateRecruitState",
                    data:{"id":a,"state":b},
                    success:function () {
                        location.reload();
                    }
                })
            })
        })
    </script>
</head>
<body>
<div>
    <%
        session.getAttribute("recruitment");
        int currentPage= (int) session.getAttribute("currentPage");
        int totalPages =(int) session.getAttribute("totalPages");
    %>
    <h3>招聘信息</h3>
    <table>
        <tr>
            <th>招聘职位名称</th>
            <th>招聘薪资</th>
            <th>招聘地址</th>
            <th>招聘联系电话</th>
            <th>招聘需求</th>
            <th>发布招聘时间</th>
            <th>修改</th>
            <th>删除</th>
            <th>发布</th>
        </tr>
        <c:forEach items="${sessionScope.recruitment}" var="i">
            <tr>
                <td>${i.t_positon.p_name}</td>
                <form action="updateRecruit" method="post">
                <td><input type="text" value="${i.re_sal}" name="re_sal"></td>
                <td><input type="text" value="${i.re_address}" name="re_address"></td>
                <td><input type="text" value="${i.re_phone}" name="re_phone"></td>
                <td><input type="text" value="${i.re_need}" name="re_need"></td>
                <td>${i.re_time}</td>
                <td><input type="hidden" value="${i.re_id}" name="re_id"></td>
                <td><input type="submit" value="修改"></td>
                </form>
                <td><input type="hidden" value="${i.re_id}"></td>
                <td><input type="hidden" value="${i.re_state}"></td>
                <td><input type="button" value="删除" name="remove"></td>
                <td>
                    <c:if test="${i.re_state==0}">
                        <input type="button" value="发布" name="release">
                    </c:if>
                    <c:if test="${i.re_state==1}">
                        <input type="button" value="撤销" name="release">
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="getRecruit?currentPage=<%=currentPage>1?currentPage-1:1%>">上一页</a>
    <a href="getRecruit?currentPage=<%=currentPage<totalPages?currentPage+1:totalPages%>">下一页</a>
</div>
</body>
</html>
