<%--
  Created by IntelliJ IDEA.
  User: jedidiahbowo
  Date: 5/3/20
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<h1>Login</h1>
<p style="color: orangered">${error}</p>
<form name='f' action="${pageContext.request.contextPath}/user/login" method='POST'>
    <table>
        <tr>
            <td>Email:</td>
            <td><input type='text' name='email' required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' required /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>

    <div class="container signin">
        <p>Don't have an account? <a href="${pageContext.request.contextPath}/register-form">Sign up</a>.</p>
    </div>
</form>
</body>
</html>
