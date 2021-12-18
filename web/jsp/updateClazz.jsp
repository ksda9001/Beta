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
    <title>更新等级信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customerlinfo.css">

</head>
<body>
<jsp:include page="header.jsp" />

<div class="con1">
    <div class="con2">
        <a href="${pageContext.request.contextPath}/jsp/main.jsp" class="jfj">首页></a>
        <a href="${pageContext.request.contextPath}/clazzInfo/queryCourse" class="jfj">等级信息></a>
        <span class="jfj">更新等级</span><br> <br>
        <h3>更新等级信息</h3>
        <form action="${pageContext.request.contextPath}/clazzInfo/updateCourse" name="updatecustomer">
            <div style="width: 500px; margin: 20px 400px;">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered">
                            <tr>
                                <td>乘客号</td>
                                <td><input type="text" name="clazzId" style="border: 0; outline-color: white;" readonly value="${clazz.clazzId}" /></td>
                            </tr>
                            <tr>
                                <td>等级</td>
                                <td><input type="text" name="clazzName" style="border: 0; outline-color: white;" value="${clazz.clazzName}" /></td>
                            </tr>
                            <tr>
                                <td>速度</td>
                                <td><input type="text" name="schoolYear" style="border: 0; outline-color: white;" value="${clazz.schoolYear}" /></td>
                            </tr>
                            <tr>
                                <td>驾驶员</td>
                                <td><input type="text" name="teacher" style="border: 0; outline-color: white;" value="${clazz.teacher}" /></td>
                            </tr>
                            <tr>
                                <td>收费</td>
                                <td><input type="text" name="selectHour" style="border: 0; outline-color: white;" value="${clazz.selectHour}" /></td>
                            </tr>
                        </table>
                        <div>
                            <input type="submit" name="update" value="提交" class="btn btn-sm btn-info " style="margin: 0 50px 0 150px;">
                            <a href="${pageContext.request.contextPath}/clazzInfo/queryCourse" class="btn btn-sm btn-info" style="margin-left: 50px">返回</a>
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