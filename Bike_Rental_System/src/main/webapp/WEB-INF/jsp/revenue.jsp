<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Revenue</title>
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
        
        .form-container {
            margin-bottom: 20px;
            text-align: center;
        }
        
        .form-container label {
            display: inline-block;
            margin-right: 10px;
        }
        
        .form-container select {
            padding: 5px;
        }
        
        .revenue-details {
            margin-top: 20px;
            border-top: 1px solid #ccc;
            padding-top: 20px;
        }
        
        .revenue-details p {
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
        <h1>Revenue</h1>
        
        <div class="form-container">
            <form method="post" action="revenue">
                <label for="branchId">Select Branch:</label>
                <select id="branchId" name="branchId">
                    <c:forEach var="branch" items="${branches}">
                        <option value="${branch.branchId}">${branch.branchName}</option>
                    </c:forEach>
                </select>
                <button type="submit">Show Revenue</button>
            </form>
        </div>
        
        <div class="revenue-details">
            <c:if test="${not empty branch}">
                <p>Branch: ${branch.branchName}</p>
                <p>Monthly Revenue: $${monthlyRevenue}</p>
                <p>Quarterly Revenue: $${quarterlyRevenue}</p>
                <p>Yearly Revenue: $${yearlyRevenue}</p>
            </c:if>
        </div>
        
        <div class="back-link">
            <a href="/Bike_Rental_System/veiwBranches">Back to Branch List</a>
        </div>
    </div>
</body>
</html>
