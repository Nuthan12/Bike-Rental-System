<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
		url("https://media.giphy.com/media/26uf2I4Vlv2ttNvZm/giphy.gif");
	background-repeat: no-repeat;
	background-size: cover;
}

.container {
	text-align: center;
}

#logout {
  position: fixed;
  top: 10px;
  right: 10px;
}
</style>
</head>
<body align="center">

	<h1>Hello</h1>
	<h1>Wanna Go For a Ride?</h1>
	<button onclick="window.location.href='veiwBikesCustomer'">
		Click Here!!</button>


	<div>
		<button id="logout" onclick="window.location.href='/Bike_Rental_System'">Logout</button>
	</div>
	<%-- Check if the customer is logged in --%>
<c:if test="${customer != null}">
    <button onclick="window.location.href='/Bike_Rental_System/bookingHistory'">Booking History</button>
</c:if>
	
</body>
</html>