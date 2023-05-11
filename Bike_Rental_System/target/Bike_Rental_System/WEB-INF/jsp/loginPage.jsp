<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
    /* CSS for centering the login form */
    .login-form {
        margin: auto;
        width: 50%;
        border: 3px solid #f1f1f1;
        padding: 10px;
    }
    /* CSS for styling the form fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 8px 16px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    /* CSS for styling the login button */
    button[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 8px 16px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }
    /* CSS for styling the cancel button */
    button[type=button] {
        background-color: #f44336;
        color: white;
        padding: 8px 16px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }
</style>
</head>
<body>
 <%--   <form method="post" action="LoginServlet">
  <label for="username">Customer Mail:</label>
  <input type="text" id="username" name="custMail" required>
  <br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required>
  <br>
  <input type="submit" value="Login">
</form> --%>

<button onclick="window.location.href='adminHome'">Admin</button>
<button onclick="window.location.href='customerHome'">Customer</button>

</body>
</html>
