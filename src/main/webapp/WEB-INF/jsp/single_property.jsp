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
<section class="single-property-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="single-property">
                    <div class="sp-image">
                        <img src="${pageContext.request.contextPath}/resource/img/property/big.jpg" alt="">
                        <div class="sp-badge new">New</div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="property-header">
                                <h3>${listing.address.street}</h3>
                                <h5>${listing.address.city}, ${listing.address.state} ${listing.address.zipcode} </h5>
                            </div>
                        </div>
                        <div class="col-lg-4 text-left text-lg-right">
                            <div class="property-header">
                                <h3>$${listing.price}</h3>
                                <p>${listing.project_name}</p>
                            </div>
                        </div>
                    </div>
                    <div class="property-info-bar">
                        <div class="row">
                            <div class="col-lg-7">
                                <div class="pi-metas">
                                    <div class="pi-meta">${listing.details.bedroom_num} Bed </div>
                                    <div class="pi-meta">${listing.details.bathroom_num} Baths</div>
                                    <div class="pi-meta">${listing.details.balconies} Balcony</div>
                                    <div class="pi-meta">${listing.area} Sq.ft</div>
                                </div>
                            </div>
                            <div class="col-lg-5 text-left text-lg-right">
                                <a href="#" class="offer-btn">Make an Offer</a>
                            </div>
                        </div>
                    </div>
                    <div class="property-text">
                        <h4>Description</h4>
                        <p>${listing.details.description}</p>
                    </div>
                    <div class="property-feature">
                        <div class="row">
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>Property Type</h6>
                                    <p>
                                    <c:choose>
                                        <c:when test="${listing.property_type.toString().equals('HOME')}">
                                            ${listing.house_subtype}
                                        </c:when>
                                        <c:when test="${listing.property_type.toString().equals('APARTMENT')}">
                                            ${listing.apartment_subtype}
                                        </c:when>
                                    </c:choose>
                                        ${listing.property_type}</p>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>Stories</h6>
                                    <p>3</p>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>Building Age</h6>
                                    <p>${listing.details.age}</p>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>A/C</h6>
                                    <p>Central</p>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>Heating</h6>
                                    <p>Forced Air</p>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>Bathrooms</h6>
                                    <p>${listing.details.bathroom_num}</p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>Pool</h6>
                                    <p>Yes</p>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>Fireplace</h6>
                                    <p>No</p>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 col-md-3 col-lg-3">
                                <div class="pf-box">
                                    <h6>Parking Spaces</h6>
                                    <p>
                                        <c:if test="${parking}">
                                            Yes
                                        </c:if>
                                        <c:if test="${!parking}">
                                            No
                                        </c:if>
                                    </p>
                                </div>
                            </div>
                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">
                                <div class="pf-box">
                                    <h6>Parking Type</h6>
                                    <p>Garage</p>
                                </div>
                            </div>
                        </div>
<%--                        <div class="row">--%>
<%--                            <div class="col-6 col-sm-4 col-md-3 col-lg-2">--%>
<%--                                <div class="pf-box">--%>
<%--                                    <h6>Patio</h6>--%>
<%--                                    <p>128 SQ</p>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="col-6 col-lg-3">--%>
<%--                                <div class="pf-box">--%>
<%--                                    <h6>Playgroung</h6>--%>
<%--                                    <p>No</p>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                </div>
                <div class="video-item">
                    <img src="../../resource/img/video-img.jpg" alt="">
                    <a href="https://www.youtube.com/watch?v=Sz_1tkcU0Co" class="video-play"><span class="i fa fa-play"></span></a>
                </div>
                <div class="loan-calculator">
                    <h4>Loan Calculator</h4>
                    <div class="row">
                        <div class="col-md-4">
                            <input type="text" placeholder="Purchase Price" id="lc-price">
                        </div>
                        <div class="col-md-4">
                            <input type="text" placeholder="Interest Rate" id="lc-interest">
                        </div>
                        <div class="col-md-4">
                            <input type="text" placeholder="Down Payment" id="lc-dpay">
                        </div>
                        <div class="col-md-12">
                            <div class="loan-cal-result">Weekly Payments: <span id="lc-result">$0.00</span></div>
                            <div class="text-left text-sm-right">
                                <button class="site-btn sb-big" id="lc-submit">Apply for pre-Qualification</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-8 sidebar">
                <div class="agent-widget">
                    <img src="../../resource/img/agents/1.jpg" alt="">
                    <div class="aw-text">
                        <h4>${listing.user.name}</h4>
                        <h6>${listing.user.email}</h6>
                        <h6>${listing.user_type}</h6>
                        <a href="#" class="readmore-btn">Contact the agent</a>
                    </div>
                </div>
                <div class="map-widget">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d14376.077865872314!2d-73.879277264103!3d40.757667781624285!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sbd!4v1546528920522" style="border:0" allowfullscreen></iframe>
                </div>
            </div>
        </div>
    </div>
</section>
<!--  Section end -->

<!-- Footer Section -->
<footer class="footer-section">
    <div class="container">
        <div class="row text-white">
            <div class="col-lg-4">
                <div class="footer-widger">
                    <div class="about-widget">
                        <div class="aw-text">
                            <img src="../../resource/img/footer-logo.png" alt="">
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

