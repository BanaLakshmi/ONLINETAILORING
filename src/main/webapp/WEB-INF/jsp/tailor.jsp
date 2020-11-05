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
<p style="color:blue;">Click Here to <a href="displayOrderoftailor" > View ALL Orders and Accept Them </a></p><br>
<p style="color:blue;">Click Here to <a href="ViewOrder" > View Order </a></p><br>
<p style="color:blue;">Click Here to <a href="ViewCompletedOrder" > View Completed Order and generate Bill </a></p><br>

<p style="color:blue;">${message}</p><br>


<div class="wrapper">
<div class="title">
    </div>
<div class="form">
<form method="get" action="feedbackGallery">
<div class="inputfield">
<label></label><input type=hidden name=tailorId id=tailorId  value=${user.userId } class="input" readonly /></div>
<div class="inputfield">
<input type=submit value="Feedback" class="btn" />
</div>
</form>
</div>
</div>
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
