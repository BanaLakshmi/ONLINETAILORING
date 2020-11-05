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
	<h2> Orders</h2> 
	<table border="1">
	<tr>
	 <td>  Tailor Id</td>
           <td> Order Id</td>
           <td>Customer Id</td>
	 <td>Status</td>
	<td> Expected Date of Delivery</td>
	<td> Cost of Order</td>
	<td> Address Where You need Delivery</td>
	 
		</tr>
<c:forEach var="s" items="${s}">
<tr>
<td> ${s.tailorId}</td>
<td> <a href="displayOrderbyOrderId?orderId=${s.orderId}">${s.orderId}</a></td>
<td>${s.customerId}</td>
	 <td> ${s.status}</td>
	<td> ${s.expectedDate}</td>
	<td> ${s.cost}</td>
	<td> ${s.deliveryAddress}</td>
</tr>
</c:forEach>
</table>
</div>
</div>
<div class="wrapper">
<div class="title">
      Status Update
    </div>
<div class="form">
<form method="get" action="modifystatusoforder">
<div class="inputfield">
<label>Order Id</label><input type=number name=orderId id=orderId class="input"  required /></div>
<div class="inputfield">
<label>Order Status</label><div class="custom_select"><select name="status" id="status" required>
              <option value="">Select</option>
              <option value="Completed Order">Completed Order</option>
              <option value="Active Order">Active Order</option>
            </select>
            </div>
            </div>
<div class="inputfield">
<input type=submit value="Update Status" class="btn" />
</div>
</form>
</div>
<br/>
<p style="color:red;">${message }</p><br>
</div>
<p style="color:blue;">Click Here to <a href="ViewOrder" > View Other Orders </a></p><br>
<br>
</body>
</html>