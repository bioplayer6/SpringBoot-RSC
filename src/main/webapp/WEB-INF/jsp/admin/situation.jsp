<%@page import="project.pojo.Post"%>
<%@page import="project.pojo.Post_situation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>饼图显示某邮差工作情况</title>
<script type="text/javascript" src="/js/echarts.js"></script>
</head>
<body>
<%
Post post=(Post)request.getSession().getAttribute("postS");
Post_situation situation=(Post_situation)request.getSession().getAttribute("situation");
%>
<center>
<div id="chartmain" style="width:600px; height: 400px;"></div>
</center>
<script type="text/javascript">
        var mycharts=echarts.init(document.getElementById("chartmain"));
        mycharts.setOption({
            //设置全局背景色
            backgroundColor: '#2c343c',
            //设置文字颜色
             textStyle: {
                color: 'rgba(255, 255, 255, 0.3)'
           },

            //设置标题
            title:{
                backgroundColor:'rgb(128, 128, 128)',
                text:"邮差12月的工作情况"
            },
            series:[{
                name:'访问来源',
                type:'pie',
                roseType: 'angle',//设置南丁格尔图的配置项
                radius:'55%',
                //文字颜色等也可以在系列中单独设置，使用label标签
                /*label: {
                    normal:{
                        textStyle: {
                        color: 'white'
                    },
                    }

                },*/
                //设置饼图的视觉引导线
                    labelLine: {
                        normal:{
                            lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                        }
                    },
                itemStyle: {//阴影的配置
                    // 阴影的大小
                    shadowBlur: 200,
                    // 阴影水平方向上的偏移
                    shadowOffsetX: 0,
                    // 阴影垂直方向上的偏移
                    shadowOffsetY: 0,
                    // 阴影颜色
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    //鼠标 hover 时候的高亮样式
                     emphasis: {
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                data:[
                    {value:${situation.post_qingjia},name:'请假'},
                    {value:${situation.post_jiaban}, name:'加班'},
                    {value:${situation.post_zaigang}, name:'在岗'},
                    {value:${situation.post_xiujia}, name:'休假'},
                ]
            }]
        })
    </script>
    <center>
    请假天数:${situation.post_qingjia}
    休假天数:${situation.post_xiujia}
    在岗天数:${situation.post_zaigang}
   加班天数:${situation.post_jiaban}
    
    </center>
</body>
</html>