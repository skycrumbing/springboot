<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/10 0010
  Time: 下午 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product</title>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <thead>
        <tr>
            <td>id</td>
            <td>name</td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.content}" var="c" varStatus="sta">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div align="center">
    <div>当前是第${page.number}页</div>
    <div>
        <a href="?start=0">首页</a>
        <a href="?start=${page.number-1}">上一页</a>
        <a href="?start=${page.number+1}">下一页</a>
        <a href="?start=${page.totalPages-1}">尾页</a>
    </div>
</div>
</body>
</html>
