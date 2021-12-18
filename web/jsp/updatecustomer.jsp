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
    <title>更新乘客信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customerlinfo.css">

    <script language="JavaScript" type="text/javascript">
        var first_keywords={};
        first_keywords['高级软卧']=['6','114514','10A'];
        first_keywords['软卧']=['10','191981','15D'];
        first_keywords['硬卧']=['11','145141','20C'];
        first_keywords['车辆人员箱']=['2','451419'];
        first_keywords['软座']=['12','514191'];
        first_keywords['硬座']=['9','141919','2As'];
        first_keywords['站票']=['7','419198'];
        first_keywords['餐车']=['4','191981','1B'];

        function change() {
            var target1 = document.getElementById("customerDept");
            var target2 = document.getElementById("customerMajor");
            var selected_1 = target1.options[target1.selectedIndex].value;
            while (target2.options.length) {
                target2.remove(0);
            }
            var initial_list = first_keywords[selected_1];
            if (initial_list) {
                for (var i = 0; i < initial_list.length; i++) {
                    var item = new Option(initial_list[i], initial_list[i]);
                    target2.options.add(item);
                }
            }
        }
    </script>

    <style type="text/css">
        input{
            border: 0;
            outline-color: white;
            background-color: #white;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="con1">
    <div class="con2">
        <a href="${pageContext.request.contextPath}/jsp/main.jsp" class="jfj">首页></a>
        <a href="${pageContext.request.contextPath}/customerInfo/query" class="jfj">乘客信息></a>
        <span class="jfj">更新学生信息</span>
        <h3>更新学生信息</h3>
        <form action="${pageContext.request.contextPath}/customerInfo/updatecustomer" name="updatecustomer">
            <div style="width: 600px; margin: 20px 380px;">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered">
                            <tr>
                                <td>乘客号</td>
                                <td><input type="text" name="customerId" readonly value="${customer.customerId}" /></td>
                                <td>姓名</td>
                                <td><input type="text" name="customerName" value="${customer.customerName}" /></td>
                            </tr>
                            <tr>
                                <td>年龄</td>
                                <td><input type="" name="customerAge" value="${customer.customerAge}" /></td>
                                <td>性别</td>
                                <td>
                                    <input type="radio" name="customerSex" value="男" ${customer.customerSex == '男' ? 'checked':''} /> 男&nbsp;
                                    <input type="radio" name="customerSex" value="女" ${customer.customerSex == '女' ? 'checked':''} /> 女
                                </td>
                            </tr>
                            <tr>
                                <td>出生日期</td>
                                <td><input type="date" name="customerBifthday" value="${customer.customerBifthday}" /></td>
                                <td>轿厢等级</td>
                                <td>
                                    <select name="customerDept" id="customerDept" onchange="change()">
                                        <option value="高级软卧" ${customer.customerDept == '高级软卧' ? 'selected':''}>高级软卧</option>
                                        <option value="软卧" ${customer.customerDept == '软卧' ? 'selected':''}>软卧</option>
                                        <option value="硬卧" ${customer.customerDept == '硬卧' ? 'selected':''}>硬卧</option>
                                        <option value="车辆人员箱" ${customer.customerDept == '车辆人员箱' ? 'selected':''}>车辆人员箱</option>
                                        <option value="软座" ${customer.customerDept == '软座' ? 'selected':''}>软座</option>
                                        <option value="硬座" ${customer.customerDept == '硬座' ? 'selected':''}>硬座</option>
                                        <option value="站票" ${customer.customerDept == '站票' ? 'selected':''}>站票</option>
                                        <option value="餐车" ${customer.customerDept == '餐车' ? 'selected':''}>餐车</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>车厢号</td>
                                <td>
                                    <select name="customerMajor" id="customerMajor">
                                        <option value="6" ${customer.customerMajor == '6' ? 'selected':''}>6</option>
                                        <option value="10" ${customer.customerMajor == '10' ? 'selected':''}>10</option>
                                        <option value="11" ${customer.customerMajor == '11' ? 'selected':''}>11</option>
                                        <option value="2" ${customer.customerMajor == '2' ? 'selected':''}>2</option>
                                        <option value="12" ${customer.customerMajor == '12' ? 'selected':''}>12</option>
                                        <option value="9" ${customer.customerMajor == '9' ? 'selected':''}>9</option>
                                        <option value="7" ${customer.customerMajor == '7' ? 'selected':''}>7</option>
                                        <option value="4" ${customer.customerMajor == '4' ? 'selected':''}>4</option>
                                        <option value="5" ${customer.customerMajor == '5' ? 'selected':''}>5</option>
                                        <option value="8" ${customer.customerMajor == '8' ? 'selected':''}>8</option>
                                    </select>
                                </td>
                                <td>车次</td>
                                <td><input type="text" name="customerClazzId" value="${customer.customerClazzId}" /></td>
                            </tr>
                            <tr>
                                <td>电话</td>
                                <td colspan="3"><input type="text" name="customerCellPhone" value="${customer.customerCellPhone}" /></td>
                            </tr>
                        </table>
                        <div>
                            <input type="submit" name="update" value="提交" class="btn btn-sm btn-info " style="margin: 0 50px 0 150px;">
                            <a href="${pageContext.request.contextPath}/customerInfo/query" class="btn btn-sm btn-info" style="margin-left: 50px">返回</a>
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