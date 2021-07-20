<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顾客注册页面</title>
</head>
<body>
 <center>
        <h2>顾客注册界面</h2>
<form action="/cust/regist">
姓名:<input type="text" name="name"/><br/><br/>
密码:<input type="password" name="password"/><br/><br/>
地址:<input type="text" length="20" name="address"/><br/><br/>
电话<input type="text" length="20" name="phone"/><br/><br/>
<select>
    <option>从化区</option>
</select>
&nbsp;&nbsp;
<select name="id">
    <option value="1">太平镇</option>
    <option value="2">良口镇</option>
</select>
<br/><br/>
<input type="submit" value="注册"/>
</form>
</center>
</body>
</html>