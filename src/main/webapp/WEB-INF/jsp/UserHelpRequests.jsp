<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Below are the requests


<div class="container">
	
		<h1 class="text-center">List of HelpRequests</h1>
		<table class="table">
			<thead>
				<tr>
					
					<th>Issue</th>
					<th>Description</th>
					<th>Date Of Ticket</th>
					<th>Resolution</th>
					
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="help" items="${helpsList}">
				
					<tr>
					<td>${help.issue}</td>
					 <td>${help.description}</td>
					<td>${help.dateOfTicket}</td>
					<td>${help.resolution}</td>
					<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
</body>
</html>