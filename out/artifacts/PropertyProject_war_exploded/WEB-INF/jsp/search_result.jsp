<%--
  Created by IntelliJ IDEA.
  User: jedidiahbowo
  Date: 4/19/20
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
<section class="page-top-section set-bg" data-setbg="${pageContext.request.contextPath}/resource/img/page-top-bg.jpg">
    <div class="page-top-warp">
        <form class="main-search-form">
            <div class="search-type">
                <div class="st-item">
                    <input type="radio" name="st" id="buy" checked>
                    <label for="buy">Buy</label>
                </div>
                <div class="st-item">
                    <input type="radio" name="st" id="rent">
                    <label for="rent">Rent</label>
                </div>
                <div class="st-item">
                    <input type="radio" name="st" id="sell">
                    <label for="sell">Sell</label>
                </div>
                <div class="st-item">
                    <input type="radio" name="st" id="property">
                    <label for="property">Property Value</label>
                </div>
                <div class="st-item">
                    <input type="radio" name="st" id="agents">
                    <label for="agents">Agents</label>
                </div>
            </div>
            <div class="search-input si-v-2">
                <input type="text" placeholder="Search by state, postcode or suburb">
                <button class="site-btn" type="submit">Search</button>
                <button class="site-btn sb-light">Show Filters</button>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. </p>
        </form>
    </div>
</section>
<!-- Page top Section end -->

<!-- Search Result Section end -->
<section class="search-result-section ">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xl-6 p-0">
                <div class="search-result-map">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d14376.077865872314!2d-73.879277264103!3d40.757667781624285!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sbd!4v1546528920522" style="border:0" allowfullscreen></iframe>
                </div>
            </div>
            <div class="col-xl-6 p-0">
                <div class="search-results">
                    <ul class="filter-btn">
                        <li class="active">Newest</li>
                        <li>Price Low </li>
                        <li>Price High</li>
                    </ul>
                    <div class="row">
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
                                    <a href="#" class="readmore-btn">Find out more</a>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <button class="site-btn sb-big load-more">load More</button>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Search Result Section end -->

<!-- Footer Section -->
<footer class="footer-section">
    <div class="container">
        <div class="row text-white">
            <div class="col-lg-4">
                <div class="footer-widger">
                    <div class="about-widget">
                        <div class="aw-text">
                            <img src="${pageContext.request.contextPath}/resource/img/footer-logo.png" alt="">
                            <p>Donec eget efficitur ex. Donec eget dolor vitae eros feugiat tristique id vitae massa. Proin vulputate cong ue rutrum. Fusce lobortis a enim eget tempus. </p>
                            <a href="#" class="site-btn">we are hiring</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <div class="footer-widger">
                    <h2>Company</h2>
                    <ul>
                        <li><a href="#">About us</a></li>
                        <li><a href="#">Services</a></li>
                        <li><a href="#">Clients</a></li>
                        <li><a href="#">Testimonials</a></li>
                        <li><a href="#">Carrers</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <div class="footer-widger">
                    <h2>For Buyers</h2>
                    <ul>
                        <li><a href="#">Buy with us</a></li>
                        <li><a href="#">Papers</a></li>
                        <li><a href="#">Clients</a></li>
                        <li><a href="#">Testimonials</a></li>
                        <li><a href="#">Homes</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <div class="footer-widger">
                    <h2>For Sellers</h2>
                    <ul>
                        <li><a href="#">Seel With us</a></li>
                        <li><a href="#">What do You Need</a></li>
                        <li><a href="#">Clients</a></li>
                        <li><a href="#">Testimonials</a></li>
                        <li><a href="#">Guideline</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2 col-md-3 col-sm-6">
                <div class="footer-widger">
                    <h2>For Renters</h2>
                    <ul>
                        <li><a href="#">Rent with us</a></li>
                        <li><a href="#">Guidelines</a></li>
                        <li><a href="#">Apartments</a></li>
                        <li><a href="#">Flats</a></li>
                        <li><a href="#">Houses</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="copyright"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
    </div>
</footer>
<!-- Footer Section end -->

<!--====== Javascripts & Jquery ======-->
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/jquery.slicknav.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/main.js"></script>

</body>
</html>