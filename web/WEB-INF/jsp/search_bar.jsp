<%--
  Created by IntelliJ IDEA.
  User: jedidiahbowo
  Date: 4/19/20
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<section class="page-top-section set-bg" data-setbg="${pageContext.request.contextPath}/resource/img/hero-bg.jpg">
    <div class="container">
        <div class="page-top-warp">
            <form action="${pageContext.request.contextPath}/search/location.do" class="main-search-form" id="search_form">
                <div class="search-type">
                    <div class="st-item">
                        <input type="radio" name="list_for" id="buy" checked>
                        <label for="buy">Buy</label>
                    </div>
                    <div class="st-item">
                        <input type="radio" name="list_for" id="rent">
                        <label for="rent">Rent</label>
                    </div>
                </div>
                <div class="search-input si-v-2">
                    <input type="text" name="keyword" placeholder="Search by state, zipcode or city">
                    <button class="site-btn" form="search_form">Search</button>
                    <button class="site-btn sb-light">Show Filters</button>
                </div>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. </p>
            </form>
        </div>
    </div>
</section>

</body>
</html>
