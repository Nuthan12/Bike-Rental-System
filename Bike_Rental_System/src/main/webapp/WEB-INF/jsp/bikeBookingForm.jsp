<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  /* Your CSS styles here */
</style>
</head>
<body>
  <h2 align="center">Book A Bike</h2>
  
  <div align="center">
    <form:form method="POST" action="/Bike_Rental_System/bookBike">
      <table class="table table-light table-striped">
        <tr>
          <td><form:hidden path="bikeId" /></td>
        </tr>

        <c:forEach var="c" items="${list}">
          <tr>
            <td>Bike Name: ${c.bikeName}</td>
            <td>Bike Model: ${c.bikeName}</td>
            <td>Model: ${c.model}</td>
            <td>Manufactured Year: ${c.manufacturedYear}</td>
            <td>Image: <img width="25" height="30" src="data:image/png;base64,${c.bikeImage}"></td>
            <td>Branch Name: ${c.branchName}</td>
            <td>Branch Address: ${c.branchAddress}</td>
            <td>Pin Code: ${c.branchPinCode}</td>
          </tr>
        </c:forEach>
      </table>

      <tr>
        <td></td>
        <td><input type="submit" value="Book Now" /></td>
      </tr>
    </form:form>
  </div>
</body>
</html>
