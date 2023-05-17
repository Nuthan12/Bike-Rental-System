<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking History</title>
<style>
/* CSS styles */
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	padding: 20px;
}

h1 {
	color: #333;
}

table {
	border-collapse: collapse;
	width: 100%;
	margin-bottom: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

button {
	padding: 6px 12px;
	font-size: 14px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}

a {
	color: #337ab7;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<h1 align="center">Booking History</h1>

	<table border="1">
		<tr>
			<th>Booking ID</th>
			<th>Customer ID</th>
			<th>Bike ID</th>
			<th>Booked Time</th>
			
		</tr>
		<c:forEach var="booking" items="${bookingHistoryAdmin}">
			<tr>
				<td>${booking.bookingId}</td>
				<td>${booking.custId}</td>
				<td>${booking.bikeId}</td>
				<td>${booking.bookedTime}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>