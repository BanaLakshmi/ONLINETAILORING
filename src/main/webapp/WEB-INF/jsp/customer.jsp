<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body >
welcome<br>
<p style="color:blue;">Search Tailor<a href="searchTailor">Click here</a></p><br>
<p style="color:blue;">Place Order<a href="createOrder">Click here</a></p><br>
<p style="color:blue;">Click Here to <a href="displayOrderofcustomer" > View Your Orders </a></p><br>
<p style="color:blue;">Click Here to <a href="ViewCustomerOrder" > View Your Order and its status </a></p><br>
<p style="color:blue;">Click Here to <a href="ViewCompletedCustomerOrder" > View Completed Order and Do payments </a></p><br>

<p style="color:blue;">${message}</p><br>
<form method="get" action="help">

<div class="inputfield">
<input type=submit value="Help" class="btn" />

${userId}
</div>
</form>
<p style="color:blue;"> <a href="ViewResolution">Resolution</a></p><br>
<a href="logout">Log Out</a>
</body>
</html>