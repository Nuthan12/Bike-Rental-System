<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Return Payment</title>
    <link rel="icon" href="https://img.freepik.com/premium-vector/bike-sharing-rental-service-logo-icon-with-bicycle_116137-6024.jpg?w=2000" type="image/png">
    <style>
    body {
        font-family: Arial, sans-serif;
        text-align: center;
        background-color: #f9f9f9;
    }
    
    h1 {
        color: #333;
    }
    
    form {
        display: inline-block;
        text-align: left;
        margin: 20px;
    }
    
    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
    }
    
    input[type="text"] {
        width: 200px;
        padding: 5px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    
    button[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    
    a {
        color: #333;
        text-decoration: none;
    }
    
    a:hover {
        text-decoration: underline;
    }
    </style>
</head>
<body>
    <h1>Return Payment</h1>
    <li><strong>Booking ID:</strong> <c:out value="${booking.bookingId}" /></li>
    
    <form action="processPayment/${booking.bookingId}" method="post">
        

        
        <h3>Payment Information</h3>
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" required><br>
        
        <label for="expiryDate">Expiry Date:</label>
        <input type="text" id="expiryDate" name="expiryDate" required><br>
        
        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" required><br>
        
        <input type="hidden" name="bookingId" value="${booking.bookingId}" /> 
						<button type="submit">Process Payment</button>
        
        
    </form>
   
    
    <p><a href="bookingHistory">Back to Booking History</a></p>
</body>
</html>

