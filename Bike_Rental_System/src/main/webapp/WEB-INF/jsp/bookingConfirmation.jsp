<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Confirmation</title>

<style>
body {
	font-family: Arial, sans-serif;
}

h1 {
	color: #333;
}

ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

li {
	margin-bottom: 10px;
}

strong {
	font-weight: bold;
}
body{
	text-align:center;
}
</style>
</head>
<body>
	<h1>Booking Confirmation</h1>

	<p>Thank you for your booking!</p>

	<h3>Booking Details</h3>
	<ul>
		<li><strong>Booking ID:</strong> <c:out value="${bookingId}" /></li>

		<li><strong>Booked Time:</strong> <c:out value="${bookedTime}" /></li>
	</ul>
	
	 <button id="logout" onclick="window.location.href='/customerHome'">Logout</button>

	<!-- <p><a href="viewBikesCustomer">Back to Bikes List</a></p> -->
</body>
</html>
