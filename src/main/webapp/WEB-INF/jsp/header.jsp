<%--
  Created by IntelliJ IDEA.
  User: hjw
  Date: 2019-5-18
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <header id="header">
        <nav>
            <ul>
                <li>
                    <a href="/">首页</a>
                    <a href="/about">关于</a>
                </li>
            </ul>
            <div class="my-info" onmouseover="hiddeewm()" onmouseout="hiddeewm()">
                <figure></figure>
                <span>Ronin</span>
                <div id="hiddenewm" hidden="true">
                    <img src="/static/images/me.jpg" width="200px" height="200px">
                    <p></p>
                </div>
            </div>
        </nav>
    </header>
    <div id="bg">
        <p>
            和所有以梦为马的诗人一样
            <br>
            岁月易逝 一滴不剩
        </p>
    </div>
</div>
</body>
</html>
