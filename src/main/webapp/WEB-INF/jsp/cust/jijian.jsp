<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顾客寄件页面</title>
</head>
<script>
function checkdata()
{
re_name=document.fw.re_name.value;
phone=document.fw.re_phone.value;
endaddress=document.fw.re_endaddress.value;
if(re_name.length<1||re_name.length>10)
{
alert("寄件名长度必须在1到10之间!");
return false;
}
if(phone.length<8||phone.length>11)
{
alert("电话号码必须在8到11位之间!");
return false;
}
if(endaddress.length==0||endaddress.length<5)
{
alert("邮寄地址为空或者不全!");
return false;
}
return true;
}
</script>
<body>
 <center>
        <h2>寄件界面</h2>
<form action="/cust/jijian" name="fw" OnSubmit="return checkdata();">
寄件名:<input type="text" name="re_name"/><br/><br/>
电话:<input type="text" name="re_phone"/><br/><br/>
详细地址:<input type="text" name="re_endaddress"/><br/><br/>
<input type="submit" value="寄件"/>
</form>
</center>
</body>
</html>