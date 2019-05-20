
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>博客管理系统</title>
    <link rel="stylesheet" href="/static/css/bootstrap4.0.min.css" >
    <script src="/static/js/jquery.slim.min.js" ></script>
    <script src="/static/js/popper.min.js" ></script>
    <script src="/static/js/bootstrap4.0.min.js"></script>
    <script src="/static/js/layer.js"></script>
</head>
<body>

<jsp:include page="adminHeader.jsp"/>

<div class="card mb-3">
    <div style="height: 180px;overflow: hidden">
        <img class="card-img-top" src="/static/images/82839-106.jpg" alt="Card image cap" style="height: 100%;width:100%;">
    </div>

    <div class="card-body">
        <h4 class="card-title">${admin.username}</h4>
        <p class="card-text"><small class="text-muted">上次登录时间:${adminLoginLog.date}</small></p>
        <p class="card-text"><small class="text-muted">上次登录IP:${adminLoginLog.ip}</small></p>
        <p class="card-text"><small class="text-muted">本次登录IP:${ipAddress}</small></p>
    </div>
</div>
<div >
    <table class="table table-hover">
        <p class="text-success" style="text-align: center"> 系统统计</p>
        <thead>
        <tr >
            <th>#</th>
            <th>文章数</th>
            <th>评论数</th>
            <th>登陆次数</th>
        </tr>
        </thead>
        <tbody>
        <tr class="table-success">
            <th scope="row">全部</th>
            <td>${articleCount}</td>
            <td>${commentCount}</td>
            <td>${adminLoginCount}</td>
        </tr>
        </tbody>
    </table>
</div>

<div style="width: 50%;position: relative;left: 25%">
    <table class="table table-sm" >
        <p class="text-success" style="text-align: center"> 系统信息</p>

        <tr>
            <th scope="row">服务器IP</th>
            <td>${localAddr}</td>
        </tr>
        <tr>
            <th scope="row">服务器端口</th>
            <td>${serverPort}</td>
        </tr>
        <tr>
            <th scope="row">服务器当前时间</th>
            <td>${date}</td>
        </tr>

    </table>
</div>
<script>
    function fullScreen(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            area: ['70%', '70%'],
            content: url,
            maxmin: true
        });
        layer.full(index);
    }
</script>
</body>
</html>