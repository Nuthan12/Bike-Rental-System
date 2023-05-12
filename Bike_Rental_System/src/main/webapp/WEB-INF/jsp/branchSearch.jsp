<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bikeRentalSystem.beans.Branch"%>
<%@ page import="com.bikeRentalSystem.dao.BranchDetailsDao"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String query = request.getParameter("query");
	BranchDetailsDao b = new BranchDetailsDao();
	List<Branch> branches = b.searchBranches(query);
	%>
	<table>
		<thead>
			<tr>
				<th>Branch Name</th>
				<th>Branch Address</th>
				<!-- Add more columns if needed -->
			</tr>
		</thead>
		<tbody>
			<%
			for (Branch branch : branches) {
			%>
			<tr>
				<td><%=branch.getBranchName()%></td>
				<td><%=branch.getBranchAddress()%></td>
				<!-- Add more columns if needed -->
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>