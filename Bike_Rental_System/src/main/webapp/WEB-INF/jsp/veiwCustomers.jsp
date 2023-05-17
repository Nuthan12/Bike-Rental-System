<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</link> -->
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-image: url("https://th.bing.com/th/id/OIP.vkTaGPM9y3JkpxdajbPthAHaEK?pid=ImgDet&w=1920&h=1080&rs=1")
}

table {
	border-collapse: collapse;
	width: 100%;
	max-width: auto;
	margin: 0 auto;
	color: white;
}

td {
	padding: 10px;
	border: 1px solid #ddd;
	color:white;
}
h1{
	color:white;
}

form input[type="text"], form input[type="password"], form input[type="custMail"]
	{
	display: block;
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ddd;
}

form input[type="submit"] {
	display: block;
	margin-top: 20px;
	padding: 10px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	
}

.alert {
	padding: 10px;
	margin-bottom: 20px;
	color: #721c24;
	background-color: #f8d7da;
	border-color: #f5c6cb;
	border-radius: 4px;
}
</style>
<title>Customers</title>
</head>
<body >
<h1 align=center>Customers List</h1>

<table border="2" width="70%" cellpadding="2"
	class="table table-dark table-striped">
	<tr>
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Customer Mail</th>
		<th>Customer Phone</th>
		<th>Driving License Number</th>
		<th>Age</th>
		<th>Password</th>
		<th>Edit</th>
		<th>Delete</th>

	</tr>
	<c:forEach var="c" items="${list}">
		<tr>
			<td>${c.custId}</td>
			<td>${c.custName}</td>
			<td>${c.custMail}</td>
			<td>${c.custPhone}</td>
			<td>${c.dlNumber}</td>
			<td>${c.age}</td>
			<td>${c.password}</td>
			<td><a href="editCustomer/${c.custId}">Edit</a></td>

			<td><a href="deleteCustomer/${c.custId}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
</body>
</html>
