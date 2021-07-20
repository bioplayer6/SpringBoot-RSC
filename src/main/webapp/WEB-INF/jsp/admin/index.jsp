<%@page import="project.pojo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员主页</title>
</head>
<body>
<%
Admin admin=(Admin)request.getSession().getAttribute("admin");
%>
<center><h3>欢迎你，管理员<%=admin.getAdmin_username() %> </h3></center>
    <table width="100%" height="700" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="15%" height="100%" valign="top">
                <div class="left">
                <br/>
                    <div>
                        <center>
                        <img src="/image/图片1.png" alt=""
                        style="margin-left:10px;margin-right:10px;width: 60px;height: 50px;border-radius: 30px;"/>
                        <a href="/admin/home" style="text-decoration: none" target="mainFrame" ><font size="4px">首页</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/admin/yonghu" style="text-decoration: none" target="mainFrame" ><font size="4px">用户</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/admin/paijian" style="text-decoration: none" target="mainFrame" ><font size="4px">派件</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/admin/shoujian" style="text-decoration: none" target="mainFrame" ><font size="4px">收件</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/admin/youchai" style="text-decoration: none" target="mainFrame" ><font size="4px">邮差</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/admin/suanjian" style="text-decoration: none" target="mainFrame" ><font size="4px">系统计件</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/admin/workload" style="text-decoration: none" target="mainFrame" ><font size="4px">系统计算工作量</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/admin/shenpi" style="text-decoration: none" target="mainFrame"><font size="4px">请假(休假)审批</font></a>&nbsp;&nbsp;&nbsp;
                    </center>
                    </div>
                </div>
            </td>
    </tr>
    <tr>
        <td width="80%" valign="top">
            <iframe src="/admin/home"   name="mainFrame" frameborder="0" marginheight="0" marginwidth="0" height="700" width="100%">
            </iframe>
        </td>
    </tr>
    </table>
</body>
</html>