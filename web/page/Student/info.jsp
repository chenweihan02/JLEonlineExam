<%--
  Created by IntelliJ IDEA.
  User: xiaochen
  Date: 2021/6/17
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta charset="utf-8">
    <link  rel="stylesheet"  href="../../static/css/index.css" />
    <link rel="stylesheet"  href="../../static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script  src="../../static/js/jquery.min.js" type="text/javascript"></script>
</head>
<body style="height: 100%; margin: 0">
<div class="add">
    <table class="tablelist" style="width: 30%;margin-left:50px">
        <tr>
            <td>学号:</td>
            <td>${user.s_id}</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>${user.s_name}</td>
        </tr>
    </table>
</div>
</body>
</html>

