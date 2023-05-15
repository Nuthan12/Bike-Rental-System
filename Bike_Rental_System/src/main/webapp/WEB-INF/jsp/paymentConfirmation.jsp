<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Confirmation</title>
    <style>
        /* CSS styling */
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
        
        .back-link a {
            color: #333;
            text-decoration: none;
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
            <a href="veiwBikesCustomer">Back to Bikes List</a>
        </div>
    </div>
</body>
</html>
