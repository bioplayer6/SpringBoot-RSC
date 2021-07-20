<%@page import="project.pojo.Post"%>
<%@page import="project.pojo.Post_workload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>计件页面</title>
</head>
<body>
<%
Post_workload workload=(Post_workload)request.getSession().getAttribute("workload");
Post_workload workloadT=(Post_workload)request.getSession().getAttribute("workloadT");
Post_workload workloadM=(Post_workload)request.getSession().getAttribute("workloadM");
Post post=(Post)request.getSession().getAttribute("post");
Integer gongzuoliang=workloadM.getPost_re_num()+workloadM.getPost_se_num();
Integer gongzi=gongzuoliang*200+1000;
%>
<center>
邮差${post.post_name}12月的计件总数如下:<br/>
收件数:${workload.post_re_num}&nbsp;&nbsp;派件数${workload.post_se_num}&nbsp;&nbsp;收件故障数:${workload.post_re_broke}
&nbsp;&nbsp;派件故障数:${workload.post_se_broke}&nbsp;&nbsp;<br/>
当天的计件数如下:<br/>
收件数:${workloadT.post_re_num}&nbsp;&nbsp;派件数${workloadT.post_se_num}&nbsp;&nbsp;收件故障数:${workloadT.post_re_broke}
&nbsp;&nbsp;派件故障数:${workloadT.post_se_broke}&nbsp;&nbsp;<br/>
截至目前过去一个月的计件数与工资如下:<br/>
收件数:${workloadM.post_re_num}&nbsp;&nbsp;派件数${workloadM.post_se_num}&nbsp;&nbsp;收件故障数:${workloadM.post_re_broke}
&nbsp;&nbsp;派件故障数:${workloadM.post_se_broke}&nbsp;&nbsp;<br/>
工资:<%=gongzi %>
</center>
</body>
</html>