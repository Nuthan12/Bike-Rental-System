<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Return Payment</title>
    <!-- Add your CSS stylesheets and other dependencies here -->
</head>
<body>
    <h1>Return Payment</h1>
    
    <form action="processPayment" method="post">
        <input type="hidden" name="bookingId" value="${bookingId}" />
        
        <h3>Payment Information</h3>
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" required><br>
        
        <label for="expiryDate">Expiry Date:</label>
        <input type="text" id="expiryDate" name="expiryDate" required><br>
        
        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" required><br>
        
        <button type="submit">Process Payment</button>
    </form>
    
    <p><a href="bookingHistory">Back to Booking History</a></p>
</body>
</html>
