<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
查询
<br/>
<table class="table table-bordered" style="font-family:微软雅黑">
<tr>
<th>EID</th>
<th>EName</th>
<th>EAge</th>
</tr>
<c:forEach items="${sessionScope.employees}" var="user">
<tr>
<td>${user.id}</td>
<td>${user.name}</td>
<td>${user.age}</td>
</tr>
</c:forEach>
</table>
</body>
</html>