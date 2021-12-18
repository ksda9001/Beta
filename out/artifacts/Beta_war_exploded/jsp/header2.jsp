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
<% if(session.getAttribute("name")==null)
    response.sendRedirect("login.jsp");%>
<html>
<head>
    <title>火车乘员管理系统</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/home_page.css">

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">

    <div class="header1"><img class="img" src="${pageContext.request.contextPath}/img/top02.png" alt="sign_light"></div>
    <div class="header2">火车乘员系统</div>
    <div class="header3">
        <%String name = (String)session.getAttribute("name");out.println(name + " 欢迎你！");%>|

        <div class="btn-group">
            <button type="button" class="btn btn-default dropdown-toggle btn-xs glyphicon glyphicon-cog" data-toggle="dropdown">
                <span class="caret"> </span>
            </button>
            <ul class="dropdown-menu pull-right" role="menu">
                <li><a href="${pageContext.request.contextPath}/customerInfo/queryByName" class="glyphicon glyphicon-user">个人中心</a></li>
                <li><a href="${pageContext.request.contextPath}/login/userexit" class="glyphicon glyphicon-off">退出登录</a></li>
            </ul>
        </div>


        <%--  <a href="${pageContext.request.contextPath}/login/userexit" class="glyphicon glyphicon-off">退出登录</a> --%>
    </div>
</div>

<div class="nav nav1">
    <a href="${pageContext.request.contextPath}/jsp/main1.jsp">系统首页</a>
    <a href="${pageContext.request.contextPath}/customerInfo/queryByName">个人中心</a>
    <a href="${pageContext.request.contextPath}/clazzInfo/queryById">等级信息</a>
    <a href="${pageContext.request.contextPath}/speedInfo/queryById"> 时速信息</a>
</div>
</body>
</html>