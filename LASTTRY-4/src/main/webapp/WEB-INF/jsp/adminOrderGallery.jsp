<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Order Page</title>
	<link rel="stylesheet" href="Style.css">
	
</head>
<body>
<div class="wrapper">
<div class="title">
    </div>
    <div>
	<h2> Types Of Dresses</h2> 
	<table border="1">
	<tr>
	<td> Order Id</td>
           <td> customerId</td>
	 <td>tailorDressId</td>
	<td> fabric</td>
	 <td>materialType<td>
	<td> topLengths</td>
	<td> neck</td>
	<td> topwaist</td>
	<td> chest</td>
	<td>shoulderLength</td>
	<td> bottomFabric</td>
	<td> bottomMaterialType</td>
    <td> bottomLengths</td>
	<td> hip</td>
	 <td>kneeLength</td>
	 <td>comments</td>
	 <td>expectedDate</td>
	 <td>tailorId</td>
     <td>categoryId </td>
	<td> dressType</td>
	<td> dressKind</td>
	<td> pattern</td>
	 <td>cost</td>
	 <td>Delivery Address</td>
		</tr>
<c:forEach var="s" items="${tailorIds}">
<tr>
<td> ${s.orderId}</td>
<td> ${s.customerId}</td>
	 <td> ${s.tailorDressId}</td>
	<td> ${s.fabric}</td>
	 <td>${s.materialType}<td>
	<td> ${s. topLengths}</td>
	<td> ${s.neck}</td>
	<td> ${s.topwaist}</td>
	<td> ${s.chest}</td>
	<td>${s.shoulderLength}</td>
	<td> ${s.bottomFabric}</td>
	<td> ${s.bottomMaterialType}</td>
    <td> ${s.bottomLengths}</td>
	<td> ${s.hip}</td>
	 <td>${s.kneeLength}</td>
	 <td>${s.comments}</td>
	 <td>${s.expectedDate}</td>
	 <td>${s.tailorId}</td>
     <td>${s.categoryId} </td>
	<td> ${s.dressType}</td>
	<td> ${s.dressKind}</td>
    <td><img width="150" height="150" src="data:image/jpeg;base64,${s.pic1}" /></td>
    <td>${s.cost}</td>
    <td>${s.deliveryArea}</td>
</tr>
</c:forEach>
</table>
</div>

<br>

<p style="color:red;">${message}</p><br>
</div>
</body>
</html>