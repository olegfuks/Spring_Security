<%--
  Created by IntelliJ IDEA.
  User: olegf
  Date: 25.04.2017
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="save" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="text" name="email">
    <input type="submit">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</body>
</html>
