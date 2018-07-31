<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 16:12
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
            var ok1=true;
            var ok2=true;
            var ok3=true;
            $(".name").blur(function () {
                var a=$(this).val();
                var b=$(this).siblings(":eq(0)").val();
                var c=$(this).siblings(":eq(1)").val();
                if (a==null||a==""){
                    ok1=false;
                }else {
                    ok1=true;
                }
                $.ajax({
                    url:"getPositonNames",
                    data:{"name":a,"did":b,"pid":c},
                    type:"post",
                    success:function (obj) {
                        if(obj==""||obj==null){
                            ok2=true;
                        }else {
                            alert("用户名重复")
                            ok2=false;
                        }
                    }
                })
            })
            $(".sal").blur(function () {
                var a=$(this).val();
                if (a==null||a==""){
                    alert("不能为空")
                    ok3=false
                }else {
                    ok3=true;
                }
            })
            $(".chang").click(function () {
                if(ok1&&ok2&&ok3){
                    $(".chang").submit();
                }else {
                    return false;
                }
            })
            $(".remove").click(function () {
                var a=$(this).siblings(":eq(0)").val()
                $.ajax({
                    url:"removePositon",
                    data:{"pid":a},
                    type:"post",
                    success:function (obj) {
                        if (obj==false){
                            alert("不能删除有员工任职");
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
        session.getAttribute("positon");
        int currentPage= (int) session.getAttribute("currentPage");
        int totalPages =(int) session.getAttribute("totalPages");
    %>
    <div>
    <table>
        <tr>
            <th>部门名称</th>
            <th>职位名称</th>
            <th>职位薪资</th>
            <th>职位创建时间</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${sessionScope.positon}" var="i">
            <form method="post" action="updatePositon">
            <tr>
                <td>${i.t_department.d_name}</td>
                <td>
                    <input type="hidden" name="t_department.d_id" value="${i.t_department.d_id}"/>
                    <input type="hidden" name="p_id" value="${i.p_id}"/>
                    <input type="text" value="${i.p_name}" name="p_name" class="name"/>
                </td>
                <td><input type="number" value="${i.p_sal}" name="p_sal" class="sal"/></td>
                <td>${i.p_time}</td>
                <input type="hidden" name="p_id" value="${i.p_id}"/>
                <td><input type="submit" value="修改" class="chang"/></td>
            </form>
            <td>
                <input type="hidden" name="p_id" value="${i.p_id}"/>
                <input type="button" value="删除" class="remove">
            </td>
            </tr>
        </c:forEach>
    </table>
    </div>
    <div>
        <a href="getPositons?currentPage=<%=currentPage>1?currentPage-1:1%>">上一页</a>
        <a href="getPositons?currentPage=<%=currentPage<totalPages?currentPage+1:totalPages%>">下一页</a>
        <a href="getAdminMain" >返回</a>
    </div>
</body>
</html>
