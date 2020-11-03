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
<br>

<div>
<h2> Tailor Details</h2>
	<table border="1">
		<tr>
			<td>Tailor ID</td>
			<td>ShopName</td>
			<td>Address</td>
			<td>Contact No.</td>
			<td>Working Hours</td>
			<td>Delivery Address</td>
		</tr>
			<tr>
				<td>${tailor.tailorId }</td>
				<td>${tailor.shopName }</td>
				<td>${tailor.address }</td>
				<td>${tailor.contactNo }</td>
				<td>${tailor.workingHours }</td>
				<td>${tailor.deliveryAddress }</td>
			</tr>
	</table></div>
	<br>
	<br>
	<div>
	<h2> Types Of Dresses</h2> 
	<table border="1">
	<tr>
			<td>Category</td>
			<td>DressType</td>
			<td>DressKind</td>
			<td>Cost</td>
			<td>Pattern Image</td>
		</tr>
<c:forEach var="s" items="${tailorDresses}">
<tr>
<td>${s.tailorId}</td>
<td>${s.dressType}</td>
<td>${s.dressKind}</td>
<td>${s.cost}</td>
<td><img width="150" height="150" src="data:image/jpeg;base64,${s.pic1}" /></td>
</tr>
</c:forEach>
</table>
</div>

<div>
	<h2> Feedback(s)</h2> 
	<table border="1">
<c:forEach var="s" items="${feedbackList}">
<tr>
<td>${s.answer1}</td>
</tr>
</c:forEach>
</table>
<a href="logout">Log Out</a>
</div>
</body>
</html>