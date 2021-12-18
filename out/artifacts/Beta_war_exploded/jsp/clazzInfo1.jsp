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
    <title>等级信息管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customerlinfo.css">

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<jsp:include page="header2.jsp" />

<div class="con1">
    <div class="con2">
        <a href="${pageContext.request.contextPath}/jsp/main1.jsp" class="jfj">首页></a>
        <span class="jfj">等级信息</span><br><br>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>

                        <th>乘客号</th>
                        <th>等级</th>
                        <th>速度</th>
                        <th>驾驶员</th>
                        <th>收费</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="clazz" items="${requestScope.pagemsg.lists}">
                        <tr>

                            <td>${clazz.clazzId }</td>
                            <td>${clazz.clazzName }</td>
                            <td>${clazz.buyYear }</td>
                            <td>${clazz.driver }</td>
                            <td>${clazz.selectHour }</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


        <table border="0" cellspacing="0" cellpadding="0" width="900px">
            <tr>
                <td>
                    <span>第${requestScope.pagemsg.currPage }/${requestScope.pagemsg.totalPage}页</span>
                    <span>总记录数：${requestScope.pagemsg.totalCount } 每页显示:${requestScope.pagemsg.pageSize}</span>
                    <span>
						<c:if test="${requestScope.pagemsg.currPage != 1}">
                            <a style="color: black;" href="${pageContext.request.contextPath}/clazzInfo/queryById?currentPage=1&id=${requestScope.pagemsg.id}">首页</a>
                            <a style="color: black;" href="${pageContext.request.contextPath }/clazzInfo/queryById?currentPage=${requestScope.pagemsg.currPage-1}&id=${requestScope.pagemsg.id}">上一页</a>
                        </c:if> <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
                        <a style="color: black;" href="${pageContext.request.contextPath }/clazzInfo/queryById?currentPage=${requestScope.pagemsg.currPage+1}&id=${requestScope.pagemsg.id}">下一页</a>
                        <a style="color: black;" href="${pageContext.request.contextPath }/clazzInfo/queryById?currentPage=${requestScope.pagemsg.totalPage}&id=${requestScope.pagemsg.id}">尾页</a>
                    </c:if>
					</span>
                </td>
            </tr>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>