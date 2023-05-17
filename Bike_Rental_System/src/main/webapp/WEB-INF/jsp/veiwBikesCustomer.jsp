<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bikes Available</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-image: url("https://th.bing.com/th/id/R.8c784a2e84ff9ab05585e89dac4ebbcd?rik=O%2b9T1oq6OXc6sQ&riu=http%3a%2f%2f4.bp.blogspot.com%2f-SR2EgtL4zsQ%2fTyQ5a6hlZ2I%2fAAAAAAAAPW8%2fDmDA2PQFSyc%2fs1600%2fmotorbikes_013.jpg&ehk=xZaxwmxgqzD4D3tGeLiVFfgWXkkXI4Ei92Q7ND11KHs%3d&risl=&pid=ImgRaw&r=0");
	background-repeat: norepeat;
	background-size: cover;
	color:white;
	
}

table {
	border-collapse: collapse;
	width: 100%;
	max-width: auto;
	margin: 0 auto;
	color: ;
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
</head>
<body>
	<h1 align="center">Bikes List</h1>

	<table border="2" width="70%" cellpadding="2"
		class="table table-dark table-striped">
		<tr>
			<th>Bike Id</th>
			<th>Bike Name</th>
			<th>Bike Model</th>
			<th>Manufactured Year</th>
			<th>Branch Id</th>
			<th>Bike Image</th>
			<th>Book</th>

		</tr>
		<c:forEach var="c" items="${list}">
			<tr>
				<td>${c.bikeId}</td>
				<td>${c.bikeName}</td>
				<td>${c.model}</td>
				<td>${c.manufacturedYear}</td>
				<td>${c.branchId}</td>
				<%-- <td type="image">${c.bikeImage}</td> --%>
				<td><img width="25" height="30" src="data:image/png;base64,${c.bikeImage}"></td>
			    <td align="center">
                    <form action="<c:url value='/bookBike'/>" method="post">
                        <input type="hidden" name="bikeId" value="${c.bikeId}"/>
                        <input type="submit" value="Book Now"/>
                    </form>
                </td>
				

				

				
			</tr>
		</c:forEach>
	</table>
</body>
</html>