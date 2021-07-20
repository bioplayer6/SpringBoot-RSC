<%@page import="project.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顾客个人信息页面</title>
</head>
<body>
<% Customer customer=(Customer)request.getSession().getAttribute("customer"); 
%>
<center>
        <form>
    姓名:<input type="text" value="<%=customer.getCust_name() %>"/><br/><br/>
    密码:<input type="text" value="<%=customer.getCust_password() %>"/><br/><br/>
    具体地址:<input type="text" length="30" value="<%=customer.getCust_address() %>"/><br/><br/>
    <input type="submit" value="修改"/>
</form>
    </center>
</body>
</html>