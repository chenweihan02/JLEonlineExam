<%--User: xiaochen Date: 2021/6/17 Time: 14:03--%>
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
<script type="text/javascript">
    //删除
    $(function() {
        $('.remove').click(function(event) {
            event.stopPropagation()
            var id = $(this).attr("keyword");
            if (confirm("确定要删除此考试吗？")) {
                window.location.href = "${basePath}exam?action=delete&examId=" + id;
            }
        })
    })
    //考试详细
    $(function() {
        $(".examline").click(function() {
            var examId = $(this).attr("examId");//进入exam servlet进行操作。
            window.location.href = "${basePath}exam?action=detail&examId=" + examId;
        })
    })
    //回收站
    $(function() {
        $(".recyclebinbtn").click(function() {
            window.location.href = "${basePath}exam?action=recyclebin";
        })
    })
</script>
<body>
<div style="padding-left: 10px">
    <form name="form1" id="form1" method="post" action="${basePath}teacher?action=search">
        <div class="condition">
            考试名称：<input type="text" name="examName" size="15" max=30>
            <button style="margin-left: 118px;" type="submit">
                <i class="fa fa-search"></i> 查询
            </button>
        </div>
    </form>
<%--    Temporary storage--%>
    <div class="condition">
        <button type="button" class="recyclebinbtn">
            <i class="fa fa-refresh"></i> 回收站
        </button>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>名称</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>考试状态</th>
            <th>编辑考试</th>
        </tr>
        </thead>
        <c:forEach items="${examList}" var="exam">
            <tr class="examline" examId="${exam.id}">
                <td style="font-size: 12px;">${exam.examName}</td>
                <td style="font-size: 12px;"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${exam.startTime}" /></td>
                <td style="font-size: 12px;"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${exam.endTime}" /></td>
                <%--待开始  进行中  已结束--%>
                <td>名称</td>
                <td><button class="remove" type="button" keyword="${exam.id}">
                    <i class="fa fa-remove"></i> 删除
                </button></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

