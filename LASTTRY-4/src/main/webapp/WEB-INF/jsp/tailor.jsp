<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tailor</title>
</head>
<body>
Tailor
<p style="color:blue;">Click Here to <a href="typeofdresses" >Add type of dresses you can stitch.</a></p><br>
<p style="color:blue;">Click Here to <a href="additionalDetails" >Add Additional Details </a></p><br>
<p style="color:blue;">Click Here to <a href="displayOrderoftailor" > View Order </a></p><br>
<p style="color:blue;">${message }</p><br>


<div class="wrapper">
<div class="title">
      Click on Search to view your Accepted Orders
    </div>
<div class="form">
<form method="get" action="acceptedOrdersGallery">
<div class="inputfield">
<label>Tailor Id</label><input type=text name=tailorId id=tailorId  value=${user.userId } class="input" required /></div>
<div class="inputfield">
<input type=submit value="SignUp" class="btn" />
</div>
</form>
</div>
</div>

<a href="logout">Log Out</a>
</body>
</html>
