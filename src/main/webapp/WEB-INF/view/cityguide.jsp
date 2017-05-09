<%@include file="header.jsp"%>

<c:forEach items="${cityguide}" var="city">
    <div id="post-${city.id}" class="sorted_posts">
        <a href="/showpost-${city.id}">
            <%--<img src="/image/my_photo.jpeg"></a><br><br>--%>
                <img src="${city.picture}"></a><br><br>
        <p class="sorted_posts_title">${city.posttitle}</p>
        <p class="sorted_posts_description">${city.postdescription}</p>
        <p class="sorted_posts_date">Date: ${city.postdate}<br></p>
        <%--<p class="sorted_posts_category">Category: ${city.postcategory}</p>--%>
    </div>
</c:forEach>
<%@include file="footer.jsp"%>