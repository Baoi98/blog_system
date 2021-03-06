<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>博客管理系统</title>
    <link rel="shortcut icon" type="image/x-icon" href="/static/images/web-icon.png" media="screen" />
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.2.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/login.css"/>
</head>
<body>
<c:if test="${!empty error}">
    <script>
        alert("${error}");
        window.location.href="login.html";
    </script>
</c:if>
<h2 style="text-align: center;font-family: 'Adobe 楷体 Std R';color: black">博客管理系统</h2>
<div style="float:right;" id="github_iframe"></div>
<div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img src="/static/images/82839-106.jpg" alt="第一张">
        </div>
        <div class="item">
            <img src="/static/images/105905-106.jpg" alt="第二张">
        </div>
        <div class="item">
            <img src="/static/images/296494-106.jpg" alt="第三张">
        </div>

    </div>
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev">&lsaquo;
    </a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next">&rsaquo;
    </a>
</div>
<div id="login">
    <div class="form-inline"  >

        <div class="input-group">
            <span class="input-group-addon">账号</span>
            <input type="text" class="form-control" name="adminName" id="adminName">
        </div>
        <br/>
        <br/>
        <div class="input-group">
            <span class="input-group-addon">密码</span>
            <input type="password" class="form-control" name="password" id="password">
        </div>
        <br/>
        <p style="text-align: right;color: red;position: absolute" id="info"></p>

        <br/>
        <button id="loginButton"  class="btn btn-primary">登陆</button>

    </div>


</div>
</body>

<script src="/static/js/view/login.js"></script>
</html>