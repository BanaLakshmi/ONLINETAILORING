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
	<h2> Feedbacks </h2> 
	<table border="1">
	<tr>
           <td> Order Id</td>
	 <td>Feedback Date</td>
	<td> Customer Id</td>
	<td> Review </td>
	 
		</tr>
<c:forEach var="s" items="${s}">
<tr>
<td> ${s.orderId}</td>
	 <td> ${s.feedbackDate}</td>
	<td> ${s.userId}</td>
	<td> ${s.answer1}</td>
</tr>
</c:forEach>
</table>
</div>
</div>
<br>
</body>
</html>