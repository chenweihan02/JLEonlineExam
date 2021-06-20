<%--
  Created by IntelliJ IDEA.
  User: xiaochen
  Date: 2021/6/17
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>成绩分析</title>
    <link rel="stylesheet"  href="static/css/index.css" />
    <link rel="stylesheet"  href="static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script  src="static/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
    </script>
</head>
<body>

<table class="tablelist">
    <caption>成绩统计</caption>
    <thead>
    <tr>
        <th>考试名</th>
        <th>(0,60)</th>
        <th>[60,70]</th>
        <th>(70,85]</th>
        <th>(85,100]</th>
    </tr>
    </thead>
    <c:forEach items="${analysisMap}" var="item">
        <tr>
            <td>${item.key}</td>
            <td>${item.value.bad}</td>
            <td>${item.value.common}</td>
            <td>${item.value.good}</td>
            <td>${item.value.best}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

