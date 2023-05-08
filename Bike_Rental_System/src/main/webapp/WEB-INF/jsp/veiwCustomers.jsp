
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
	</link>
<h1>Customers List</h1>
<table border="2" width="70%" cellpadding="2" class="table table-dark table-striped">
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
