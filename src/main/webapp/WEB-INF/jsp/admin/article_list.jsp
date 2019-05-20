
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<div style="position: relative;top: 10%">
    <c:if test="${!empty succ}">
        <div class="alert alert-success" role="alert">
                ${succ}
        </div>
    </c:if>
    <c:if test="${!empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
</div>
<table class="table table-sm">
    <thead>
    <tr class="table-info">
        <th>id</th>
        <th width="25%">标题</th>
        <th>发表时间</th>
        <th>点击量</th>
        <th>详情</th>
        <th>评论</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${articleList}" var="article">
    <tr>
        <th scope="row">${article.id}</th>
        <td>${article.title}</td>
        <td><fmt:formatDate value="${article.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td>${article.click}</td>
        <td>
            <button type="button" class="btn btn-outline-info btn-sm" onclick="fullScreen('《${article.title}》','/admin/article/detail?id=${article.id}')">详情</button>
        </td>
        <td>
            <button type="button" class="btn btn-outline-success btn-sm" onclick="fullScreen('《${article.title}》|评论管理','/admin/article/comment?id=${article.id}')">评论</button>
        </td>
        <td>
            <button type="button" class="btn btn-outline-primary btn-sm" onclick="fullScreen('《${article.title}》|编辑','/admin/article/edit?id=${article.id}')">编辑</button>&nbsp;&nbsp;
        </td>
        <td>
            <button type="button" class="btn btn-outline-danger btn-sm" onclick="ifdelete('${article.id}','${article.title}') ">删除</button>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<%--
<nav aria-label="Page navigation example" style="position: absolute;bottom: 10px;left: 42%">
    <ul class="pagination justify-content-center">
        <li class="page-item  <c:if test="${pageInfo.pageNum==1}">disabled</c:if> ">
            <a class="page-link" href="/admin/article/list?page=1" >&laquo;</a>
        </li>
        <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="pageNo">
            <li class="page-item <c:if test="${pageInfo.pageNum==pageNo}">active</c:if>"><a class="page-link" href="/admin/article/list?page=${pageNo}">${pageNo}</a></li>
        </c:forEach>
        <li class="page-item  <c:if test="${pageInfo.pageNum==pageInfo.pages}">disabled</c:if> ">
            <a class="page-link" href="/admin/article/list?page=${pageInfo.pages}">&raquo;</a>
        </li>
    </ul>
</nav>
--%>
<script src="/static/js/jquery-3.2.1.min.js"></script>
<script src="/static/js/view/article_list.js"></script>
</body>
</html>