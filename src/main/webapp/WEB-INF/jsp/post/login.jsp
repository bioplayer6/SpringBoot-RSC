<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮差登录页面</title>
</head>
<body>
<center>
        <h2>邮差登录界面</h2>
        <form action="/post/login">
                  姓名:<input type="text" name="loginName"/><br/><br/>
                  密码:<input type="password" name="password"/><br/><br/>
          <input type="submit" value="登录"/>
         </form>
</center>
</body>
</html>