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
<div class="wrapper">
<div class="title">
    </div>
    <div>
	<h2> Accepted Orders</h2> 
	<table border="1">
	<tr>
	 <td>  Tailor Id</td>
           <td> Order Id</td>
           <td> Customer Id</td>
	 <td>Status</td>
	<td> Expected Date of Delivery</td>
	 
		</tr>
<c:forEach var="s" items="${s}">
<tr>
<td> ${s.tailorId}</td>
<td> ${s.orderId}</td>
<td>${s.customerId}</td>
	 <td> ${s.status}</td>
	<td> ${s.expectedDate}</td>
</tr>
</c:forEach>
</table>
</div>
</div>
<br>

</body>
</html>