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
      Bill Generation
    </div>
<div class="form">
<form method="get" action="billGeneration">
<div class="inputfield">
<label>Order Id</label><input type=number name=orderId id=orderId class="input"  required /></div>
<div class="inputfield">
<label>Customer Id</label><input type="text" name=customerId id=customerId class="input"  required /></div>
<div class="inputfield">
<label>Tailor Id</label><input type="text" name=tailorId id=tailorId class="input"  value="${user.userId }"  readonly /></div>
<div class="inputfield">
				<label>Enter a Cost in Rs. Which is discussed by Customer </label><input type="number" placeholder="1.0" step="0.01" min="0" max="100000" name="cost"
					 id="cost" class="input" required />
            	</div>
            	<div class="inputfield">
<label>Enter a delivery Address If Needed:</label><input type="text" name="deliveryAddress"
					  id="deliveryAddress" class="input"   />
            </div>
            <div class="inputfield">
<label>Enter a delivery Date:</label><input type="date" name="expectedDate"
					  id="expectedDate" class="input"   />
            </div>

<div class="inputfield">
<input type=submit value="Generate A Bill" class="btn" />
</div>
</form>
</div>
</div>
<br/>
<p style="color:red;">${message }</p><br>
<p style="color:blue;">Click Here to <a href="ViewCompletedOrder" > View Other Orders </a></p><br>
<br>
</body>
</html>