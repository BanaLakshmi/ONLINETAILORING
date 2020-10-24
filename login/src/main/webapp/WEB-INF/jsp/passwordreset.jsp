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
      Reset Password
    </div>
<div class="form">
<form method="get" action="modifypass">
<div class="inputfield">
<label>User Name</label><input type=text name=userName id=userName class="input" value="${userName }" required /></div>
<div class="inputfield">
<label>New Password</label><input type=text name=password id=password class="input" required/></div>
<div class="inputfield">
<input type=submit value="Change Password" class="btn" />
</div>
</form>
</div>
<br/>
<p style="color:red;">${message }</p><br>
</div>
</body>
</html>