<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script type="text/javascript">
function validateForm() {
	  var age = document.getElementById("ageValidation").value;
	  if (age < 18) {
	    alert("Age must be at least 18");
	    return false;
	  }
	  return true;
	}

</script>

</head>
<body>
	<h1>Register a New Customer</h1>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>

	<form:form method="post" action="save">

		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="custName" /></td>
			</tr>
			<tr>
				<td>Mail :</td>
				<td><form:input path="custMail" /></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><form:input path="custPhone" /></td>
			</tr>
			<tr>
				<td>DL Number :</td>
				<td><form:input path="dlNumber" /></td>
			</tr>
			<tr>

				<td>Age :</td>
				<td><form:input path="age" id="ageValidation" /></td>

			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Save"
					onclick="return validateForm()" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>