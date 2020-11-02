<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Admin Login Form</title>
	<link rel="stylesheet" href="Style.css">

</head>

<body>
<div class="wrapper">
<div class="title">
      Admin Login Form
    </div>
<div class="form">
<form method="get" action="verifyAdmin">
<div class="inputfield">
<label>Admin ID</label><input type=text name=adminId id=adminId class="input" required /></div>
<div class="inputfield">
<label>Password</label><input type=text name=password id=password class="input" required/></div>
<div class="inputfield">
<input type=submit value="Login" class="btn" />
</div>
</form>
</div>
<br/>
<p style="color:red;">${message }</p><br>
 
 <br>
<!-- <p style="color:blue;">Wrong credentials  <a href="">Try again</a></p> -->

</div>
</body>

</html>