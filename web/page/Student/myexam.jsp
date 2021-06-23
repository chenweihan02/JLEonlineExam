<%@ page import="cn.bean.ExamPaper" %>
<%@ page import="cn.bean.Exam" %>
<%@ page import="cn.dao.Demo.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: xiaochen
  Date: 2021/6/17
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%--%>
<%--    String path = request.getContextPath();--%>
<%--    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>

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
<script type="text/javascript">
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
            <th>答卷</th>
            <th>得分</th>
            <th>总分</th>
        </tr>
        </thead>
        <c:forEach items="${examInfo}" var="exam">
            <tr>
                <td style="font-size: 12px;">${exam.key.examName}</td>
                <td style="font-size: 12px;"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${exam.key.startTime}" /></td>
                <td style="font-size: 12px;"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${exam.key.endTime}" /></td>
                <td><a href="doExam?examId=${exam.key.id}" title="答卷">答卷</a></td>
                <td style="font-size: 12px;">${exam.value}</td>
                <td>${exam.key.totalScore}</td>
            </tr>
        </c:forEach>
    </table>
    <%--静态包含分页条--%>
    <%@include file="../common/page_nav.jsp"%>
</div>
</body>
</html>
