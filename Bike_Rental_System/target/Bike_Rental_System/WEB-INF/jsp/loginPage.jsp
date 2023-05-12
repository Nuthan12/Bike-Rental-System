<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
/* CSS for centering the login form */
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
/* CSS for styling the form fields */
.login-form input[type="text"], .login-form input[type="password"] {
	/* width: 100%;
	padding: 8px 16px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box */
	width: 100%;
	padding: 5px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 4px
}
/* CSS for styling the login button */
.login-form button[type="submit"] {
	/* background-color: #4CAF50;
	color: white;
	padding: 8px 16px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%; */
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	font-size: 16px;
	font-weight: bold;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
/* CSS for styling the cancel button */
.login-form button[type="button"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	width: 100%;
	display: block; /* Added line */
	margin-top: 10px; /* Added line */
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
	</div>
	
</body>
</html>

