
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/css/bootstrap4.0.min.css" >
    <script src="/static/js/jquery.slim.min.js" ></script>
    <script src="/static/js/popper.min.js" ></script>
    <script src="/static/js/bootstrap4.0.min.js"></script>
</head>
<body>
<table class="table table-striped table-sm">

    <tr class="table-dark">
        <th width="15%">ID</th>
        <td >${article.id}</td>
    </tr>
    <tr class="table-secondary">
        <th>标题</th>
        <td>${article.title}</td>
    </tr>
    <tr class="table-success">
        <th>关键字</th>
        <td>${article.keywords}</td>
    </tr>
    <tr class="table-danger">
        <th>简介</th>
        <td>${article.desci}</td>
    </tr>
    <tr class="table-warning">
        <th>发表时间</th>
        <td><fmt:formatDate value="${article.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    </tr>
    <tr class="table-info">
        <th>点击量</th>
        <td>${article.click}</td>
    </tr>
    <tr class="table">
        <th>内容</th>
        <td>${article.content}</td>
    </tr>
</table>

</body>
</html>