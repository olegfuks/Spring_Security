<%@include file="header.jsp"%>

<c:forEach items="${lifestyle}" var="style">
    <div id="post-${style.id}" class="sorted_posts">
        <a href="/showpost-${style.id}">
            <%--<img src="/image/my_photo.jpeg"></a><br><br>--%>
                <img src="${style.picture}"></a><br><br>
        <p class="sorted_posts_title">${style.posttitle}</p>
        <p class="sorted_posts_description">${style.postdescription}</p>
        <p class="sorted_posts_date">Date: ${style.postdate}</p><br>
        <%--<p class="sorted_posts_category">Category: ${style.postcategory}</p>--%>
    </div>
</c:forEach>
<%@include file="footer.jsp"%>