<%@page import="project.pojo.Post"%>
<%@page import="project.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手动派件</title>
</head>
<body>
<%
List<Customer> customers=(List<Customer>)request.getSession().getAttribute("custs");
List<Post> posts=(List<Post>)request.getSession().getAttribute("chais");
%>
<center>
<form action="/admin/shoudong">
派件名称:<input type="text" name="se_name"/><br/>
派件电话:<input type="text" name="se_phone"/><br/>
派件具体地址:<input type="text" name="se_endaddress"/><br/>
派送顾客:
<select name="cust_id">
<c:forEach items="<%=customers %>" var="cust">
<option value="${cust.cust_id}">${cust.cust_name}</option>
</c:forEach>
</select><br/>
派送邮差:
<select name="post_id">
<c:forEach items="<%=posts %>" var="post">
<option value="${post.post_id}">${post.post_name}</option>
</c:forEach>
</select>
<input type="submit" value="添加派件">
</form>
</center>
</body>
</html>