<%--
  Created by IntelliJ IDEA.
  User: xiaochen
  Date: 2021/6/17
  Time: 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<!-- student-->
<head>
    <meta charset="utf-8" />
    <title>上机考试系统首页</title>
    <link rel="stylesheet" href="../../static/css/index.css" />
    <link rel="stylesheet"
          href="../../static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script src="../../static/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $('.menux p').click(function() {
                $(this).siblings('ul').slideUp(200);
                $(this).next('ul').slideToggle(200);
            });
            $('.menux p:first').trigger("click");

            $('.menux ul a').click(function() {

                $('iframe').attr("src", $(this).attr("url"));
                $('.menu_title').html($(this).attr("title"));
            });
            $(".logout").click(function(){
                if(window.confirm("确定要退出吗？")){
                    window.location.href = "../../logout"
                }
            });
        })
    </script>
</head>
<body>
<div class="header">
    <div class="logo">上机考试系统</div>
    <div class="user" style="min-width:77px">
        <i class="fa fa-caret-down point"></i> <i class="fa fa-user"></i>
        ${user.name}
        <ul>
            <c:if test="${user.isAdmin==1}">
                <li><a href="../Admin/index.jsp">切换管理员</a></li>
            </c:if>
            <li><a href="javascript:void(0)" class="logout">退出登录</a></li>
        </ul>
    </div>
</div>
<div class="left">
    <div class="title">
        <i class="fa fa-home"></i> 系统功能
    </div>
    <div class="menux">
        <p>
            <i class="fa fa-user-circle-o"></i> <i
                class="fa fa-angle-right point"></i> 教师权限
        </p>
        <ul>
            <li><a href="javascript:void(0);" url="../../teacher?action=list" title="所有考试列表">
                    <i class="fa fa-caret-right"></i> 所有考试列表</a>
            </li>
<%--            <li><a href="javascript:void(0);" url="../../exam?action=mathTest" title="考试管理">--%>
<%--                <i class="fa fa-caret-right"></i> 考试管理（高数卷子）</a>--%>
<%--            </li>--%>
<%--            <li><a href="javascript:void(0);" url="../../question?action=list" title="题库管理">--%>
<%--                <i class="fa fa-caret-right"></i> 题库管理</a>--%>
<%--            </li>--%>
<%--            <li><a href="javascript:void(0);" url="../../teacher?action=analysis" title="成绩统计">--%>
<%--                <i class="fa fa-caret-right"></i> 成绩统计</a>--%>
<%--            </li>--%>
<%--            <li><a href="javascript:void(0);" url="../Admin/pwd.jsp" title="修改密码">--%>
<%--                <i class="fa fa-caret-right"></i> 修改密码</a>--%>
<%--            </li>--%>
            <li><a href="javascript:void(0);" url="info.jsp" title="个人中心">
                    <i class="fa fa-caret-right"></i> 个人中心</a>
            </li>
        </ul>
    </div>
</div>
<div class="main">
    <div class="location">
        <i class="fa fa-home"></i> <span class="menu_title">简要介绍</span>
    </div>
    <iframe name="mainFrame" src="introduce1.jsp" width="100%" height="90%" frameborder="0px"></iframe>
</div>
</body>
</html>
