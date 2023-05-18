<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bikes</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-image: url("https://th.bing.com/th/id/R.8c784a2e84ff9ab05585e89dac4ebbcd?rik=O%2b9T1oq6OXc6sQ&riu=http%3a%2f%2f4.bp.blogspot.com%2f-SR2EgtL4zsQ%2fTyQ5a6hlZ2I%2fAAAAAAAAPW8%2fDmDA2PQFSyc%2fs1600%2fmotorbikes_013.jpg&ehk=xZaxwmxgqzD4D3tGeLiVFfgWXkkXI4Ei92Q7ND11KHs%3d&risl=&pid=ImgRaw&r=0");
	background-repeat: norepeat;
	background-size: cover;
	color:white;
}

h1 {
	color: white;
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
	background-color: black;
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
<body align="center">
	<h1 align="center">Bikes List</h1>

	<table border="2" width="70%" cellpadding="2"
		class="table table-dark table-striped">
		<tr>
			<th>Bike Id</th>
			<th>Bike Name</th>
			<th>Bike Model</th>
			<th>Manufactured Year</th>
			<th>Bike Image</th>
			<th>Availability</th>
			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<c:forEach var="c" items="${list}">
			<tr>
				<td>${c.bikeId}</td>
				<td>${c.bikeName}</td>
				<td>${c.model}</td>
				<td>${c.manufacturedYear}</td>
				<td><img width="25" height="30" src="data:image/png;base64,${c.bikeImage}"></td>
				<td>${c.available}</td>
				<td><a href="editBike/${c.bikeId}">Edit</a></td>

				<td><a href="deleteBike/${c.bikeId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<button onclick="window.location.href='registerBikes'">Register More Bikes</button>
</body>
</html>