<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员查用户界面</title>
</head>
<body>
<center>
<table border="1" cellpadding="0" cellspacing="0" width="600x" height="100px">
        <tr>
            <th>编号</th>
                <th>用户名</th>
                <th>用户密码</th>
                <th>用户所在区域</th>
                <th>用户手机</th>
                <th>用户具体地址</th>
        </tr>
        <c:forEach items="${sessionScope.customers}" var="customer">
        <tr>
            <td>${customer.cust_id}</td>
            <td>${customer.cust_name}</td>
            <td>${customer.cust_password}</td>
            <td><select><option>从化区</option></select>&nbsp;&nbsp;
            <select>
            <option value="1" <c:if test="${customer.cust_area.area_id==1}">selected="selected"</c:if>>太平镇</option>
            <option value="2" <c:if test="${customer.cust_area.area_id==2}">selected="selected"</c:if>>良口镇</option>
            </select>
            </td>
            <td>${customer.cust_phone}</td>
            <td>${customer.cust_address}</td>
        </tr>
        </c:forEach>
</table>
</center>
</body>
</html>