<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="icon" href="https://img.freepik.com/premium-vector/bike-sharing-rental-service-logo-icon-with-bicycle_116137-6024.jpg?w=2000" type="image/png">

<style type="text/css">
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
}

h2 {
	color: #333;
}

button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 10px;
	cursor: pointer;
	border-radius: 5px;
}

button:hover {
	background-color: #3e8e41;
}

body {
	background-image:
		url("https://media.giphy.com/media/26uf2I4Vlv2ttNvZm/giphy.gif");
	background-repeat: no-repeat;
	background-size: cover;
	
}

.container {
	text-align: center;
}
#logout {
  position: fixed;
  top: 10px;
  right: 10px;
}

</style>
</head>
<body align="center">
	<h1>Hello Admin!!!</h1>
	<div>
		<button onclick="window.location.href='veiwCustomers'">Veiw Customers</button>
		<button onclick="window.location.href='registerBikes'">Register A Bike</button>
		<button onclick="window.location.href='registerBranch'">Register A Branch</button>
		<button onclick="window.location.href='veiwBikes'">Veiw Bikes</button>
		<button onclick="window.location.href='veiwBranches'">Veiw Branches</button>
		<button onclick="window.location.href='revenue'">Generate Revenue</button>
		<button onclick="window.location.href='bookingHistoryAdmin'">Bookings</button>
		
		
	</div>
	<div>
		<button id="logout"  onclick="window.location.href='/Bike_Rental_System'">Logout</button>
	</div>

</body>
</html>