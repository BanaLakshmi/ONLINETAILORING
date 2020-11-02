<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<div class="container">
	
		<h1 class="text-center">Details of HelpRequests</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Request Id</th>
					<th>Issue</th>
					<th>Description</th>
					<th>Date Of Ticket</th>
					
					
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td>${help.requestId}</td>
						 <td>${help.issue}</td>
						<td>${help.description}</td>
						<td>${help.dateOfTicket}</td>
						
						<td></td>
					</tr>
				
			</tbody>
		</table>
		<br>
		<br>
		<br>
		
	</div>
	<form  method="get" action="saveResolution">
	
	
	<label for="resolution">Resolution</label><br>
	<input type="text" id="${help.resolution}" name="resolution" >
	<input type="submit" value="submit">
	</form>
	

</body>
</html>