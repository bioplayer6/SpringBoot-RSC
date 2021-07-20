<%@page import="project.pojo.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请假(休假审批)</title>
</head>
<body>
<%
List<Note> notes=(List<Note>)request.getSession().getAttribute("notes");
%>
<center>
    <table border="1" cellpadding="0" cellspacing="0" width="600x" height="100px">
        <tr>
            <th>编号</th>
                <th>邮差名称</th>
                <th>状态</th>
                <th>天数</th>
                <th>审批状态</th>
        </tr>
      <c:forEach items="${notes}" var="note">
                <c:if test="${note.note_status == 0}">
                    <c:set var="restate" scope="request" value="请假"></c:set>
                </c:if>
                <c:if test="${note.note_status== 2}">
                    <c:set var="restate" scope="request" value="休假"></c:set>
                </c:if>
<tr>
               
                <td>${note.note_id}</td>
                <td>${note.note_post.post_name}</td>
                <td>${restate}</td>
                <td>${note.note_days}</td>
                <td>
                 <c:if test="${note.note_state == 0}">
                    <a href="/admin/shen?id=${note.note_post.post_id}&state=${note.note_status}&nid=${note.note_id}&day=${note.note_days}">审批通过</a>
                </c:if>
                <c:if test="${note.note_state==1}">
                    审批已结束
                </c:if>
                    
              
                </td>
                </tr>
            </c:forEach> 

</table>
</center>
</body>
</html>