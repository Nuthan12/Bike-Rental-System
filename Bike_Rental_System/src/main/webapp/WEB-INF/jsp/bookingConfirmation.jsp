<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Confirmation</title>
<link rel="icon" href="https://img.freepik.com/premium-vector/bike-sharing-rental-service-logo-icon-with-bicycle_116137-6024.jpg?w=2000" type="image/png">
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-color: #f9f9f9;
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

#logout {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	font-size: 16px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top: 20px;
}

#logout:hover {
	background-color: #45a049;
}

#logout:active {
	background-color: #3e8e41;
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
	
	<button id="logout" onclick="window.location.href='/Bike_Rental_System/customerHome'">Home</button>

	<!-- <p><a href="viewBikesCustomer">Back to Bikes List</a></p> -->
</body>
</html>
