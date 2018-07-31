<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 9:34
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
            var ok1=false;
            var ok2=false;
            $(".name").blur(function () {
                var a=$(this).val();
                if (a==null||a==""){
                    ok1==false;
                }
                $.ajax({
                    url:"getDepartName",
                    data:{"name":a},
                    type:"post",
                    success:function (obj) {
                        if(obj==""||obj==null){
                            ok2=true;
                        }else {
                            alert("部门名称已经存在")
                            ok2=false;
                        }
                    }
                })
            })
            $(".chang").click(function () {
                if(ok1&&ok2){
                    $(".chang").submit();
                }else {
                    return false;
                }
            })
            $(".remove").click(function () {
                var a=$(this).siblings(":eq(0)").val()
                $.ajax({
                    url:"removeDepart",
                    data:{"did":a},
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
<%
    session.getAttribute("depart");
    int currentPage= (int) session.getAttribute("currentPage");
    int totalPages =(int) session.getAttribute("totalPages");
%>
<body>
    <table>
        <tr>
            <th>部门名称</th>
            <th>部门创建时间</th>
            <th>修改部门名称</th>
            <th>删除部门</th>
        </tr>
        <c:forEach items="${sessionScope.depart}" var="i">
            <form action="updateDepart" method="post">
                <tr>
                    <td>
                        <input type="text" name="d_name" value="${i.d_name}" class="name"/>
                        <span id="s1"></span>
                    </td>
                    <td>${i.d_time}</td>
                    <td>
                        <input type="hidden" value="${i.d_id}" name="d_id">
                        <input type="submit" value="修改" name="chang">
                    </td>
            </form>
                <td>
                    <input type="hidden" value="${i.d_id}">
                    <input type="button" value="删除" class="remove">
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <a href="getDepart?currentPage=<%=currentPage>1?currentPage-1:1%>">上一页</a>
        <a href="getDepart?currentPage=<%=currentPage<totalPages?currentPage+1:totalPages%>">下一页</a>
        <a href="getAdminMain" >返回</a>
    </div>
</body>
</html>
