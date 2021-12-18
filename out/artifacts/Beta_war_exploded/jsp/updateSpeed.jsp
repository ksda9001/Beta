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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% if(session.getAttribute("name")==null)
    response.sendRedirect("login.jsp");%>

<html>
<head>
    <title>更新时速信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customerlinfo.css">
    <style type="text/css">
        input{
            border: 0;
            outline-color: white;
            background-color: #white
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="con1">
    <div class="con2">
        <a href="${pageContext.request.contextPath}/jsp/main.jsp" class="jfj">首页></a>
        <a href="${pageContext.request.contextPath}/speedInfo/querySpeed" class="jfj">成绩信息></a>
        <span class="jfj">更新时速</span><br><br>
        <h3>更新时速信息</h3>
        <form action="${pageContext.request.contextPath}/speedInfo/updateSpeed" name="update">
            <div style="width: 500px; margin: 20px 400px;">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered">
                            <tr>
                                <td>乘客号</td>
                                <td><input type="text" name="customerId" readonly value="${speed.customerId}" /></td>
                            </tr>
                            <tr>
                                <td>等级</td>
                                <td><input type="text" name="clazzId" readonly value="${speed.clazzId}" /></td>
                            </tr>
                            <tr>
                                <td>速度</td>
                                <td><input type="text" name="speed" value="${speed.speed}" /></td>
                            </tr>
                        </table>
                        <div>
                            <input type="submit" name="update" value="提交" class="btn btn-sm btn-info " style="margin: 0 50px 0 150px;">
                            <a href="${pageContext.request.contextPath}/speedInfo/querySpeed" class="btn btn-sm btn-info" style="margin-left: 50px">返回</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>