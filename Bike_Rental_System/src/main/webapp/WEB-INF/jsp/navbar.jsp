<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
  .navbar {
    background-color: #4CAF50;
    padding: 10px;
  }

  .navbar button {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 10px 20px;
    margin-right: 10px;
    font-size: 16px;
    cursor: pointer;
  }

  .navbar button:hover {
    background-color: red;
  }

  .navbar button.active {
    background-color: red;
  }
</style>
</head>
<body>

	<div class="navbar">
  <nav align="center" class="navbar navbar-expand-lg bg-body-tertiary">
    <button class="${currentPage eq 'loginPage' ? 'active' : ''}" onclick="location.href='loginPage'">Login</button>
    <button class="${currentPage eq 'Bike_Rental_System' ? 'active' : ''}" onclick="location.href='/Bike_Rental_System'">Home</button>
  </nav>
</div>


</body>
</html>