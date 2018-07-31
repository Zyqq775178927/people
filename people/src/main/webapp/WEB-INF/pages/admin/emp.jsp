<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 13:11
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
            var  ok=false;
            var ok1=false;
            var ok2=false;
            var ok3=false;
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
            })
            $("#name").blur(function () {
                var a=$(this).val();
                $.ajax({
                    url:"getEmpName",
                    data:{"name":a},
                    datatype:"json",
                    success:function (obj) {
                        $("#s2").empty()
                        if(obj==""||obj==null){
                            $("#s2").html("可以使用")
                            ok=true;
                        }else {
                            $("#s2").html("员工编号已经存在")
                            ok=false;
                        }
                    }
                })
            })
            $("#p1").click(function () {
                $("input").each(function () {
                    if($("input").val()==null||$("input").val()==""){
                        ok1=false;
                        $("#s3").text("不能为空")
                    }else {
                        ok1=true;
                        $("#s3").text("")
                    }
                })
                if(ok&&ok1&&ok2&&ok3){
                    $("#p1").submit();
                }else {
                    return false;
                }
            })
            $("#q2").blur(function () {
                var a=/^[0-9]{11}$/;
                if (!a.test($("#q2").val())){
                    ok2=false;
                    $("#s4").text("电话长度为11")
                }else {
                    ok2=true
                    $("#s4").text("")
                }
            })
            $("#q3").blur(function () {
                var rule = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                if (!rule.test($("#q3").val())){
                    ok3=false;
                    $("#s5").text("邮箱格式不正确")
                }else {
                    ok3=true
                    $("#s5").text("")
                }
            })
        })
    </script>
</head>
<body>
    <%
        session.getAttribute("depart");
    %>
    <h4 id="s3"></h4>
    <form action="addEmps" method="post">
        <table>
            <td>请为员工分配部门</td>
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
            <tr>
                <td>请输入员工登录编号</td>
                <td><input type="text" name="e_name" id="name"></td>
                <td><span id="s2">${requestScope.error}</span></td>
            </tr>
            <tr>
                <td>请输入员工登录密码</td>
                <td><input type="text" name="e_pass"></td>
            </tr>
            <hr width="700" align="left">
            <h3>员工基本信息记录</h3>
            <tr>
                <td>请输入员工姓名</td>
                <td><input type="text" name="e_username"></td>
            </tr>
            <tr>
                <td>请输入员工出生年月日</td>
                <td><input type="date" name="e_age"></td>
            </tr>
            <tr>
                <td>请输入员工电话</td>
                <td><input type="text" name="e_phone" id="q2">
                    <span id="s4"></span>
                </td>
            </tr>
            <tr>
                <td>请输入员工地址</td>
                <td><input type="text" name="e_address"></td>
            </tr>
            <tr>
                <td>请输入员工邮箱</td>
                <td><input type="text" name="e_emain" id="q3">
                    <span id="s5"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" id="s1" name="pid">
                    <input type="submit" value="添加" id="p1">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
