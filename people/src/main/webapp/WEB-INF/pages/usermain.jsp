<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/25
  Time: 17:23
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
            float: left;
            width: 200px;
            position: relative;
        }
        #d2{
            position: absolute;
            margin-left: 300px;
            width: 780px;
            height: 600px;
            background-color: green;
            display: none;
        }
        a,span{ display: inline-block;vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 20px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 3px; border: none; -webkit-appearance: none; outline:none; width:100%; }
    </style>
    <script src="jq/jquery.js"></script>
    <script>
        var b=true;
        function a() {
            if(b){
                document.getElementById("d2").style.display="block";
                b=false;
            }else {
                document.getElementById("d2").style.display="none";
                b=true;
            }
        }
    </script>
    <script>
        var ok=true;
        var ok2=true;
        var ok1=true;
        var ok3=true;
        $(function () {
            $("#p1").click(function () {
                $("input").each(function () {
                    if($("input").val()==null||$("input").val()==""){
                        ok=false;
                        $("#s3").text("不能为空")
                    }else {
                        ok=true;
                        $("#s3").text("")
                    }
                })
                if(ok&&ok1&&ok2&&ok3){
                    $("#p1").submit();
                }else {
                    return false;
                }
            })
            $("#q1").blur(function () {
                var a=/^[0-9]{1,3}$/;
                if (!a.test($("#q1").val())){
                    ok1=false;
                    $("#s1").text("最大为三为最小一位")
                }else {
                    $("#s1").text("")
                    ok1=true;
                }
            })

            $("#q2").blur(function () {
                var a=/^[0-9]{11}$/;
                if (!a.test($("#q2").val())){
                    ok2=false;
                    $("#s2").text("电话长度为11")
                }else {
                    ok2=true
                    $("#s2").text("")
                }
            })
            $("#q3").blur(function () {
                var rule = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                if (!rule.test($("#q3").val())){
                    ok3=false;
                    $("#s4").text("邮箱格式不正确")
                }else {
                    ok3=true
                    $("#s4").text("")
                }
            })
        })
    </script>
</head>
<body>
<h1 align="center">欢迎来到用户界面</h1>
<div id="d1">
    <a href="getResume?currentPage=1">查看简历</a>
    <span onclick="a()">添加简历</span>
</div>
<div id="d2">
    <div>
        <table  width="900" align="center">
            <tr>
                <td align="center"><p>个人简历</p>
                </td>
                <td >
                </td>
            </tr>
        </table>
        <p id="s3" style="color: red"></p>
        <form method="post" action="addResume">
            <table  align="center" width="800">
                <hr width="700" align="left">
                <tr>
                    <td>姓名：</td>
                    <td width="60" height="50">
                        <input type="text" name="rb_name"/>
                    </td >
                    <td width="60" height="50">性别：</td>
                    <td width="100" height="50">
                        <input type="radio" name="rb_sex" value="男"/>男<br/>
                        <input type="radio" name="rb_sex" value="女"/>女<br/>
                    </td>
                    <td width="60" height="50">民族：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_national"/>
                    </td>
                </tr>
                <tr>
                    <td width="60" height="50" >年龄：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_age" id="q1"/>
                        <p id="s1" style="color: red"></p>
                    </td>
                    <td width="60" height="50" >联系电话：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_phone" id="q2"/>
                        <p id="s2" style="color: red"></p>
                    </td>
                    <td></td>
                    <td width="60" height="50"></td>
                </tr>
                <tr>
                    <td width="60" height="50">学历：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_schooling"/>
                    </td>
                    <td width="60" height="50">专业：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_major"/>
                    </td>
                    <td width="60" height="50">毕业学校：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_school"/>
                    </td>
                </tr>
                <tr>
                    <td width="60" height="50">住址：</td>
                    <td height="50">
                        <input type="text" name="rb_address"/>
                    </td>
                </tr>
                <tr>
                    <td width="60" height="50">电子邮箱：</td>
                    <td height="50">
                        <input type="text" name="rb_email" id="q3"/>
                        <p id="s4"></p>
                    </td>
                </tr>
                <tr>
                    <td>求职意向:</td>
                    <td height="50">
                        <textarea name="rb_objective">

                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>爱好特长：</td>
                    <td height="50px">
                        <textarea name="rb_hobby"style="height: 100px"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>自我评价：</td>
                    <td height="50px">
                        <textarea name="rb_introduce" style="height: 100px">

                        </textarea>
                    </td>
                </tr>
            </table>
            <input type="submit" value="注册" id="p1">
        </form>
        <hr width="800" align="center">
    </div>
</div>
</body>
</html>
