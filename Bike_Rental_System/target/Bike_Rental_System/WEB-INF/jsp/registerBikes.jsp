<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register A New Bike</title>
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
	width: 100%;
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
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>
	
	<form:form method="post" action="saveBike">
		<table>
			<tr>
				<td>Bike Name :</td>
				<td><form:input path="bikeName" /></td>
			</tr>
			<tr>
				<td>Bike Model :</td>
				<td><form:input path="model" /></td>
			</tr>
			<tr>
				<td>Manufactured Year :</td>
				<td><form:input path="manufacturedYear" /></td>
			</tr>
			<tr>
				<td>Image :</td>
				<td><form:input path="bikeImage" type="file"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Save"
					onclick="return " /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>