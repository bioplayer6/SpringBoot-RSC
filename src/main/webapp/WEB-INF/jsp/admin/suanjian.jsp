<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="project.pojo.Post_workload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统计件</title>
</head>
<body>
<% Post_workload workload=(Post_workload)request.getSession().getAttribute("suanjian"); 
   Date start=(Date)request.getSession().getAttribute("start");
   Date end=(Date)request.getSession().getAttribute("end");
   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
%>
<center>
<form action="/admin/suanjianF">
 开始时间:<input type="date" name="kaishi"/>&nbsp;&nbsp;<br/>
            结束时间:<input type="date" name="jiesu"/>&nbsp;&nbsp;<br/>
            <input type="submit" value="系统计件"/>
</form>
<br/>
<br/>
<%if(workload!=null){ %>
系统在<%=df.format(start) %>到<%=df.format(end) %>时间段的计件总数如下:<br/>
收件数:<%=workload.getPost_re_num() %>&nbsp;&nbsp;派件数:<%=workload.getPost_se_num() %>&nbsp;&nbsp;收件故障数:<%=workload.getPost_re_broke() %>
&nbsp;&nbsp;派件故障数:<%=workload.getPost_se_broke() %>&nbsp;&nbsp;<br/>
<%} %>
</center>
</body>
</html>