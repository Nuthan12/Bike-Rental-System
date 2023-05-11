<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</link>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bikes List</h1>

	<table border="2" width="70%" cellpadding="2"
		class="table table-dark table-striped">
		<tr>
			<th>Bike Id</th>
			<th>Bike Name</th>
			<th>Bike Model</th>
			<th>Manufactured Year</th>
			<th>Bike Image</th>


			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<c:forEach var="c" items="${list}">
			<tr>
				<td>${c.bikeId}</td>
				<td>${c.bikeName}</td>
				<td>${c.model}</td>
				<td>${c.manufacturedYear}</td>
				<%-- <td type="image">${c.bikeImage}</td> --%>
				<td><img width="25" height="30" src="data:image/png;base64,${c.bikeImage}"></td>
				<td><a href="editBike/${c.bikeId}">Edit</a></td>

				<td><a href="deleteBike/${c.bikeId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>