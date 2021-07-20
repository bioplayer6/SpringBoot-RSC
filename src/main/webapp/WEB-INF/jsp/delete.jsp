<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<%
int number=(int)session.getAttribute("number");
if(number==1) {%>
    删除成功!
    <%}else{%>
   
    	删除失败,该用户不存在
    	<%} %>
    	
    
</body>
</html>