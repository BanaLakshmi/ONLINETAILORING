<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customer Orders</title>
</head>
<body>
View Customer Orders


<br>
<br>
<br>
<div class="wrapper">
<div class="title">
    </div>
<div class="form">
<form method="get" action="completedOrders">
<div class="inputfield">
<label></label><input type=hidden name=tailorId id=tailorId  value=${user.userId } class="input" readonly /></div>
<div class="inputfield">
<label></label><input type=hidden name=status id=status  value="Active Order" class="input" readonly /></div>
<div class="inputfield">
<input type=submit value="View Active Orders" class="btn" />
</div>
</form>
</div>
</div>
<div class="wrapper">
<div class="title">
    </div>
<div class="form">
<form method="get" action="activeOrders">
<div class="inputfield">
<label></label><input type=hidden name=tailorId id=tailorId  value=${user.userId } class="input" readonly /></div>
<div class="inputfield">
<label></label><input type=hidden name=status id=status  value="New Order" class="input" readonly /></div>
<div class="inputfield">
<input type=submit value="View New Orders" class="btn" />
</div>
</form>
</div>
</div>
<p style="color:red;">${message }</p><br>
<p style="color:blue;">Click Here to <a href="tailor" >  Go back to tailor </a></p><br>
<a href="logout">Log Out</a>
</body>
</html>
