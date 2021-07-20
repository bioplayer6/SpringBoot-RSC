<%@page import="project.pojo.Post"%>
<%@page import="project.pojo.Shoujian"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮差收件页面</title>
</head>
<body>
<%
List<Shoujian> shoujians=(List<Shoujian>)request.getSession().getAttribute("shoujians");
Post post=(Post)request.getSession().getAttribute("post");
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
                <th>寄件可修改状态</th>
        </tr>
      <c:forEach items="${shoujians}" var="shoujian">
                <c:if test="${shoujian.re_status.st_id == 0}">
                    <c:set var="restate" scope="request" value="收件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="无效时间"></c:set>
                    <c:set var="state" scope="request" value="0"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${shoujian.re_status.st_id == 1}">
                    <c:set var="restate" scope="request" value="准备收件"></c:set>
                    <c:set var="reendtime" scope="request" value="请稍等....."></c:set>
                    <c:set var="state" scope="request" value="1"></c:set>
                    <tr class="warning">
                </c:if>
                <c:if test="${shoujian.re_status.st_id == 2}">
                    <c:set var="restate" scope="request" value="正在收件"></c:set>
                    <c:set var="reendtime" scope="request" value="等待到达"></c:set>
                    <c:set var="state" scope="request" value="2"></c:set>
                    <tr class="info">
                </c:if>
                <c:if test="${shoujian.re_status.st_id ==3}">
                    <c:set var="restate" scope="request" value="收件完成"></c:set>
                    <c:set var="reendtime" scope="request" value="${shoujian.re_enddate}"></c:set>
                    <c:set var="state" scope="request" value="3"></c:set>
                    <tr class="success">
                </c:if>
                <c:if test="${shoujian.re_status.st_id== 4}">
                    <c:set var="restate" scope="request" value="收件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="邮客号码出错"></c:set>
                    <c:set var="state" scope="request" value="0"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${shoujian.re_status.st_id== 5}">
                    <c:set var="restate" scope="request" value="收件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="邮客地址出错"></c:set>
                    <c:set var="state" scope="request" value="0"></c:set>
                    <tr class="danger">
                </c:if>
                <c:if test="${shoujian.re_status.st_id== 6}">
                    <c:set var="restate" scope="request" value="收件失败"></c:set>
                    <c:set var="reendtime" scope="request" value="其他"></c:set>
                    <c:set var="state" scope="request" value="0"></c:set>
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
                <td>
                    <%
                        if (post.getPost_work()==0){
                    %>
                    <a href="" disabled="true">
                        <span></span>当前为休息状态
                    </a>
                    <%
                        }
                        else if (post.getPost_work()==2){
                    %>
                    <a href="" disabled="true">
                        <span></span>当前为休假状态
                    </a>
                    <%}else {%>
                    <c:if test="${state=='0'}">
                        <a href="" disabled="true">
                            <span></span>该操作无效
                        </a>
                    </c:if>
                    <c:if test="${state=='1'}">
                        <a href="/post/status?st_id=2&re_id=${shoujian.re_id}">
                            <span></span>正在寄件
                        </a>
                        <a href="/post/status?st_id=4&re_id=${shoujian.re_id}">
                            <span></span>寄件失败
                        </a>
                    </c:if>
                    <c:if test="${state=='2'}">
                        <a href="/post/status?st_id=3&re_id=${shoujian.re_id}">
                            <span></span>寄件完成
                        </a>
                        <a href="/post/status?st_id=5&re_id=${shoujian.re_id}">
                            <span></span>寄件失败
                        </a>
                    </c:if>
                    <c:if test="${state=='3'}">
                        <a href="">
                            <span></span>寄件已结束
                        </a>
                    </c:if>
                    <%}%>
                </td>
                </tr>
            </c:forEach> 

</table>
</center>
</body>
</html>