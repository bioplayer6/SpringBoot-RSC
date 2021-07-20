<%@page import="project.pojo.Paijian"%>
<%@page import="project.pojo.Shoujian"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员查派件页面</title>
</head>
<body>
<%
List<Paijian> paijians=(List<Paijian>)request.getSession().getAttribute("paijians");
%>
<center>
    <h2><a href="/admin/hand">手动派件</a></h2>
    <table border="1" cellpadding="0" cellspacing="0" width="600x" height="100px">
        <tr>
            <th>编号</th>
                <th>派件名称</th>
                <th>派件收件人/号码</th>
                <th>派件派送人</th>
                <th>派件发出时间</th>
                <th>派件目的地</th>
                <th>派件送达时间</th>
                <th>派件当前状态</th>
        </tr>
           <c:forEach items="${paijians}" var="paijian">
                <c:if test="${paijian.se_status.st_id == 0}">
                    <c:set var="restate" scope="request" value="派件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="无效时间"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${paijian.se_status.st_id == 1}">
                    <c:set var="restate" scope="request" value="准备派件"></c:set>
                    <c:set var="reendtime" scope="request" value="请稍等....."></c:set>
                    <tr class="warning">
                </c:if>
                <c:if test="${paijian.se_status.st_id == 2}">
                    <c:set var="restate" scope="request" value="正在派件"></c:set>
                    <c:set var="reendtime" scope="request" value="等待到达"></c:set>
                    <tr class="info">
                </c:if>
                <c:if test="${paijian.se_status.st_id ==3}">
                    <c:set var="restate" scope="request" value="派件完成"></c:set>
                    <c:set var="reendtime" scope="request" value="${paijian.se_enddate}"></c:set>
                    <tr class="success">
                </c:if>
                <c:if test="${paijian.se_status.st_id== 4}">
                    <c:set var="restate" scope="request" value="派件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="邮客号码出错"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${paijian.se_status.st_id== 5}">
                    <c:set var="restate" scope="request" value="派件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="邮客地址出错"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${paijian.se_status.st_id== 6}">
                    <c:set var="restate" scope="request" value="派件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="其他"></c:set>
                    <tr class="danger">
                </c:if>
                <td>${paijian.se_id}</td>
                <td>${paijian.se_name}</td>
                <td>${paijian.se_customer_id.cust_name}/${paijian.se_customer_id.cust_phone}}</td>
                <td>${paijian.se_post_id.post_name}</td>
                <td>${paijian.se_startdate}</td>
                <td>${paijian.se_endaddress}</td>
                <td>${reendtime}</td>
                <td>${restate}</td>
                </tr>
            </c:forEach> 

</table>
</center>
</body>
</html>