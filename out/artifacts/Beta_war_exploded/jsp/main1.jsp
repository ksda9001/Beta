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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home_page.css">

</head>
<body>
<jsp:include page="header2.jsp" />

<div class="d" id="bodyContainer">
    <div style="background: #ffffff;margin: 0px 60px 0px 60px;padding: 50px 150px;height: 77%;">
        <div>
            <img alt="" align="center" src="../img/20160526021127672.png">
        </div>
        <div>
            <h1>火车乘员管理系统！</h1>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>