<%--
  Created by IntelliJ IDEA.
  User: jedidiahbowo
  Date: 4/21/20
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Search Property For Free | Propertee</title>
    <meta charset="UTF-8">
    <meta name="description" content="Real estate HTML Template">
    <meta name="keywords" content="real estate, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/resource/img/favicon.ico" rel="shortcut icon"/>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i,900%7cRoboto:400,400i,500,500i,700,700i&display=swap" rel="stylesheet">


    <!-- Stylesheets -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/magnific-popup.css"/>

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
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Header Section -->
<%@include file="header.jsp"%>
<!-- Header Section end -->

<!-- Page top Section end -->
<%@include file="search_bar.jsp"%>
<!-- Page top Section end -->

<!-- Single Property Section end -->
<c:set var="user" value="${sessionScope.user}"/>
<section class="search-result-section ">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="col-lg-4 text-left text-lg-right">
                    <div class="property-header">
                        <h3>$${listing.price}</h3>
                        <p>${user.name}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-6 p-0">
                <div class="search-results">
                    <div class="row">
                        <c:choose>
                            <c:when test="${isempty}">
                                <h3>Sorry. No listing found with those criteria. Please modify your search or try again later.</h3>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="l" items="${listings}">
                                    <div class="col-md-6">
                                        <div class="property-item">
                                            <div class="pi-image">
                                                <img src="${pageContext.request.contextPath}/resource/img/property-search/1.jpg" alt="">
                                                <div class="pi-badge new">New</div>
                                            </div>
                                            <h3>${l.description}</h3>
                                            <h5><fmt:formatNumber type="currency" currencyCode="USD" value="${l.price}"/></h5>
                                            <div class="pi-metas">
                                                <div class="pi-meta">${l.area} sq ft</div>
                                                <div class="pi-meta">${l.city}</div>
                                            </div>
                                            <a href="${pageContext.request.contextPath}/get/listing.do?listing_id=${l.listing_id}" class="readmore-btn">Listing Details</a>
                                            <a href="#" class="readmore-btn">Delete Listing</a>
                                        </div>
                                    </div>
                                </c:forEach>
                                <button class="site-btn sb-big load-more">load More</button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section><!--  Section end -->

<!-- Footer Section -->
<%@include file="footer.jsp"%>
<!-- Footer Section end -->

<!--====== Javascripts & Jquery ======-->
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/jquery.slicknav.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/main.js"></script>

</body>
</html>

