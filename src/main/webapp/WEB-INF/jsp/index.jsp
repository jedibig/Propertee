<%--
  Created by IntelliJ IDEA.
  User: jedidiahbowo
  Date: 4/19/20
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Property For Free | Propertee</title>
    <meta charset="UTF-8">
    <meta name="description" content="Real estate HTML Template">
    <meta name="keywords" content="real estate, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link href="${pageContext.request.contextPath}/resource/img/favicon.png" rel="shortcut icon"/>

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

<h2 style="color: orangered">${error}</h2>
<h2 style="color: greenyellow">${info}</h2>


<!-- Hero Section -->
<%@include file="search_bar.jsp"%>
<!-- Hero Section end -->

<!-- Intro Section end -->
<section class="intro-section spad">
    <div class="container">
        <div class="section-title">
            <h2>Sell Faster. Save Thousands.</h2>
        </div>
        <div class="row intro-first">
            <div class="col-lg-6 order-lg-2">
                <img src="${pageContext.request.contextPath}/resource/img/about/1.jpg" alt="">
            </div>
            <div class="col-lg-6 order-lg-1">
                <div class="about-text">
                    <h3>We charge 2% total. No hidden fees or upfront costs.</h3>
                    <p>Donec eget efficitur ex. Donec eget dolor vitae eros feugiat tristique id vitae massa. Proin vulputate congue rutrum. Fusce lobortis a enim eget tempus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse potenti. Ut gravida mattis magna, non varius lorem sodales nec. In libero orci, ornare non nisl a, auctor euismod purus. Morbi pretium interdum vestibulum. Fusce nec eleifend ipsum. Sed non blandit tellus.</p>
                    <a href="#" class="readmore-btn">Find out more</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <img src="${pageContext.request.contextPath}/resource/img/about/2.jpg" alt="">
            </div>
            <div class="col-lg-6 ">
                <div class="about-text">
                    <h3>How Much Can You Save? We work for you, not commission.</h3>
                    <p>Donec eget efficitur ex. Donec eget dolor vitae eros feugiat tristique id vitae massa. Proin vulputate congue rutrum. Fusce lobortis a enim eget tempus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse potenti. Ut gravida mattis magna, non varius lorem sodales nec. In libero orci, ornare non nisl a, auctor euismod purus. Morbi pretium interdum vestibulum. Fusce nec eleifend ipsum. Sed non blandit tellus.</p>
                    <a href="#" class="readmore-btn">Find out more</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Intro Section end -->

<!-- Property Section -->
<section class="property-section">
    <div class="container">
        <div class="section-title">
            <h2>Recently Add Homes</h2>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="${pageContext.request.contextPath}/resource/img/property/1.jpg" alt="">
                        <div class="pi-badge new">New</div>
                    </div>
                    <h3>$469,000</h3>
                    <h5>3 Bedrooms Townhouse</h5>
                    <p>Donec eget efficitur ex. Donec eget dolor vitae eros feugiat tristique id vitae massa. Proin vulputate congue rutrum. Fusce lobortis a enim eget tempus. Class aptent taciti sociosqu ad litora.</p>
                    <a href="#" class="readmore-btn">Find out more</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="${pageContext.request.contextPath}/resource/img/property/2.jpg" alt="">
                        <div class="pi-badge offer">Offer</div>
                    </div>
                    <h3>$369,000</h3>
                    <h5>3 Bedrooms Townhouse</h5>
                    <p>Donec eget efficitur ex. Donec eget dolor vitae eros feugiat tristique id vitae massa. Proin vulputate congue rutrum. Fusce lobortis a enim eget tempus. Class aptent taciti sociosqu ad litora.</p>
                    <a href="#" class="readmore-btn">Find out more</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="property-item">
                    <div class="pi-image">
                        <img src="${pageContext.request.contextPath}/resource/img/property/3.jpg" alt="">
                        <div class="pi-badge new">New</div>
                    </div>
                    <h3>$560,000</h3>
                    <h5>3 Bedrooms Townhouse</h5>
                    <p>Donec eget efficitur ex. Donec eget dolor vitae eros feugiat tristique id vitae massa. Proin vulputate congue rutrum. Fusce lobortis a enim eget tempus. Class aptent taciti sociosqu ad litora.</p>
                    <a href="#" class="readmore-btn">Find out more</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Property Section end -->

<!-- Loan Section end -->
<section class="loan-section">
    <div class="loan-warp">
        <div class="container">
            <div class="section-title text-white">
                <h2>See If You Qualify for a Mortgage</h2>
                <p>Donec eget efficitur ex. Donec eget dolor vitae eros feugiat tristique id vitae massa. Proin vulputate congue rutrum. Fusce lobortis a enim eget tempus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse potenti. Ut gravida mattis magna, non varius lorem sodales nec. In libero orci, ornare non nisl a, auctor euismod purus. Morbi pretium interdum vestibulum. Fusce nec eleifend ipsum. Sed non blandit tellus. </p>
            </div>
            <form class="loan-form">
                <input type="text" placeholder="Your income">
                <input type="text" placeholder="Amount needed">
                <button class="site-btn">Submit</button>
            </form>
        </div>
    </div>
</section>
<!-- Loan Section end -->

<!-- Stories Section end -->
<section class="stories-section spad">
    <div class="container">
        <div class="row ">
            <div class="col-lg-5 order-lg-2">
                <img class="w-100" src="${pageContext.request.contextPath}/resource/img/about/3.jpg" alt="">
            </div>
            <div class="col-lg-7 order-lg-1">
                <div class="about-text">
                    <h2>Seller Success Stories</h2>
                    <p>Fusce lobortis a enim eget tempus. Class aptent taciti sociosqu ad litora. Donec eget efficitur ex. Donec eget dolor vitae eros feugiat tristique id vitae massa. Proin vulputate congue rutrum. Fusce lobortis a enim eget tempus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse potenti. Ut gravida mattis magna, non varius lorem sodales nec. In libero orci, ornare non nisl a, auctor euismod purus. Morbi pretium interdum vestibulum. Fusce nec eleifend ipsum. Sed non blandit tellus. </p>
                    <a href="#" class="readmore-btn">Find out more</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Stories Section end -->

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
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js">
<script src="https://twitter.github.io/typeahead.js/releases/latest/typeahead.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/main.js"></script>
<script>
    var states = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.whitespace,
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        // `states` is an array of state names defined in "The Basics"
        remote: {
            url: 'http://localhost:9200/autocomplete/_search?q=key:%QUERY',
            wildcard: '%QUERY',
            filter: function (data) {
                // Map the remote source JSON array to a JavaScript object array
                return data.hits.hits.map(i => i._source.key)
            }
        }
    });

    $('#keyword').typeahead({
            hint: true,
            highlight: true,
            minLength: 1
        },
        {
            name: 'states',
            source: states
        });
</script>


</body>
</html>
