<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户查询</title>
</head>
<body>
部门信息查询
<form action="/getIDAndNameByDepartNameAndAge" method="POST" name="form1">
部门名:<input type="text" name="dname" /><hr/>
年龄:<input type="text" name="age"/>
员工名:<input type="text" name="employeeName"/>
<br/>
<input type="submit" value="查询1"/>
<input type="button" value="查询2"  class="mulButton" name="cx" id="btn01" onclick="search('/getDepartNameByEmployeeName')"/>
<input type="button" value="删除"  class="mulButton" name="cx1" id="btn02" onclick="search('/deleteEmployeeByEmployeeName')"/>
<script>
function search(href){
	var form=document.form1;
	form.action=href;
	form.submit();
}
</script>

</form>
</body>
</html>