<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/1
  Time: 20:10
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
        #d1{
            text-align: center;
            background-color:lavender;
        }
    </style>
    <script src="jq/jquery.js"></script>
    <script>
        $(function () {
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
            $("#p1").click(function () {
                $("input").each(function () {
                    if($("input").val()==null||$("input").val()==""){
                        ok1=false;
                    }else {
                        ok1=true;
                    }
                })
                $(".data").each(function () {
                    if($(".data").val()==null||$(".data").val()==""){
                        ok3=false;
                    }else {
                        ok3=true;
                    }
                })
                var a=$("#depart").val();
                if (a==-1){
                    alert("请选择培训对象");
                    ok2=false;
                }else {
                    ok2=true;
                }
                if (ok1==false||ok3==false){
                    alert("不能有空的")
                }
                if(ok1&&ok2&&ok3){
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
    <div align="center" id="d1">
        <form action="addTarin" method="post" id="f">
            <table>
                <tr>
                    <td>请选培训的对象</td>
                    <td>
                        <select id="depart" name="depart">
                            <option value="-1">--请选择--</option>
                            <option value="0">试用期</option>
                            <c:forEach items="${sessionScope.depart}" var="i">
                                <option value="${i.d_id}">${i.d_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select name="position" class="position" id="position">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>请输入培训主题</td>
                    <td><input type="text" name="t_name" ></td>
                </tr>
                <tr>
                    <td>请输入培训内容</td>
                    <td>
                        <textarea name="t_content" id="content">

                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>请选择开始时间</td>
                    <td><input type="date" name="t_starttime" class="data"></td>
                </tr>
                <tr>
                    <td>请选择结束时间</td>
                    <td><input type="date" name="t_endtime" class="data"></td>
                </tr>
                <tr>
                    <td>请输入培训地址</td>
                    <td><input type="text" name="t_address"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="添加" id="p1"></td>
                    <td><a href="trainmain"><input type="button" value="返回" ></a></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
