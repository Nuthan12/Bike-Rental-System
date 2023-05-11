<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Bike Details</title>

<style type="text/css">
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
}

h2 {
	color: #333;
}

button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 10px;
	cursor: pointer;
	border-radius: 5px;
}

button:hover {
	background-color: #3e8e41;
}

body {
	background-image:
		url("https://mir-s3-cdn-cf.behance.net/project_modules/1400/c20f9b101544379.5f21408a955ab.gif");
	background-repeat: no-repeat;
	background-size: cover;
}

.container {
	text-align: center;
}
</style>
</head>
<body >
	<h2 align="center">Edit Bike Details</h2>
	<div align="center">
	<form:form method="POST" action="/Bike_Rental_System/editsaveBike" >
		<table class="table table-light table-striped">
			<tr>
				<td></td>
				<td><form:hidden path="bikeId" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="bikeName" /></td>
			</tr>
			<tr>
				<td>Bike Model :</td>
				<td><form:input path="model" /></td>
			</tr>
			<tr>
				<td>Manufactured Year:</td>
				<td><form:input path="manufacturedYear" /></td>
			</tr>
			<tr>
				<td>Image :</td>
				<td><form:input path="bikeImage" type="file" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save Details" /></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>