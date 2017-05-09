<%@include file="header.jsp"%>

<c:forEach items="${traveling}" var="tt">
    <div id="post-${tt.id}" class="sorted_posts">
        <a href="/showpost-${tt.id}">
            <%--<img src="/image/my_photo.jpeg"></a><br><br>--%>
                <img src="${tt.picture}"></a><br><br>
        <p class="sorted_posts_title">${tt.posttitle}</p>
        <p class="sorted_posts_description">${tt.postdescription}</p>
        <%--<p class="sorted_posts_category">Category: ${tt.postcategory}</p>--%>
        <p class="sorted_posts_date">Date: ${tt.postdate}</p><br>
    </div>
</c:forEach>
<%@include file="footer.jsp"%>