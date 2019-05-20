<%--
  Created by IntelliJ IDEA.
  User: hjw
  Date: 2019-5-19
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand text-success" href="/admin/main">博客管理</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <!-- Example single danger button -->
                <div class="btn-group">
                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        新建
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="javascript:void(0);" onclick="fullScreen('添加文章','/admin/article/add')">文章</a>
                        <!-- <a class="dropdown-item" href="#">评论</a>-->
                    </div>
                </div>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/admin/main">主页 </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/admin/article/list">文章管理</a>

            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0" action="/admin/article/search" method="GET">
            <input class="form-control mr-sm-2" type="search" placeholder="文章标题或内容..." aria-label="Search" name="keyWords" id="keyWords">
            <button class="btn btn-outline-success my-2 my-sm-0 btn-sm" type="submit">搜索</button>
        </form>

        <a class="btn btn-outline-danger btn-sm" href="/admin/logout" role="button">退出</a>
    </div>
</nav>
</body>
</html>
