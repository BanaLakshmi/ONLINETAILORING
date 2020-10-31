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
<form method="get" action="helpRequestDetailsForAdmin">

<div class="container">
	
		<h1 class="text-center">List of HelpRequests</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Request Id</th>
					<!-- <th>Issue</th>
					<th>Description</th>
					<th>Date Of Ticket</th>
					<th>Resolution</th> -->
					
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${helpRequests}" var="helps">
					<tr>
						<td><input id="requestId" type=submit name="requestId" value="${helps.requestId}" class="btn" /></td>
						<%-- <td>${helps.issue}</td>
						<td>${helps.description}</td>
						<td>${helps.dateOfTicket}</td>
						<td>${helps.resolution}</td> --%>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</form>
</body>
</html>