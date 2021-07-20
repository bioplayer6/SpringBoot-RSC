<%@page import="project.pojo.Area"%>
<%@page import="project.pojo.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顾客主页</title>
</head>
<body>
<%
Post post=(Post)request.getSession().getAttribute("post");
Area area=post.getPost_area();
%>
<center><h3>欢迎你，邮差<%=post.getPost_name() %>，你所在的区域为<%=area.getArea_qu()+area.getArea_town() %> </h3></center>
    <table width="100%" height="700" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="15%" height="100%" valign="top">
                <div class="left">
                <br/>
                    <div>
                        <center>
                        <img src="/image/图片1.png" alt=""
                        style="margin-left:10px;margin-right:10px;width: 60px;height: 50px;border-radius: 30px;"/>
                        <a href="/post/home" style="text-decoration: none" target="mainFrame" ><font size="4px">首页</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/post/shoujian" style="text-decoration: none" target="mainFrame" ><font size="4px">我的收件</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/post/paijian" style="text-decoration: none" target="mainFrame" ><font size="4px">我的派件</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/post/suanjian" style="text-decoration: none" target="mainFrame" ><font size="4px">我的计件</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/post/info" style="text-decoration: none" target="mainFrame" ><font size="4px">个人信息</font></a>&nbsp;&nbsp;&nbsp;
                        <a href="/post/fanhui" style="text-decoration: none"><font size="4px">下班</font></a>&nbsp;&nbsp;&nbsp;
                    </center>
                    </div>
                </div>
            </td>
    </tr>
    <tr>
        <td width="80%" valign="top">
            <iframe src="/post/home"   name="mainFrame" frameborder="0" marginheight="0" marginwidth="0" height="700" width="100%">
            </iframe>
        </td>
    </tr>
    </table>
</body>
</html>