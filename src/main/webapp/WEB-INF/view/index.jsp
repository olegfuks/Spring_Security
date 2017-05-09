<%@include file="header.jsp"%>


<c:forEach items="${blogs}" var="blog">
    <div class="mainPageblogs">

        <a href="/show-blog-${blog.id}"><img src="${blog.avatar}"></a><br><br>
        <p class="singleBlogTitle">${blog.blogTitle}</p>
        <p class="singleBlogDescription">${blog.blogDescription}</p>

    </div>

</c:forEach>
<%--<c:forEach items="${posts}" var="post">--%>
    <%--<div id="post-${post.id}">--%>
        <%--<a href="/showpost-${post.id}">--%>
            <%--<img src="${post.picture}"></a><br><br>--%>
        <%--<p>Date: ${post.postdate}<br>--%>
            <%--Category: ${post.postcategory}</p>--%>
        <%--<h3>${post.posttitle}</h3>--%>
        <%--<h6>${post.postdescription}</h6>--%>
    <%--</div>--%>
<%--</c:forEach>--%>
<%@include file="footer.jsp"%>