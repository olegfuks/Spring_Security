
<%@include file="header.jsp"%>
<div class="blogTitle">
    <img src="${blog.avatar}"><br><br>
    <p class="singleBlogTitle">${blog.blogTitle}</p>
    <p class="singleBlogDescription">${blog.blogDescription}</p>
</div>

<c:forEach items="${blog.posts}" var="post">
    <div class="blogpost">
        <a href="/showpost-${post.id}"><img src="${post.picture}"></a>
        <p class="blogpostTitle">${post.posttitle}</p>
        <p class="blogpostText">${post.postdescription}</p>
        <p>Created by ${post.owner}</p>
    </div>
</c:forEach>

<%@include file="footer.jsp"%>

