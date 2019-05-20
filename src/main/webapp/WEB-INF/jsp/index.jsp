<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ronin</title>
    <link rel="shortcut icon" type="image/x-icon" href="/static/images/web-icon.png" media="screen"/>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.2.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/index.css">

</head>
<body background="/static/images/bg.png">

    <jsp:include page="header.jsp"/>


    <div id="container">
        <c:forEach items="${articleList}" var="article" >
            <article class="article">
                <time><fmt:formatDate value="${article.time}" pattern="yyyy-MM-dd HH:mm:ss" /></time>
                <h2 class="title">
                    <a href="article?id=${article.id}">${article.title}</a>
                </h2>
                <span><i>${article.keywords}</i></span>
                <section class="article-content markdown-body">
                    <blockquote>
                        <p>${article.desci}</p>
                    </blockquote>
                </section>
                <footer>
                    <a href="article?id=${article.id}">阅读全文</a>
                </footer>
            </article>
        </c:forEach>


        <div style="text-align: center">
            <ul class="pagination">
                <%-- 上一页 --%>
                <li <c:if test="${pageInfo.pageNum == 1}">class="disabled"</c:if> >
                    <a href="/?pageNum=${pageInfo.pageNum - 1}"> &laquo; </a>
                </li>
                <%-- 当前页 --%>
                <c:forEach begin="1" end="${pageInfo.pages}" step="1" var="page">
                    <li <c:if test="${pageInfo.pageNum==page}">class="active"</c:if>>
                            <a href="/?pageNum=${page}">${page}</a>
                    </li>
                </c:forEach>
                <%-- 下一页 --%>
                <li <c:if test="${pageInfo.pageNum == pageInfo.pages}">class="disabled"</c:if> >
                    <a href="/?pageNum=${pageInfo.pageNum + 1}"> &raquo; </a>
                </li>
            </ul>
        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</body>
</html>