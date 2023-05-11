<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branches</title>
</head>
<body>
	<h1>Branches List</h1>
<table border="2" width="70%" cellpadding="2" class="table table-dark table-striped">
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