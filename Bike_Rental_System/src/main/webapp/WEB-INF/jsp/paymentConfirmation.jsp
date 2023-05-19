<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Confirmation</title>
    <link rel="icon" href="https://img.freepik.com/premium-vector/bike-sharing-rental-service-logo-icon-with-bicycle_116137-6024.jpg?w=2000" type="image/png">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            text-align: center;
            color: #333;
        }
        
        p {
            margin-bottom: 10px;
        }
        
        .payment-details {
            margin-top: 20px;
            border-top: 1px solid #ccc;
            padding-top: 20px;
        }
        
        .payment-details p {
            font-weight: bold;
        }
        
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        
        .back-link button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        .back-link button:hover {
            background-color: #45a049;
        }
        
        .back-link button:active {
            background-color: #3e8e41;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Payment Confirmation</h1>
        
        <p>Thank you for your payment!</p>
        
        <div class="payment-details">
            <p>Booking ID: ${booking.bookingId}</p>
            <p>Payment Amount: $${paymentAmount}</p>
        </div>
        
        <div class="back-link">
             <button id="logout" onclick="window.location.href='/Bike_Rental_System/customerHome'">Home</button>
        </div>
    </div>
</body>
</html>
