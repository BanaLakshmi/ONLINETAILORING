<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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