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
    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/resource/img/favicon.ico" rel="shortcut icon"/>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i,900%7cRoboto:400,400i,500,500i,700,700i&display=swap" rel="stylesheet">


    <!-- Stylesheets -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/slicknav.min.css"/>

    <!-- Main Stylesheets -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"/>


    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- Header Section -->
<header class="header-section">
    <a href="${pageContext.request.contextPath}/home" class="site-logo">
        <img src="${pageContext.request.contextPath}/resource/img/logo.png" alt="">
    </a>
    <nav class="header-nav">
        <ul class="main-menu">
            <li><a href="${pageContext.request.contextPath}/home" class="active">Home</a></li>
            <li><a href="about-us.html">About</a></li>
<%--            <li><a href="#">Buy</a></li>--%>
<%--            <li><a href="#">Pages</a>--%>
<%--                <ul class="sub-menu">--%>
<%--                    <li><a href="about-us.html">About Us</a></li>--%>
<%--                    <li><a href="search-result.html">Search Result</a></li>--%>
<%--                    <li><a href="single-property.html">Property</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>
<%--            <li><a href="news.html">News</a></li>--%>
            <li><a href="${pageContext.request.contextPath}/property-form">Post Listing</a></li>
        </ul>
        <div class="header-right">
            <div class="user-panel">
                <a href="#" class="login">Sign in</a>
                <a href="#" class="register">Join us</a>
            </div>
        </div>
    </nav>
</header>
<!-- Header Section end -->
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/jquery.slicknav.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/main.js"></script>
</body>
</html>
