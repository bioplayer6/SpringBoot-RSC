<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
Search!!!
<br/>
<%
List<String> depart=(List<String>)session.getAttribute("depart");
if(null == depart || depart.size() ==0 ){
%>
查询失败，没有此员工
<%}else{ 

%>
查询到${depart.size()}个用户<br/>
<c:forEach items="${depart}" var="departid">
  ${sessionScope.employeeName}&nbsp;&nbsp;
   部门名称:${departid}
   <br/>
   </c:forEach>
   <%
   } %>
</body>
</html>