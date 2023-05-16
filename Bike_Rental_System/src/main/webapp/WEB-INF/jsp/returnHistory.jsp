<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return History</title>
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
	<h1>Return History</h1>

	<table border="1">
		<tr>
			<th>Booking ID</th>
			<th>Customer ID</th>
			<th>Bike ID</th>
			<th>Booked Time</th>
			<th>Return</th>
		</tr>
		<c:forEach var="returnH" items="${returnHistory}">
			<tr>
				<td>${returnH.bookingId}</td>
				<td>${returnH.custId}</td>
				<td>${returnH.bikeId}</td>
				<td>${returnH.bookedTime}</td>
				<td>
					<form action="payment/${ returnH.bookingId}" method="post">
						<input type="hidden" name="bookingId" value="${returnH.bookingId}" />
						<button type="submit">Return</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</head>

</html>