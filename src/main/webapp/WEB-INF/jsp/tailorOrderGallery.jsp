<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

	function populatecustomerId(value, elementId, url, flag) {
		var length = document.getElementById(elementId).length;
		console.log("Method called")
		console.log( value + " " + elementId + " " + url + " " + flag)
		if (flag) {
			
			document.getElementById("customerId").innerHTML = '';
		} else {
			var orderId = document.getElementById("orderId").value;
			if (length == 0) {
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						var result = JSON.parse(this.responseText);
						var text = "";
						for (var i = 0; i < result.length; i++) {
							if (result[i].trim() == ""
									|| result[i] == 'undefined')
								continue;
							text = text + "<option>";
							text = text + result[i];
							text = text + "</option>";
						}
						document.getElementById(elementId).innerHTML = text;
					}
				};
				xhttp.open("GET", url + orderId, true);
				xhttp.send();
			}
		}

	}

	
</script>


</head>
<body>
<div class="wrapper">
<div class="title">
    </div>
    <div>
	<h2> Types Of Dresses</h2> 
	<table border="1">
	<tr>
	 <td>  Order Id</td>
           <td> customerId</td>
	 <td>tailorDressId</td>
	<td> fabric</td>
	 <td>materialType</td>
	<td> topLengths</td>
	<td> neck</td>
	<td> top waist</td>
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
	 <td>${s.materialType}</td>
	<td> ${s.topLengths}</td>
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
     <td>${s.categoryId}</td>
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

<div class="wrapper">
<div class="title">
       Accept order and Enter a status
    </div>
<div class="form">
<form method="get" action="savestatus">
<div class="inputfield">
				<label>tailorId</label><input type=text name=tailorId
					value="${user.userId }" id=userId class="input" readonly/>
			</div>
			<div class="inputfield">
					<label>Order ID</label> <select name="orderId" id="orderId"
					onchange="populatecustomerId(this.value,'customerId','getCustomerIdbyOrderId?orderId=',true)"
						required>
						<option>Choose...</option>
						<c:forEach var="s" items="${tailorIds}">
							<option value="${s.orderId}">${s.orderId}</option>
						</c:forEach>
					</select><br />
				</div>
				<div class="inputfield">
					<label>CustomerId</label> <select id="customerId" name="customerId"
						onclick="populatecustomerId(this.value,'customerId','getCustomerIdbyOrderId?orderId=',false)">
						 <option>Choose...</option>
					</select>
				</div>
				


<div class="inputfield">
<label>Status:</label><input type="text" name="status"
					  value="New Order" id="status" class="input"  readonly />
            </div>
            <div class="inputfield">
				<label>Enter a date on which you can deliver </label><input type="date" name="expectedDate"
					 id="expectedDate" class="input" required />
            	</div>
            	<div class="inputfield">
				<label>Enter a Cost in Rs. Which is discussed by Customer </label><input type="number" placeholder="1.0" step="0.01" min="0" max="100000" name="cost"
					 id="cost" class="input" required />
            	</div>
            	<div class="inputfield">
<label>Enter a delivery Address If Needed:</label><input type="text" name="deliveryAddress"
					  id="deliveryAddress" class="input"   />
            </div>
            	
<div class="inputfield">
<input type=submit value="submit" class="btn" />
</div>
</form>
</div>

</div>
<br/>
</div>
<div>
<p style="color:blue;">${message}</p><br>
</div>
</body>
</html>