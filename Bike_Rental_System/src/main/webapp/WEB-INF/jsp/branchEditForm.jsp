<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Branch Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</link>
</head>
<body>	
	<h2 align="center">Edit Branch Details</h2>
	<form:form method="POST" action="/Bike_Rental_System/editSaveBranch" >
		<table class="table table-light table-striped">
			<tr>
				<td></td>
				<td><form:hidden path="branchId" /></td>
			</tr>
			<tr>
				<td>Branch Name :</td>
				<td><form:input path="branchName" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="branchAddress" /></td>
			</tr>
			<tr>
				<td>Pin Code :</td>
				<td><form:input path="branchPinCode" /></td>
			</tr>
			
			

			<tr>
				<td></td>
				<td><input type="submit" value="Save Details" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>