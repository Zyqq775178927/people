<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 13:46
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
        #d2{
            position: absolute;
            margin-left: 300px;
            width: 780px;
            height: 600px;
            background-color: green;
        }
    </style>
    <script src="jq/jquery.js"></script>
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
<%
    session.getAttribute("resum");
    int totalPages= (int) session.getAttribute("totalPages");
    int currentPage= (int) session.getAttribute("currentPage");
%>
<div id="d2">
    <table  width="900" align="center">
        <tr>
            <td align="center"><p>个人简历</p>
            </td>
            <td >
            </td>
        </tr>
    </table>
    <p id="s3" style="color: red"></p>
    <form method="post" action="updateResume">
        <table  align="center" width="800">
            <c:forEach items="${sessionScope.resum}" var="i">
                <tr>
                    <td>
                        <c:if test="${sessionScope.re_id!=null}">
                            <a href="cv?rb_id=${i.rb_id}">投递简历</a>
                        </c:if>
                    </td>
                </tr>
                <hr width="700" align="left"/>
                <tr>
                    <td>姓名：</td>
                    <td width="60" height="50">
                        <input type="text" name="rb_name" value="${i.rb_name}"/>
                    </td >
                    <td width="60" height="50">性别：</td>
                    <td width="100" height="50">
                       <input type="text" name="rb_sex" value="${i.rb_sex}">
                    </td>
                    <td width="60" height="50">民族：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_national" value="${i.rb_national}"/>
                    </td>
                </tr>
                <tr>
                    <td width="60" height="50" >年龄：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_age" id="q1" value="${i.rb_age}"/>
                        <p id="s1" style="color: red"></p>
                    </td>
                    <td width="60" height="50" >联系电话：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_phone" id="q2" value="${i.rb_phone}"/>
                        <p id="s2" style="color: red"></p>
                    </td>
                    <td></td>
                    <td width="60" height="50"></td>
                </tr>
                <tr>
                    <td width="60" height="50">学历：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_schooling" value="${i.rb_schooling}"/>
                    </td>
                    <td width="60" height="50">专业：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_major" value="${i.rb_major}"/>
                    </td>
                    <td width="60" height="50">毕业学校：</td>
                    <td width="100" height="50">
                        <input type="text" name="rb_school" value="${i.rb_school}"/>
                    </td>
                </tr>
                <tr>
                    <td width="60" height="50">住址：</td>
                    <td height="50">
                        <input type="text" name="rb_address" value="${i.rb_address}"/>
                    </td>
                </tr>
                <tr>
                    <td width="60" height="50">电子邮箱：</td>
                    <td height="50">
                        <input type="text" name="rb_email" value="${i.rb_email}" id="q3"/>
                        <p id="s4"></p>
                    </td>
                </tr>
                <tr>
                    <td>求职意向:</td>
                    <td height="50">
                        <input type="text" name="rb_objective" value="${i.rb_objective}">
                    </td>
                </tr>
                <tr>
                    <td>爱好特长：</td>
                    <td height="50px">
                        <textarea name="rb_hobby"style="height: 100px">
                            ${i.rb_hobby}
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>自我评价：</td>
                    <td height="50px">
                        <textarea name="rb_introduce" style="height: 100px">
                            ${i.rb_introduce}
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td><input type="hidden" value="${i.rb_id}" name="rb_id"></td>
                    <td width="50px"><input type="submit" value="修改" id="p1"></td>
                    <td width="50px"><a href="deleteResume?rb_id=${i.rb_id}"><input type="button" value="删除"></a></td>
                </tr>
            </c:forEach>

        </table>
    </form>
    <hr width="800" align="center">
    <div align="center">
        <a href="getResume?currentPage=<%=currentPage>1?currentPage-1:1%>">上一页</a>
        <a href="getResume?currentPage=<%=currentPage<totalPages?currentPage+1:totalPages%>">下一页</a>
        <a href="usermain" >返回</a>
    </div>
</div>
</body>
</html>
