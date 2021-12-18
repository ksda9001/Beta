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
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/customerlinfo.css">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="header2.jsp" />

<div class="con1">
    <div class="con2">
        <div style="width: 800px; margin: 20px 200px;">
            <a href="${pageContext.request.contextPath}/jsp/main.jsp"
               style="color: gray; fint-size: 18px">首页></a> <span
                style="color: gray; fint-size: 18px">等级信息</span><br>
            <br>
            <h2>个人信息</h2>
            <div style="margin: 0 0 30px 630px;width: 180px;">
                <a href="${pageContext.request.contextPath}/jsp/updatepad.jsp?customerPad=${customer.customerPad}" class="btn btn-sm btn-info glyphicon glyphicon-edit">修改密码</a>
                <a href="${pageContext.request.contextPath}/customerInfo/update2?customerId=${customer.customerId}"  class="btn btn-sm btn-warning glyphicon glyphicon-repeat">修改信息</a><br>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered">
                        <tr>
                            <td>乘客号</td>
                            <td>${customer.customerId }</td>
                            <td>姓名</td>
                            <td>${customer.customerName }</td>
                        </tr>
                        <tr>
                            <td>性别</td>
                            <td>${customer.customerSex }</td>
                            <td>年龄</td>
                            <td>${customer.customerAge }</td>
                        </tr>
                        <tr>
                            <td>出生日期</td>
                            <td>${customer.customerBifthday }</td>
                            <td>轿厢等级</td>
                            <td>${customer.customerDept }</td>
                        </tr>
                        <tr>
                            <td>车厢号</td>
                            <td>${customer.customerMajor }</td>
                            <td>车次</td>
                            <td>${customer.customerClassId }</td>
                        </tr>
                        <tr>
                            <td>电话</td>
                            <td>${customer.customerCellPhone }</td>
                            <td>密码</td>
                            <td>******</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>



    </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>