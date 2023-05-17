<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branches</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</link>
</head>
<body>
	<h1 align="center">Branches List</h1>
<div align="center">
	
	</div>
	<br>
	<table border="2" width="70%" cellpadding="2"
		class="table table-dark table-striped">
		<tr>
			<th>Branch Id</th>
			<th>Branch Name</th>
			<th>Branch Address</th>
			<th>Pin Code</th>

			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<c:forEach var="c" items="${list}">
			<tr>
				<td>${c.branchId}</td>
				<td>${c.branchName}</td>
				<td>${c.branchAddress}</td>
				<td>${c.branchPinCode}</td>

				<td><a href="editBranch/${c.branchId}">Edit</a></td>

				<td><a href="deleteBranch/${c.branchId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>