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
    <title>添加等级信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customerlinfo.css">
    <style>
        input{
            border: 0;
            outline-color: white; /* 轮廓颜色  */
        }
    </style>
    <!-- 禁用自动完成 ：autocomplete="off" -->

</head>
<body>
<jsp:include page="header.jsp" />

<div class="con1">
    <div class="con2">
        <a href="${pageContext.request.contextPath}/jsp/main.jsp" class="jfj">首页></a>
        <a href="${pageContext.request.contextPath}/clazzInfo/queryClazz" class="jfj">等级信息></a>
        <span class="jfj">添加等级</span><br><br>
        <h3>添加等级信息</h3>
        <form action="${pageContext.request.contextPath}/clazzInfo/addClazz" name="addcustomer">
            <div style="width: 500px; margin: 20px 400px;">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered">
                            <tr>
                                <td>乘客号</td>
                                <td><input type="text" name="clazzId" placeholder="*必填" autocomplete="off" /></td>
                            </tr>
                            <tr>
                                <td>等级</td>
                                <td><input type="text" name="clazzName" placeholder="*必填" autocomplete="off" /></td>
                            </tr>
                            <tr>
                                <td>速度</td>
                                <td><input type="text" name="buyYear" placeholder="*必填" autocomplete="off" /></td>
                            </tr>
                            <tr>
                                <td>驾驶员</td>
                                <td><input type="text" name="driver" placeholder="*必填" autocomplete="off" /></td>
                            </tr>
                            <tr>
                                <td>操作</td>
                                <td><input type="text" name="selectHour" placeholder="*必填" autocomplete="off" /></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div>
                    <input type="reset" name="reset" value="重置" class="btn btn-sm btn-info" style="margin: 0 50px 0 150px;">
                    <input type="submit" name="update" value="提交" class="btn btn-sm btn-info " style="margin: 0 50px;">
                </div>
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>