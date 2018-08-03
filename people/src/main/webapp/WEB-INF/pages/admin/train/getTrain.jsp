<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2
  Time: 15:13
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
            $(".updateState").click(function () {
                var a=$(this).siblings(":eq(0)").val();
                var b=$(this).siblings(":eq(1)").val();
                $.ajax({
                    url:"updateState",
                    data:{"t_id":a,"t_state":b},
                    type:"post",
                    success:function (obj) {
                        if (obj==false){
                            alert("时间超过了不能撤回");
                        }else {
                            location.reload();
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
    <%
        session.getAttribute("train");
        int currentPage= (int) session.getAttribute("currentPage");
        int totalPages =(int) session.getAttribute("totalPages1");
    %>
    <div>
    <table>
        <tr>
            <th>培训主题</th>
            <th>培训内容</th>
            <th>培训开始时间</th>
            <th>培训结束时间</th>
            <th>培训地址</th>
            <th>修改培训</th>
            <th>培训状态</th>
        </tr>
       <c:forEach items="${sessionScope.train}" var="i">
               <tr>
                   <form action="updateTrain" method="post">
                   <td><input type="text" name="t_name" value="${i.t_name}"/></td>
                   <td><input type="text" name="t_content" value="${i.t_content}"/></td>
                   <td><input type="date" name="t_starttime" value="${i.t_starttime}"/></td>
                   <td><input type="date" name="t_endtime" value="${i.t_endtime}"/></td>
                   <td><input type="text" name="t_address" value="${i.t_address}"/></td>
                   <td>
                       <input type="hidden" name="t_id" value="${i.t_id}">
                       <input type="submit" value="修改">
                   </td>
                   </form>
                   <td>
                       <c:if test="${i.t_state==0}">
                           <input type="hidden" name="t_id" value="${i.t_id}">
                           <input type="hidden" name="t_state" value="${i.t_state}">
                           <input type="button" value="发布" class="updateState">
                       </c:if>
                       <c:if test="${i.t_state==1}">
                           <input type="hidden" name="t_id" value="${i.t_id}">
                           <input type="hidden" name="t_state" value="${i.t_state}">
                           <input type="button" value="撤回" class="updateState">
                       </c:if>
                   </td>
               </tr>
       </c:forEach>
    </table>
    </div>
    <div align="center">
        <a href="getTrain?currentPage=<%=currentPage>1?currentPage-1:1%>">上一页</a>
        <a href="getTrain?currentPage=<%=currentPage<totalPages?currentPage+1:totalPages%>">下一页</a>
        <a href="trainmain" >返回</a>
    </div>
</body>
</html>
