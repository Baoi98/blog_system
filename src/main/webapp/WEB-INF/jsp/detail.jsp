<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ronin</title>
    <link rel="shortcut icon" type="image/x-icon" href="/static/images/web-icon.png" media="screen"/>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/detail.css">
    <script src="/static/js/jquery-3.2.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body background="/static/images/bg.png">

<div>

    <jsp:include page="header.jsp"/>

    <div id="container">
        <article class="article">
            <time id="time1">
                <fmt:formatDate value="${article.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </time>
            <h2 style="text-align: center; ">${article.title}</h2>
            <p style="position: center" class="text-info">点击量:${article.click}</p>
            <section>
                <blockquote>
                    <p>${article.desci}</p>
                </blockquote>
                <p id="zhengwen">
                    ${article.content}
                </p>
                <p style="text-align:center;color:#ccc;font-size:12px;margin-top:40px;">
                    希望你今年过得比去年好一点
                    <br>
                    是因为有我
                </p>
                <p style="margin: 5em 0 1em;text-align: center;color: #83b8ec;font-size: .8em">
                    <span>Have a nice day :)</span>
                </p>
            </section>
        </article>
    </div>

    <%--<% int i = 1; %>--%>
    <c:forEach items="${commentList}" var="comment">
        <article class="comment" style="font-size: 16px;">
            <section style="text-align:left">
                ${fn:length(commentList)}楼&nbsp;&nbsp;
                ${comment.name}&nbsp;&nbsp;
                <fmt:formatDate value="${comment.date}" pattern="yyyy-MM-dd HH:mm:ss"/> <br/><br/>
                <p>${comment.content}</p><br/>
            </section>
        </article>
    </c:forEach>


    <div class="form-horizontal" role="form" style="margin-left:8%;margin-top: 50px;">
        <div class="form-group">
            <label for="content" class="col-sm-2 control-label">评论</label>
            <div class="col-sm-3">
                <textarea id="content" class="form-control" rows="5" placeholder="文明上网，理性发言"></textarea>
            </div>
        </div>
        <input id="articleId" type="hidden" value="${article.id}">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">昵称</label>

            <div class="col-sm-3">
                <input type="text" id="name" class="form-control"
                       placeholder="昵称">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-3">
                <input type="email" id="email" class="form-control" placeholder="邮箱">
            </div>
        </div>
        <div class="form-group" style="position:relative;left:14%">
            <br/>
            <p style="text-align: right;color: red;position: absolute" id="info"></p>
            <br/>
            <button id="commentButton" class="btn btn-default" type="submit" style="width: 200px;">提交</button>
        </div>

    </div>

    <div style="position: relative;left: 15%;margin-top: 50px;margin-bottom: 50px;">
        <c:if test="${!empty lastArticle }">
            <div style="display: inline-block;width: 300px;"><a href="/article/?id=${lastArticle.id}"><h4><span
                    class="label label-primary">上一篇:${lastArticle.title}</span></h4></a></div>
        </c:if>
        <c:if test="${!empty nextArticle }">
            <div style="display: inline-block;width: 300px;float: right;margin-right: 30%;"><a href="/article/?id=${nextArticle.id}"><h4><span
                    class="label label-success">下一篇:${nextArticle.title}</span></h4></a></div>
        </c:if>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</div>
</div>
</body>

<script src="/static/js/view/detail.js"></script>
</html>