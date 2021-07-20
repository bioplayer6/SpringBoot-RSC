<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加邮差</title>
</head>
<body>
<center>
<form action="/admin/addpost">
邮差名:<input type="text" name="post_name"/><br/>
邮差密码:<input type="text" name="post_password"/><br/>
邮差电话:<input type="text" name="post_phone"/><br/>
<select name="area_id">
<option value="1">太平镇</option>
<option value="2">良口镇</option>
</select><br/>
<input type="submit" value="添加邮差"/>
</form>
</center>
</body>
</html>