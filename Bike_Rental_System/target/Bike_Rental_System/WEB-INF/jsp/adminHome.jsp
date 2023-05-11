<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
		url("https://mir-s3-cdn-cf.behance.net/project_modules/1400/c20f9b101544379.5f21408a955ab.gif");
	background-repeat: no-repeat;
	background-size: cover;
}

.container {
	text-align: center;
}
</style>
</head>
<body>
<center>
	<h1>Hello Admin!!!</h1>
	<div>
		<button onclick="window.location.href='veiwCustomers'">Veiw Customers</button>
		<button onclick="window.location.href='registerBikes'">Register A Bike</button>
		<button onclick="window.location.href='registerBranch'">Register A Branch</button>
		<button onclick="window.location.href='veiwBikes'">Veiw Bikes</button>
		<button onclick="window.location.href='veiwBranches'">Veiw Branches</button>
		
	</div>
	</center>
</body>
</html>