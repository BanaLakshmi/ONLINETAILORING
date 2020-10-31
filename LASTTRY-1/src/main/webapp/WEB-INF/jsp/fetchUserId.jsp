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
      Enter Details
    </div>
<div class="form">
<form method="get" action="UserIdDisplay">
<div class="inputfield">
<label>Email Id</label><input type=text name=email id=email class="input"  required /></div>
<div class="inputfield">
<label>Your First School ? :</label><input type=text name=a1 id=a1 class="input" required/></div>
<div class="inputfield">
<label>Your birth place ? :</label><input type=text name=a2 id=a2 class="input" required/></div>
<div class="inputfield">
<label>Your first friend ? :</label><input type=text name=a3 id=a3 class="input" required/></div>
<div class="inputfield">
<input type=submit value="Verify" class="btn" />
</div>

</form>
</div>
<br/>
<p style="color:red;">${message }</p><br>
</div>
</body>
</html>