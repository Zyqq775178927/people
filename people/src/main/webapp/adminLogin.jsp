<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/25
  Time: 10:51
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
    <link href="css/login.css" rel="stylesheet" type="text/css" />
    <script>
        function a() {
            document.getElementById("d1").value="";
        }
    </script>
</head>
<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><img src="images/login_logo.png" /></div>
        <div class="login_name">
            <p>管理员登录系统</p>
        </div>
        <form method="post" action="adminLogin">
            <input name="a_name" type="text" value="用户名" onclick="a()" id="d1"/><br/>
            <input name="a_pass" type="password" id="password"/><br/>
            <input value="登录" style="width:100%;" type="submit">
        </form>
        <h4 style="background-color: red" align="center">${error}</h4>
    </div>
</div>
</body>
</html>
