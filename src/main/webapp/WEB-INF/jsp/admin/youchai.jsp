<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员查邮差界面</title>
</head>
<body>
<center>
<h2><a href="/admin/post">添加邮差</a></h2>
<table border="1" cellpadding="0" cellspacing="0" width="600x" height="100px">
        <tr>
            <th>编号</th>
                <th>邮差名</th>
                <th>邮差密码</th>
                <th>邮差所在区域</th>
                <th>邮差工作状态</th>
                <th>邮差电话</th>
                <th>邮差工作情况</th>
        </tr>
        <c:forEach items="${sessionScope.posts}" var="post">
        <tr>
            <td width="50px" height="50px">${post.post_id}</td>
            <td width="50px" height="50px">${post.post_name}</td>
            <td width="50px" height="50px">${post.post_password}</td>
            <td width="100px">
            <c:if test="${post.post_area.area_id==1}">从化太平镇</c:if>>
            <c:if test="${post.post_area.area_id==2}">从化良口镇</c:if>>
            </td>
            <td width="100px">
            
            <c:if test="${post.post_work==0}">请假<br/><a href="/admin/upinfo?nid=${post.post_work}&pid=${post.post_id}">修改为在岗</a></c:if>>
            <c:if test="${post.post_work==1}">在岗</c:if>>
            <c:if test="${post.post_work==2}">休假<br/><a href="/admin/upinfo?nid=${post.post_work}&pid=${post.post_id}">修改为在岗</a></c:if>>
            <c:if test="${post.post_work==3}">加班</c:if>>
            
            </td>
            <td width="100px">${post.post_phone}</td>
            <td width="150px">
           <a href="/admin/situation?pid=${post.post_id}">本月工作情况</a>
            </td>
        </tr>
        </c:forEach>
</table>
</center>
</body>
</html>