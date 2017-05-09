<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Postcreation</title>
</head>
<body>

<%--<form action="savepost" method="post" enctype="multipart/form-data">--%>
    <%--<label>Input post title</label>--%>
    <%--<input type="text" name="posttitle"><br>--%>

    <%--<label>Input post description</label>--%>
    <%--<textarea name="postdescription"></textarea><br>--%>

    <%--<label>Input post text</label>--%>
    <%--<textarea name="posttext"></textarea><br>--%>

    <%--<label>Choose post category</label>--%>
    <%--<select name="postcategory">--%>
        <%--<option value="Traveling">Traveling</option>--%>
        <%--<option value="City guide">City guide</option>--%>
        <%--<option value="Lifestyle">Lifestyle</option>--%>
    <%--</select>--%>

    <%--<label>Choose post picture</label>--%>
    <%--<input type="file" name="picture">--%>

    <%--<select name="blog">--%>
        <%--<c:forEach items="${blogs}" var="blog">--%>
        <%--<option value="${blog.id}">${blog.blogTitle}</option>--%>
    <%--</c:forEach>--%>
    <%--</select>--%>

    <%--<input type="submit">--%>
    <%--<input type="hidden"--%>
           <%--name="${_csrf.parameterName}"--%>
           <%--value="${_csrf.token}"/>--%>
<%--</form>--%>
<sf:form action="savepost" method="post" modelAttribute="emptyPost" enctype="multipart/form-data">

    <label>Post title : </label><sf:input path="posttitle"/><br>
    <label>Post description : </label><sf:textarea path="postdescription"/><br>
    <label>Post text : </label><sf:textarea path="posttext"/><br><br>
    <label>Choose post category : </label><sf:select path="postcategory">
        <sf:option value="Traveling">Traveling</sf:option>
        <sf:option value="City guide">City guide</sf:option>
        <sf:option value="Lifestyle">Lifestyle</sf:option>
    </sf:select><br><br>
    <label>Post picture : </label><input type="file" name="picture"><br><br>

    <label>Choose name of blog : </label><sf:select path="blog">
        <c:forEach items="${blogs}" var="blog">
            <sf:option value="${blog.id}">${blog.blogTitle}</sf:option>
        </c:forEach>
    </sf:select><br>
    <input type="submit">
</sf:form>
<br><br><br>

<sf:form action="saveblog" method="post" modelAttribute="emptyBlog" enctype="multipart/form-data">

    <label>Blog title : </label><sf:input path="blogTitle"/><br>
    <sf:errors path="blogTitle" cssClass=""/>
    <label>Blog description : </label><sf:input path="blogDescription"/><br>
    <label>Blog picture : </label><input type="file" name="pic"><br>
    <input type="submit">
</sf:form>


<a href="toindex">to index</a>
</body>
</html>
