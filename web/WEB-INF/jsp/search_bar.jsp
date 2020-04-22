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
<%--    <!-- Favicon -->--%>
<%--    <link href="${pageContext.request.contextPath}/resource/img/favicon.ico" rel="shortcut icon"/>--%>

<%--    <!-- Google font -->--%>
<%--    <link href="https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i,900%7cRoboto:400,400i,500,500i,700,700i&display=swap" rel="stylesheet">--%>


<%--    <!-- Stylesheets -->--%>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/slicknav.min.css"/>--%>

<%--    <!-- Main Stylesheets -->--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"/>--%>


<%--    <!--[if lt IE 9]>--%>
<%--    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
<%--    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
<%--    <![endif]-->--%>
</head>
<body>

<section class="hero-section set-bg" data-setbg="${pageContext.request.contextPath}/resource/img/hero-bg.jpg">
    <div class="container">
        <div class="hero-warp">
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

<%--<script src="https://code.jquery.com/jquery-3.2.1.js"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/jquery.slicknav.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/resource/js/main.js"></script>--%>
</body>
</html>
