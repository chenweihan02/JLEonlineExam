<%--User: xiaochen Date: 2021/6/24 Time: 16:16--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>列表</title>
    <link rel="stylesheet" href="${basePath}static/css/index.css" />
    <link rel="stylesheet"
          href="${basePath}static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script src="${basePath}static/js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<div style="padding-left: 10px">
    <table class="tablelist">
        <thead>
        <tr>
            <th>内容</th>
            <th>时间</th>
        </tr>
        </thead>
        <c:forEach items="${logList}" var="log">
            <tr>
                <td style="font-size: 12px;">${log.content}</td>
                <td style="font-size: 12px;"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${log.createTime}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

