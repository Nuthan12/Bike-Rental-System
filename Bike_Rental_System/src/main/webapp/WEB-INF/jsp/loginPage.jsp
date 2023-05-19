<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="icon" href="https://img.freepik.com/premium-vector/bike-sharing-rental-service-logo-icon-with-bicycle_116137-6024.jpg?w=2000" type="image/png">
<style type="text/css">
.login-form {
	margin: auto;
	width: 50%;
	max-width: 500px;
	border: 3px solid #f1f1f1;
	padding: 20px;
	box-sizing: border-box;
	text-align: center;
	background-color: #f9f9f9;
}

.login-form label {
	display: block;
	margin-bottom: 10px;
	text-align: center;
	font-weight: bold;
}
.login-form input[type="text"], .login-form input[type="password"] {
	
	width: 100%;
	padding: 5px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 4px
}
.login-form button[type="submit"] {
	
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	font-size: 16px;
	font-weight: bold;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
.login-form button[type="button"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	width: 100%;
	display: block; 
	margin-top: 10px;
}

.login-button {
	display: inline-block;
	padding: 10px 20px;
	font-size: 16px;
	font-weight: bold;
	text-align: center;
	text-decoration: none;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
	margin-top: 10px;
}

.login-button:hover {
	background-color: #45a049;
}

.login-button:active {
	background-color: #3e8e41;
}
</style>
</head>
<body>
<div class="login-form">
	<form method="post" action="loginPage" class="login-form">
		<label for="custMail">Mail</label> <input type="text" id="username"
			name="custMail" required> <br> <label for="password">Password</label>
		<input type="password" id="password" name="password" required>
		<br> <input type="submit" value="Login" class="login-button">
	</form>
	<c:if test="${not empty error}">
			<p style="color: blue">${error}</p>
		</c:if>
	</div>
	
</body>
</html>

