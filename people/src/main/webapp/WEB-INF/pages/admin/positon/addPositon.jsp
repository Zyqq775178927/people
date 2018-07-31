<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 14:14
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
            $("#depart").change(function () {
                $("#did").empty()
                var a=$(this).val();
                $("#did").val(a);
            })
            var ok1=false;
            var ok2=false;
            $("#name").blur(function () {
                var a=$("#name").val();
                var b=$("#did").val();
                if (a==null||a==""){
                    ok1=false;
                }else {
                    ok1=true;
                }
                $.ajax({
                    url:"getPositonName",
                    data:{"name":a,"did":b},
                    type:"post",
                    success:function (obj) {
                        if(obj==""||obj==null){
                            $("#s1").html("可以使用")
                            ok2=true;
                        }else {
                            $("#s1").html("职位已经存在")
                            ok2=false;
                        }
                    }
                })
            })
            $("#p1").click(function () {
                if(ok1&&ok2){
                    $("#p1").submit();
                }else {
                    return false;
                }
            })
        })
    </script>
</head>
<body>
<%
    session.getAttribute("depart");
%>

    <form action="addPositons" method="post">
        <table>
            <tr>
                <td>请选择部门</td>
                <td>
                <select id="depart">
                    <option value="0">请选择部门</option>
                    <c:forEach items="${sessionScope.depart}" var="i">
                        <option value="${i.d_id}">${i.d_name}</option>
                    </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td>请输入添加的职位</td>
                <td><input type="text" name="p_name" id="name" id="name"></td>
                <td><span id="s1"></span></td>
            </tr>
            <tr>
                <td>请输入职位的底薪</td>
                <td><input type="number" min="0" name="p_sal"></td>
            </tr>
            <tr>
                <input type="hidden" name="t_department.d_id" id="did">
                <td><input type="submit" value="添加" id="p1"></td>
            </tr>
        </table>
    </form>
</body>
</html>
