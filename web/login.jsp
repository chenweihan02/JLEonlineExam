<%--
  Created by IntelliJ IDEA.
  User: xiaochen
  Date: 2021/6/16
  Time: 20:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>登录页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./login/css/bootstrap.css" />
</head>
<body>
<div class="container" style="margin-top: 200px;">
    <div class="row">
        <div class="col-sm">
            <div class="card" style="width: 18rem;">
                <div class="card-header">
                    管理员登录
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="InputUsername2">姓名</label>
                                <input type="text" name="username" class="form-control" id="InputUsername2" value="1">
                            </div>
                            <div class="form-group">
                                <label for="InputPassword2">密码</label>
                                <input type="password" name="password" class="form-control" id="InputPassword2" value="123456" autocomplete >
                            </div>
                            <input name="type" type="hidden" value="2"/>
                            <button type="submit" class="btn btn-primary">登录</button>
                        </form>
                    </li>
                    <li class="list-group-item">
                        ${loginError2}
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm">
            <div class="card" style="width: 18rem;">
                <div class="card-header">
                    老师登录
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="InputUsername1">姓名</label>
                                <input type="text" name="username" class="form-control" id="InputUsername1" value="1">
                            </div>
                            <div class="form-group">
                                <label for="InputPassword1">密码</label>
                                <input type="password" name="password" class="form-control" id="InputPassword1" value="123456" autocomplete >
                            </div>
                            <input name="type" type="hidden" value="1"/>
                            <button type="submit" class="btn btn-primary">登录</button>
                        </form>
                    </li>
                    <li class="list-group-item">
                        ${loginError1}
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm">
            <div class="card" style="width: 18rem;">
                <div class="card-header">
                    学生登录
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="InputUsername">学号</label>
                                <input type="text" name="username" class="form-control" id="InputUsername" value="2019111">
                            </div>
                            <div class="form-group">
                                <label for="InputPassword">密码</label>
                                <input type="password" name="password" class="form-control" id="InputPassword" value="123456" autocomplete>
                            </div>
                            <input name="type" type="hidden" value="0"/>
                            <button type="submit" class="btn btn-primary">登录</button>
                        </form>
                    </li>
                    <li class="list-group-item">
                        ${loginError0}
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>