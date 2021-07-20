<%@page import="project.pojo.Shoujian"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顾客查收件页面</title>
</head>
<body>
<%
List<Shoujian> shoujians=(List<Shoujian>)request.getSession().getAttribute("shoujians");
%>
<center>
    <table border="1" cellpadding="0" cellspacing="0" width="600x" height="100px">
        <tr>
            <th>编号</th>
                <th>寄件名称</th>
                <th>寄件收件人/号码</th>
                <th>寄件派送人</th>
                <th>寄件发出时间</th>
                <th>寄件目的地</th>
                <th>寄件送达时间</th>
                <th>寄件当前状态</th>
        </tr>
      <c:forEach items="${shoujians}" var="shoujian">
                <c:if test="${shoujian.re_status.st_id == 0}">
                    <c:set var="restate" scope="request" value="收件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="无效时间"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${shoujian.re_status.st_id == 1}">
                    <c:set var="restate" scope="request" value="准备收件"></c:set>
                    <c:set var="reendtime" scope="request" value="请稍等....."></c:set>
                    <tr class="warning">
                </c:if>
                <c:if test="${shoujian.re_status.st_id == 2}">
                    <c:set var="restate" scope="request" value="正在收件"></c:set>
                    <c:set var="reendtime" scope="request" value="等待到达"></c:set>
                    <tr class="info">
                </c:if>
                <c:if test="${shoujian.re_status.st_id ==3}">
                    <c:set var="restate" scope="request" value="收件完成"></c:set>
                    <c:set var="reendtime" scope="request" value="${shoujian.re_enddate}"></c:set>
                    <tr class="success">
                </c:if>
                <c:if test="${shoujian.re_status.st_id== 4}">
                    <c:set var="restate" scope="request" value="收件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="邮客号码出错"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${shoujian.re_status.st_id== 5}">
                    <c:set var="restate" scope="request" value="收件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="邮客地址出错"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${shoujian.re_status.st_id== 6}">
                    <c:set var="restate" scope="request" value="收件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="其他"></c:set>
                    <tr class="danger">
                </c:if>
                <td>${shoujian.re_id}</td>
                <td>${shoujian.re_name}</td>
                <td>${shoujian.re_customer_id.cust_name}/${shoujian.re_customer_id.cust_phone}}</td>
                <td>${shoujian.re_post_id.post_name}</td>
                <td>${shoujian.re_startdate}</td>
                <td>${shoujian.re_endaddress}</td>
                <td>${reendtime}</td>
                <td>${restate}</td>
                </tr>
            </c:forEach> 

</table>
</center>
</body>
</html>