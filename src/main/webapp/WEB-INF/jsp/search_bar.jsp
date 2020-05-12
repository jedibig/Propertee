<%@ page import="java.time.LocalDate" %><%--
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
            <form action="${pageContext.request.contextPath}/listings" class="main-search-form" id="propertee_search_form">
                <div class="search-type">
                    <div class="st-item">
                        <input type="radio" name="list_for" id="buy" value="SELL" checked>
                        <label for="buy">Buy</label>
                    </div>
                    <div class="st-item">
                        <input type="radio" name="list_for" value="Rent" id="RENT">
                        <label for="rent">Rent</label>
                    </div>
                </div>
                <div class="search-input si-v-2">
                    <input type="text" name="keyword" id="keyword" placeholder="Search by state, zipcode or city" required/>
                    <button type="submit" class="site-btn" form="propertee_search_form">Search</button>
                    <button class="site-btn sb-light">Show Filters</button>
                </div>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. </p>
            </form>
        </div>
        <div class="row" id="filters" style="background-color: white">
            <div class="col-lg-12 filter-form">
                    <div class="first-row">
                        <label>Construction Type</label>
                        <select name="property_type" form="propertee_search_form">
                            <option selected value="">Any</option>
                            <option value="HOUSE">House</option>
                            <option value="APARTMENT">Apartment</option>
                        </select>
                        <label>Posted since
                            <select name="postedBy" form="propertee_search_form">
                                <option selected value="">Anytime</option>
                                <option value="<%=LocalDate.now().minusWeeks(1l)%>">past week</option>
                                <option value="<%=LocalDate.now().minusMonths(1l)%>">past month</option>
                                <option value="<%=LocalDate.now().minusYears(1l)%>">past Year</option>
                            </select>
                        </label>
                        <label>
                            Price $<input type="number" name="minBudget" form="propertee_search_form" placeholder="0">
                        </label>-
                        <label>
                            $<input type="number" name="maxBudget" form="propertee_search_form" placeholder="10000">
                        </label>
                        <label for="bedroom_num">Bedroom</label>
                        <select id="bedroom_num" name="num_bedroom" form="propertee_search_form">
                            <option selected value="">Any</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6+</option>
                        </select>
                    </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
