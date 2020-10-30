<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login Form</title>
	<link rel="stylesheet" href="Style.css">

</head>

<body>
<div class="wrapper">
<div class="title">
      Login Form
    </div>
<div class="form">
<form method="get" action="verify">
<div class="inputfield">
<label>User Id</label><input type=text name=userId id=userId class="input" required /></div>
<div class="inputfield">
<label>Password</label><input type=text name=password id=password class="input" required/></div>
<div class="inputfield">
<input type=submit value="Login" class="btn" />
</div>
</form>
</div>
<br/>
<p style="color:red;">${message }</p><br>
 <p style="color:blue;">Forgot UserId<a href="fetchUserId">Click here</a></p><br>
 <p style="color:blue;">Forgot Password<a href="resetpass">Click here</a></p><br>
 <br>
<p style="color:blue;">Not Registered Click <a href="SignUp">SignUp</a></p>

</div>
</body>

</html>