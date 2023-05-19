<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Page</title>
<link rel="icon" href="https://img.freepik.com/premium-vector/bike-sharing-rental-service-logo-icon-with-bicycle_116137-6024.jpg?w=2000" type="image/png">
<script type="text/javascript">
	function validateForm() {
		var age = document.getElementById("ageValidation").value;
		if (age < 18) {
			alert("Age must be at least 18");
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
}

table {
	border-collapse: collapse;
	width: 100%;
	max-width: 500px;
	margin: 0 auto;
}

td {
	padding: 10px;
	border: 1px solid #ddd;
}

form input[type="text"], form input[type="password"], form input[type="custMail"]
	{
	display: block;
	width: 90%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ddd;
}

form input[type="submit"] {
	display: block;
	margin-top: 20px;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.alert {
	padding: 10px;
	margin-bottom: 20px;
	color: #721c24;
	background-color: #f8d7da;
	border-color: #f5c6cb;
	border-radius: 4px;
}
</style>
</head>
<body>
	<h1 align="center">Register a New Customer</h1>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>
	<form:form method="post" action="save">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="custName" /></td>
			</tr>
			<tr>
				<td>Mail :</td>
				<td><form:input path="custMail" /></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><form:input path="custPhone" /></td>
			</tr>
			<tr>
				<td>DL Number :</td>
				<td><form:input path="dlNumber" /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><form:input path="age" id="ageValidation" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save"
					onclick="return validateForm()" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
