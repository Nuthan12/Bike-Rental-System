<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
	</link>
	<link rel="icon" href="https://img.freepik.com/premium-vector/bike-sharing-rental-service-logo-icon-with-bicycle_116137-6024.jpg?w=2000" type="image/png">
</head>
<body>
	<h2 align="center">Edit Customer Details</h2>
	<form:form method="POST" action="/Bike_Rental_System/editsave" >
		<table class="table table-light table-striped">
			<tr>
				<td></td>
				<td><form:hidden path="custId" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="custName" /></td>
			</tr>
			<tr>
				<td>Mail :</td>
				<td><form:input path="custMail" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><form:input path="custPhone" /></td>
			</tr>
			<tr>
				<td>Driving License Number :</td>
				<td><form:input path="dlNumber" /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
			</tr>
			

			<tr>
				<td></td>
				<td><input type="submit" value="Save Details" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>