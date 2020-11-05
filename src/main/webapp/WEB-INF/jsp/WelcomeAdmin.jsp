<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hello admin 
<p style="color:blue;">Click Here to <a href="DressCategory">Add Dress Category</a></p><br>
<p style="color:blue;">Click Here to <a href="DressType">Add Dress Type</a></p><br>
<p style="color:blue;">Click Here to <a href="adminOrderGallery">View all orders</a></p><br>
<form method="get" action="helpRequestForAdmin">

<div class="inputfield">
<input type=submit value="Help Requests" class="btn" />
</div>
</form>
<p style="color:red;">${message }</p><br>
</body>
</html>