<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 16:14
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
    <style>
        body{
            background-image: url("images/timg.jpg");
        }
    </style>
</head>
<body>
<%
    request.getAttribute("re_id");
    session.getAttribute("resume1");
%>
<table  align="center" width="800">
        <hr width="700" align="left">
    <form method="post" action="addInvited">
        <input type="hidden" name="re_id" value="${requestScope.re_id}"/>
        <input type="hidden" name="t_user" value="${sessionScope.resume1.t_user.u_id}"/>
        <input type="submit" value="发送面试邀请">
    </form>
        <hr width="700" align="left">
        <tr>
            <td>姓名：</td>
            <td width="60" height="50">
               ${resume1.rb_name}
            </td >
            <td width="60" height="50">性别：</td>
            <td width="100" height="50">
                ${resume1.rb_sex}
            </td>
            <td width="60" height="50">民族：</td>
            <td width="100" height="50">
               ${resume1.rb_national}
            </td>
        </tr>
        <tr>
            <td width="60" height="50" >年龄：</td>
            <td width="100" height="50">
                ${resume1.rb_age}
            </td>
            <td width="60" height="50" >联系电话：</td>
            <td width="100" height="50">
               ${resume1.rb_phone}
            </td>
            <td></td>
            <td width="60" height="50"></td>
        </tr>
        <tr>
            <td width="60" height="50">学历：</td>
            <td width="100" height="50">
               ${resume1.rb_schooling}
            </td>
            <td width="60" height="50">专业：</td>
            <td width="100" height="50">
                ${resume1.rb_major}
            </td>
            <td width="60" height="50">毕业学校：</td>
            <td width="100" height="50">
                ${resume1.rb_school}
            </td>
        </tr>
        <tr>
            <td width="60" height="50">住址：</td>
            <td height="50">
                ${resume1.rb_address}
            </td>
        </tr>
        <tr>
            <td width="60" height="50">电子邮箱：</td>
            <td height="50">
                ${resume1.rb_email}
            </td>
        </tr>
        <tr>
            <td>求职意向:</td>
            <td height="50">
               ${resume1.rb_objective}
            </td>
        </tr>
        <tr>
            <td>爱好特长：</td>
            <td height="50px">
                                ${resume1.rb_hobby}
            </td>
        </tr>
        <tr>
            <td>自我评价：</td>
            <td height="50px">

                                ${resume1.rb_introduce}

            </td>
        </tr>
    <tr>
        <td><a href="getR_RJSP">返回</a></td>
    </tr>
</table>
</body>
</html>
