<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book A Bike</title>
</head>
<body>
<h1>Bikes Available </h1>

	<table border="2" width="70%" cellpadding="2"
		class="table table-dark table-striped">
		<tr>
			<th>Bike Id</th>
			<th>Bike Name</th>
			<th>Bike Model</th>
			<th>Manufactured Year</th>
			<th>Bike Image</th>


			<th>Book Now</th>

		</tr>
		<c:forEach var="c" items="${list}">
			<tr>
				<td>${c.bikeId}</td>
				<td>${c.bikeName}</td>
				<td>${c.model}</td>
				<td>${c.manufacturedYear}</td>
				<%-- <td type="image">${c.bikeImage}</td> --%>
				<td><img width="25" height="30" src="data:image/png;base64,${c.bikeImage}"></td>
				<td><a href="bookBike/${c.bikeId}">Book Now</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>