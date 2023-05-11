<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<body>
		<h2 align="center">Book A Bike</h2>
	<div align="center">
	<form:form method="POST" action="/Bike_Rental_System/bookBike" >
		<table class="table table-light table-striped">
			<tr>
				<td></td>
				<td><form:hidden path="bikeId" /></td>
			</tr>

		
		<c:forEach var="c" items="${list}">
			<tr>
				<td>Bike Name : ${c.bikeId}</td>
				<td>Bike Model :${c.bikeName}</td>
				<td>Model :${c.model}</td>
				<td>Manufactured Year :${c.manufacturedYear}</td>
				<td>Image :<img width="25" height="30" src="data:image/png;base64,${c.bikeImage}"></td>
				<td>Branch Name :${c.branchName}</td>
				<td>Branch Address:${c.branchAddress}</td>
				<td>Pin Code :${c.branchPinCode}</td>
			
			</tr>
		</c:forEach>
	</table>
			<tr>
				<td>Number Of Days :</td>
				<td><form:input path="noOfDays"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save Details" /></td>
			</tr>
		
	</form:form>
	</div>
</body>
</html>