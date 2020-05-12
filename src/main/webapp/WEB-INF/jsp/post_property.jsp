<%--
  Created by IntelliJ IDEA.
  User: jedidiahbowo
  Date: 4/19/20
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resource/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/img/favicon.png" />
    <title>Post Free Property Ads | Propertee</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- CSS Files -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resource/css/paper-bootstrap-wizard.css" rel="stylesheet" />


    <!-- Fonts and Icons -->
    <link href="${pageContext.request.contextPath}/resource/css/font-awesome.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/resource/css/themify-icons.css" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"/>

</head>

<body>

<div class="image-container set-full-height" style="background-image: url('${pageContext.request.contextPath}/resource/img/paper-2.jpeg')">


    <!-- Header Section -->
    <%@include file="header.jsp"%>
    <!-- Header Section end -->


    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">

                <!--      Wizard container        -->
                <div class="wizard-container">
                    <div class="card wizard-card" data-color="red" id="wizard">
                        <form action="${pageContext.request.contextPath}/listings/new" method="POST" id="property_form">
                            <!--        You can switch " data-color="green" "  with one of the next bright colors: "blue", "azure", "orange", "red"       -->

                            <div class="wizard-header">
                                <h3 class="wizard-title">List your place</h3>
                                <p class="category">This information will let us know more about your place.</p>
                            </div>
                            <div class="wizard-navigation">
                                <div class="progress-with-circle">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="4" style="width: 15%;"></div>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#type" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-direction-alt"></i>
                                            </div>
                                            Listing type
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#location" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-map"></i>
                                            </div>
                                            Location
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#facilities" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-panel"></i>
                                            </div>
                                            Property Details
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#description" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-comments"></i>
                                            </div>
                                            Contact Info
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane" id="location">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h5 class="info-text"> Please provide location details</h5>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Street</label><br>
                                                <input type="text" class="form-control" name="street" placeholder="123 Streetname Ave" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 ">
                                            <div class="form-group">
                                                <label>City</label>
                                                <input type="text" class="form-control"  name="city" id="exampleInputEmail1" placeholder="Los Angeles" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>State</label>
                                                <select name="state" form="property_form" required class="form-control">
                                                    <option disabled="" selected="">- State -</option>
                                                    <option value="AL">Alabama</option>
                                                    <option value="AK">Alaska</option>
                                                    <option value="AZ">Arizona</option>
                                                    <option value="AR">Arkansas</option>
                                                    <option value="CA">California</option>
                                                    <option value="CO">Colorado</option>
                                                    <option value="CT">Connecticut</option>
                                                    <option value="DE">Delaware</option>
                                                    <option value="DC">District Of Columbia</option>
                                                    <option value="FL">Florida</option>
                                                    <option value="GA">Georgia</option>
                                                    <option value="HI">Hawaii</option>
                                                    <option value="ID">Idaho</option>
                                                    <option value="IL">Illinois</option>
                                                    <option value="IN">Indiana</option>
                                                    <option value="IA">Iowa</option>
                                                    <option value="KS">Kansas</option>
                                                    <option value="KY">Kentucky</option>
                                                    <option value="LA">Louisiana</option>
                                                    <option value="ME">Maine</option>
                                                    <option value="MD">Maryland</option>
                                                    <option value="MA">Massachusetts</option>
                                                    <option value="MI">Michigan</option>
                                                    <option value="MN">Minnesota</option>
                                                    <option value="MS">Mississippi</option>
                                                    <option value="MO">Missouri</option>
                                                    <option value="MT">Montana</option>
                                                    <option value="NE">Nebraska</option>
                                                    <option value="NV">Nevada</option>
                                                    <option value="NH">New Hampshire</option>
                                                    <option value="NJ">New Jersey</option>
                                                    <option value="NM">New Mexico</option>
                                                    <option value="NY">New York</option>
                                                    <option value="NC">North Carolina</option>
                                                    <option value="ND">North Dakota</option>
                                                    <option value="OH">Ohio</option>
                                                    <option value="OK">Oklahoma</option>
                                                    <option value="OR">Oregon</option>
                                                    <option value="PA">Pennsylvania</option>
                                                    <option value="RI">Rhode Island</option>
                                                    <option value="SC">South Carolina</option>
                                                    <option value="SD">South Dakota</option>
                                                    <option value="TN">Tennessee</option>
                                                    <option value="TX">Texas</option>
                                                    <option value="UT">Utah</option>
                                                    <option value="VT">Vermont</option>
                                                    <option value="VA">Virginia</option>
                                                    <option value="WA">Washington</option>
                                                    <option value="WV">West Virginia</option>
                                                    <option value="WI">Wisconsin</option>
                                                    <option value="WY">Wyoming</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>Zipcode</label>
                                                <input type="text" pattern="\d{5}" required name="zipcode" class="form-control" placeholder="90210">
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Price (rent per month or sell price)</label>
                                                <div class="input-group">
                                                    <input type="number" min="0.00" step="0.01" required name="price" class="form-control" placeholder="300.00">
                                                    <span class="input-group-addon">$</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>Extra charges (utility / security deposit)</label>
                                                <div class="input-group">
                                                    <input type="number" min="0.00" step="0.01" required name="extra_charges" class="form-control" placeholder="300.00">
                                                    <span class="input-group-addon">$</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="type">
                                    <h5 class="info-text">What type of location do you have? </h5>
                                    <div class="row">
                                        <div class="col-sm-8 col-sm-offset-2">
                                            <div class="col-sm-4 col-sm-offset-2">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="property_type" value="house" required>
                                                    <div class="card card-checkboxes card-hover-effect">
                                                        <i class="ti-home"></i>
                                                        <p>Home</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="property_type" value="apartment" required>
                                                    <div class="card card-checkboxes card-hover-effect">
                                                        <i class="ti-package"></i>
                                                        <p>Apartment</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Who are you</label>
                                                <select name="user_type" form="property_form" class="form-control" required>
                                                    <option disabled="" selected="">- type -</option>
                                                    <option value="owner">Owner</option>
                                                    <option value="dealer">Dealer </option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>What are you listing this for ?</label>
                                                <select name="list_for" form="property_form" class="form-control" required>
                                                    <option disabled="" selected="">- response -</option>
                                                    <option value="sell">Sell</option>
                                                    <option value="rent">Rent</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>What kind of house? If applicable</label>
                                                <select name="house_sybtype" form="property_form" class="form-control">
                                                    <option disabled="" selected="">- response -</option>
                                                    <option value="independent">Independent</option>
                                                    <option value="farm">Farm</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>What kind of appartment? If applicable</label>
                                                <select name="apartment_subtype" form="property_form" class="form-control">
                                                    <option disabled="" selected="">- response -</option>
                                                    <option value="residential">Residential</option>
                                                    <option value="independent">Independent</option>
                                                    <option value="studio">Studio</option>
                                                    <option value="serviced">Serviced</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Project Name</label>
                                                <textarea class="form-control" name="project_name" form="property_form" required placeholder="4 bedroom 3 bathroom apartment by beach" rows="2" maxlength="50" ></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="facilities">
                                    <h5 class="info-text">Tell us more about facilities. </h5>
                                    <div class="row">
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Area</label>
                                                <div class="input-group">
                                                    <input type="number" min="0.00" required name="area" class="form-control" placeholder="1100">
                                                    <span class="input-group-addon">sq.ft</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>How many bedroom?</label>
                                                <div class="input-group">
                                                    <input type="number" min="0" step="1" required name="bedroom_num" class="form-control" placeholder="2">
                                                    <span class="input-group-addon">Bedroom</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>How many bathroom?</label>
                                                <div class="input-group">
                                                    <input type="number" min="0" step="1" name="bathroom_num" class="form-control" placeholder="1" required>
                                                    <span class="input-group-addon">Bathroom</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Is there balcony?</label>
                                                <div class="input-group">
                                                    <input type="number" min="0" step="1" name="balconies" class="form-control" required>
                                                    <span class="input-group-addon">Balconies</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>Total number of floor?</label>
                                                <input type="number" min="0" step="1" name="total_floor" class="form-control" required >
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Is the property furnished?</label>
                                                <select name="furnishing" form="property_form" class="form-control" required>
                                                    <option disabled="" selected="">- response -</option>
                                                    <option value="unfurnished">Unfurnished</option>
                                                    <option value="semifurnished">Semi-furnished</option>
                                                    <option value="furnished">Full-furnished</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>Is there parking space?</label>
                                                <select name="parking" form="property_form" class="form-control" required>
                                                    <option disabled="" selected="">- response -</option>
                                                    <option value="true">Yes</option>
                                                    <option value="false">No</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>When is it available from</label>
                                                <input type="date" class="form-control" name="available_from" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>How old is the property?</label>
                                                <div class="input-group">
                                                    <input type="number" min="0" step="1" name="age" class="form-control" required>
                                                    <span class="input-group-addon">years</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Property Description</label>
                                                <textarea class="form-control" name="description" form="property_form" required placeholder="" rows="2" maxlength="50" ></textarea>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>Upload the property image</label>
                                                <div class="input-group">
                                                    <input type="file" name="file" accept="image/jpeg"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="description">
                                    <div class="row">
                                        <h5 class="info-text"> Drop us your information. </h5>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Email</label><br>
                                                <input type="email" class="form-control" name="email" placeholder="email@domain.com" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 ">
                                            <div class="form-group">
                                                <label>Phone number</label>
                                                <input type="text" pattern="\d{10}" class="form-control" name="phonenumber" placeholder="995-123-4434" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>Name</label><br>
                                                <input type="text" class="form-control" name="name" placeholder="John Doe" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 ">
                                            <div class="form-group">
                                                <label>About the lister</label>
                                                <textarea class="form-control" name="about" form="property_form" placeholder="" rows="2" maxlength="50" ></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="wizard-footer">
                                <div class="pull-right">
                                    <input type='button' class='btn btn-next btn-fill btn-danger btn-wd' name='next' value='Next' />
                                    <input type="submit" form="property_form" class='btn btn-finish btn-fill btn-danger btn-wd' name='finish' value='Finish' />
                                </div>

                                <div class="pull-left">
                                    <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='Previous' />
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div> <!-- row -->
    </div> <!--  big container -->


</body>

<!--   Core JS Files   -->
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap-wizard/1.2/jquery.bootstrap.wizard.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/SlickNav/1.0.10/jquery.slicknav.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>


<!--  Plugin for the Wizard -->
<script src="${pageContext.request.contextPath}/resource/js/demo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/paper-bootstrap-wizard.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/main.js"></script>


<!--  More information about jquery.validate here: https://jqueryvalidation.org/	 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js" type="text/javascript"></script>


</html>
