<%--
  Created by IntelliJ IDEA.
  User: xiaochen
  Date: 2021/6/17
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>列表</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="${basePath}static/css/index.css" />
    <link rel="stylesheet"
          href="${basePath}static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script src="${basePath}static/js/jquery.min.js" type="text/javascript"></script>

</head>
<script type="text/javascript">

    function countDown( maxtime,fn ) {
        var timer = setInterval(function() {
            if(maxtime>0 ){
                var day = Math.floor(maxtime / 86400),
                    hour = Math.floor((maxtime % 86400) / 3600),
                    minutes = Math.floor((maxtime % 3600) / 60),
                    seconds = Math.floor(maxtime%60),
                    msg = day+"天"+hour+"时"+minutes+"分"+seconds+"秒";
                fn( msg );
                --maxtime;
            } else {
                clearInterval( timer );
                fn("时间到，已结束!");
            }
        }, 1000);
    }

    $(function(){
        console.log("test2");
        $(".stoptimeDiv").show(function(){
            var s_i = $(this).attr("s_i");
            var stoptime = $(this).attr("stoptime");
            //获取当前时间
            var date = new Date();
            var now = date.getTime();
            console.log("now",now);
            //设置截止时间
            var endDate = new Date(stoptime);
            var end = endDate.getTime();

            var stoptime= $(this).attr("stoptime");
            //时间差
            var leftTime = (end-now)/1000;
            console.log(leftTime);
            countDown( leftTime,function( msg ) {
                document.getElementById(s_i).innerHTML = msg;
            })
        })
    })
</script>
<body>
<div style="padding-left: 10px">
    <form name="form1" id="form1" method="post">
        <div class="condition">
            考试名称：<input type="text" name="e_name" size="15" max=30
                        value="${exam.e_name}">
            <button style="margin-left: 118px;" type="button" onclick="search()">
                <i class="fa fa-search"></i> 查询
            </button>
        </div>
    </form>

    <table class="tablelist">
        <thead>
        <tr>
            <th>名称</th>
            <th>开始</th>
            <th>结束</th>
            <th>总分</th>
        </tr>
        </thead>
        <c:forEach items="${examList}" var="exam">
            <tr>
                <td style="font-size: 12px;">${exam.e_name}</td>
                <td style="font-size: 12px;">${exam.startTime}</td>
                <td style="font-size: 12px;">${exam.endTime}</td>
                <td>${exam.totalScore}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

