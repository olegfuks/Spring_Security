<%@include file="header.jsp"%>
    <div class="single_post">
        <img src="${post.picture}">
        <p class="single_post_title">${post.posttitle}</p>
        <p class="single_post_description">${post.postdescription}</p>
        <p class="single_post_text">${post.posttext}</p>
        <%--<h4>Category: ${post.postcategory}</h4>--%>
        <p class="single_post_date">Date: ${post.postdate}</p>
    </div>

<%@include file="footer.jsp"%>