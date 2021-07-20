<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录页面</title>
</head>
<body>
<center>
        <h2>管理员登录界面</h2>
        <form action="/admin/login">
                  姓名:<input type="text" name="loginName"/><br/><br/>
                  密码:<input type="password" name="password"/><br/><br/>
          <input type="submit" value="登录"/>
         </form>
</center>
</body>
</html>