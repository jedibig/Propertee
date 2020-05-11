<%--
  Created by IntelliJ IDEA.
  User: jedidiahbowo
  Date: 5/3/20
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/register" method="POST">
    <div class="container">
        <h1>Register</h1>
        <p style="color: orangered">${error}</p>

        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="email"><b>Email</b></label>
        <input type="email" placeholder="johndoe@aol.com" name="email" required>

        <label for="name"><b>Name</b></label>
        <input type="text" placeholder="Jonh Doe" name="name" required>

        <label for="phoneNumber"><b>Phone Number</b></label>
        <input type="text" pattern="\d{10}" placeholder="1234567890" name="phoneNumber" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
        <hr>

        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
        <input type="submit" class="registerbtn">Register</input>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login-form">Sign in</a>.</p>
    </div>
</form>
</body>
</html>
