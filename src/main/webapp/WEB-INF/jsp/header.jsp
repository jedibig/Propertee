<%--
  Created by IntelliJ IDEA.
  User: jedidiahbowo
  Date: 4/19/20
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <!-- Main Stylesheets -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/loginmodal.css"/>
</head>
<body>
<!-- Header Section -->
<header class="header-section">
    <a href="${pageContext.request.contextPath}/home" class="site-logo">
        <img src="${pageContext.request.contextPath}/resource/img/logo.png" alt="">
    </a>
    <nav class="header-nav">
        <ul class="main-menu">
            <c:choose>
                <c:when test="${pageContext.request.requestURI.contains('index')}">
                    <c:set var="home_class" value="active"/>
                </c:when>
                <c:when test="${pageContext.request.requestURI.contains('about')}">
                    <c:set var="about_class" value="active"/>
                </c:when>
                <c:when test="${pageContext.request.requestURI.contains('post_property')}">
                    <c:set var="form_class" value="active"/>
                </c:when>
            </c:choose>

            <li><a href="${pageContext.request.contextPath}/home" class="${home_class}">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/about" class="${about_class}">About</a></li>
            <li><a href="${pageContext.request.contextPath}/listings/new/form" class="${form_class}">Post Listing</a></li>
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <div class="header-right">
                        <div class="user-panel">
                            <a href="/login" class="register" role="button" data-toggle="modal" data-target="#login-modal">Log in</a>
<%--                            <a href="${pageContext.request.contextPath}/login" class="btn btn-primary btn-lg ">Sign in</a>--%>
<%--                            <a href="${pageContext.request.contextPath}/register" class="register">Join us</a>--%>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <li><a href="#">jedidiahbowo@gmail.com${sessionScope.user.email}</a>
                        <ul class="sub-menu">
                            <li><a href="#">View Profile</a></li>
                            <li><a href="#">View User Listings</a></li>
                            <li><a href="/logout">Logout</a></li>
                        </ul>
                    </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</header>
<!-- Header Section end -->



</body>

</html>
