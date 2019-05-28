<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<body>
<h2>Hello News!</h2>
<div>

    <a href="news.html">新闻页</a>


</div>
</body>
</html>
