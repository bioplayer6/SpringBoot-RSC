<%@page import="project.pojo.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮差个人信息页面</title>
</head>
<body>
<% Post post=(Post)request.getSession().getAttribute("post"); 
%>
<center>
       姓名:<%=post.getPost_name() %><br/>
       密码:<%=post.getPost_password() %><br/>
       工作状况:<c:if test="${post.post_work==0}">休息</c:if>
       <c:if test="${post.post_work==1}">在岗</c:if>
       <c:if test="${post.post_work==2}">休假</c:if>
       <c:if test="${post.post_work==3}">加班</c:if>       
       <br/>
      电话号码:<%=post.getPost_phone() %><br/>
      <a href="/post/jia?id=3">我要加班</a><br/>
      <form action="/post/xiu">
      <input type="hidden" name="id" value="0"/>
      天数:<input type="text" name="day"/><br/>
      <input type="submit" value="我要请假"/>
      </form>
      
      <form action="/post/xiu">
      天数:<input type="text" name="day"/><br/>
      <input type="hidden" name="id" value="2"/>
      <input type="submit" value="我要休假"/>
      </form>
      
    </center>
</body>
</html>