<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>The everyday moments</title>
    <link rel="stylesheet" href="/TRIGER/style.css">
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
    <script src="javascript/jquery-3.2.1.js"></script>
</head>
<body>
<div id="main_obgortka">
    <div id="menu">
        <div id="menu_1">
            <ul class="nav_1">
                <li><a href="/">Travel</a></a> </li>
                <li class="padding-left_300"><a href="poststraveling">Traveling</a></li>
                <li><a href="cityguide">City guide</a></li>
                <li><a href="lifestyle">Lifestyle</a></li>
                <sec:authorize access="isAuthenticated()">
                <li class="padding-left_220"><a href="postcreation">Create</a></li>
                </sec:authorize>
                <li class="login"><a href="toLogin" >Login</a></li>
            </ul>
        </div>
    </div>
        <div class="content">






</body>