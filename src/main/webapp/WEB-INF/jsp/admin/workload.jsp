<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有邮差工作量和工资汇总成直方图</title>
<script type="text/javascript" src="/js/echarts.js"></script>
</head>
<body>
<center>
<div id="chartmain" style="width:600px; height: 400px;"></div>
</center>
<script type="text/javascript">

var postname = new Array();
var postnum = new Array();
<c:forEach items="${sessionScope.workloads}" var="workload">
postnum.push(${workload*200+1000});
</c:forEach>
<c:forEach items="${sessionScope.post_names}" var="name">
postname.push("${name}");
</c:forEach>
            //指定图标的配置和数据
            var option ={
                title:{
                    text:"12月的邮差工作量统计"
                },
                tooltip:{

                },
                legend:{
                    data:['12月工资']
                },
                xAxis:{
                    data:postname
                },
                yAxis:{},
                series:[{
                    name:'12月工资',
                    type:'bar',
                    data:postnum
                }]
            }
            var mycharts=echarts.init(document.getElementById("chartmain"));
            mycharts.setOption(option);
        </script>
</body>
</html>