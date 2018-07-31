<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 16:05
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
        $("#name").blur(function () {
            var a=$("#name").val();
            if (a==null||a==""){
                ok1=false;
            }else {
                ok1=true;
            }
            $.ajax({
                url:"getDepartName",
                data:{"name":a},
                type:"post",
                success:function (obj) {
                    if(obj==""||obj==null){
                        $("#s1").html("可以使用")
                        ok2=true;
                    }else {
                        $("#s1").html("部门已经存在")
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
    <form action="addDeparts" method="post">
        <table>
            <tr>
                <td>请输入部门名称</td>
                <td><input type="text" name="d_name" id="name"></td>
                <td><span id="s1"></span></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交" id="p1"></td>
                <td><a href="getdepartmain"><input type="button" value="返回" ></a></td>
            </tr>
        </table>
    </form>
</body>
</html>
