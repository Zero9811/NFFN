<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/4/23
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/img/favicon.ico">

    <title>Floating labels example for Bootstrap</title>
    <!--引用bootstrap的时候要在引用链接中跟上项目名称-->
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap4.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/lib/css/floating-labels.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <form class="form-signin" action="login.action" method="post">
        <div class="text-center mb-4">
            <img class="mb-4" src="resources/img/bootstrap-solid.svg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">Floating labels</h1>
            <p>欢迎登陆我们的网站 <code>:placeholder-shown</code> pseudo-element. <a href="https://caniuse.com/#feat=css-placeholder-shown">Works in latest Chrome, Safari, and Firefox.</a></p>
        </div>
        <div class="form-label-group">
            <input type="text" id="inputEmail" class="form-control" name="username" placeholder="用户名或者邮箱" required autofocus>
            <label for="inputEmail">用户名或者邮箱</label>

        </div>

        <div class="form-label-group">
            <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
            <s:fielderror></s:fielderror>
            <label for="inputPassword">Password</label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <div class="text-center"><a href="registerJump.action" >        新申请一个账号</a></div>
        <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
    </form>
</div>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/bootstrap4.min.js"></script>
</body>
</html>

