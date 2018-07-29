<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29
  Time: 17:43
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
                $("#position").empty();
                $("#position").html('<option value="0">请选择职位</option>');
                var a=$("#depart").val();
                $.ajax({
                    url:"getPositon",
                    data:{"did":a},
                    type:"post",
                    success:function (obj) {
                        $(obj).each(function (index) {
                            $("#position").append(
                                '<option value="'+obj[index].p_id+'" >'+obj[index].p_name+'</option>'
                            )
                        })
                    }
                })
            })
            $("#position").change(function () {
                var a=$(this).val();
                $("#s1").val(a);
                alert($("#s1").val())
            })
        })
    </script>
</head>
<body>
    <%
        session.getAttribute("depart");
    %>
    <form method="post" action="adminAddRecruit">
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
                    <select name="position" class="position" id="position">
                    </select>
                </td>
            </tr>
            <tr>
                <td>请输入招聘薪资</td>
                <td><input type="text" name="re_sal"/></td>
            </tr>
            <tr>
                <td>请输入招聘地址</td>
                <td><input type="text" name="re_address"/></td>
            </tr>
            <tr>
                <td>请输入招聘电话</td>
                <td><input type="text" name="re_phone"/></td>
            </tr>
            <tr>
                <td>请输入招聘需求</td>
                <td><input type="text" name="re_need"/></td>
            </tr>
            <tr>
                <input type="hidden" name="re_pid" id="s1"/>
                <td><input type="submit" value="添加"></td>
            </tr>
        </table>
    </form>
</body>
</html>
