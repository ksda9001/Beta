<%--Copyright© 2021 谈翰文--%>

<%--This program is free software: you can redistribute it and/or modify--%>
<%--it under the terms of the GNU General Public License as published by--%>
<%--the Free Software Foundation, either version 3 of the License, or--%>
<%--(at your option) any later version.--%>

<%--This program is distributed in the hope that it will be useful,--%>
<%--but WITHOUT ANY WARRANTY; without even the implied warranty of--%>
<%--MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the--%>
<%--GNU General Public License for more details.--%>

<%--You should have received a copy of the GNU General Public License--%>
<%--along with this program.  If not, see <https://www.gnu.org/licenses/>.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注销</title>
    <style>
        .body{
            color: black;
            size: 18px;
            font-family: 新宋体;
        }
        .body a{
            color: black;
            size: 18px;
            font-family: 新宋体;

        }
    </style>
</head>
<body class="body">
<p>用户注销成功！<br/></p>
<p id="show">5秒后自动返回登录页面，如果你不想等待，可以直接点击<a href="${pageContext.request.contextPath}/jsp/login.jsp">返回登录页面</a><br/></p>
<script type="text/javascript">
    var t=4;//设定跳转的时间
    setInterval("refer()",1000); //启动1秒定时
    function refer(){
        if(t==0){
            location="${pageContext.request.contextPath}/jsp/login.jsp"; //#设定跳转的链接地址
        }
        document.getElementById('show').innerHTML=""+t+"秒后自动返回登录页面，如果你不想等待，可以直接点击<a href=\"${pageContext.request.contextPath}/jsp/login.jsp\">返回登录页面</a>"; // 显示倒计时
        t--; // 计数器递减
    }
</script>
</body>
</html>
