<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/1
  Time: 10:15
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
        })
    </script>
</head>
<body>
    <%
        session.getAttribute("depart");
        session.getAttribute("currentPage");
    %>
    <div>
        <form action="getEmpAndDep" method="post">
            <table>
                <tr>
                    <td>请选择员工的部门</td>
                    <td>
                        <select id="depart" name="d_id">
                            <option value="0">请选择部门</option>
                            <c:forEach items="${sessionScope.depart}" var="i">
                                <option value="${i.d_id}">${i.d_name}</option>
                            </c:forEach>
                        </select>

                    </td>
                    <td>
                        <select name="position" class="position" id="position">
                        </select>
                    </td>
                    <td>
                        <select name="e_state">
                            <option value="0">在职</option>
                            <option value="-1">离职</option>
                        </select>
                    </td>
                    <td>
                        <input type="hidden" name="currentPage" value="${sessionScope.currentPage}"/>
                        <input type="submit" value="查询">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
