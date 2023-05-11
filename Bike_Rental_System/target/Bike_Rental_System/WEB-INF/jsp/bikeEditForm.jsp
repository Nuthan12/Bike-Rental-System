<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Edit Bike Details</h2>

	<form:form method="POST" action="/Bike_Rental_System/editsaveBike">
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
</body>
</html>