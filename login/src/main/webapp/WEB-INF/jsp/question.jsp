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
      Registration Successful -- Answer this Questions
    </div>
<div class="form">
<form method="get" action="savequestion">
<div class="inputfield">
<label>User ID</label><input type=text name=userId id=userId class="input" value="${user.userId }" required /></div>
<div class="inputfield">
<label>User Name</label><input type=text name=userName id=userName class="input" value="${user.userName }" required /></div>
<div class="inputfield">
<label>Your First School ? :</label><input type=text name=a1 id=a1 class="input" required/></div>
<div class="inputfield">
<label>Your birth place ? :</label><input type=text name=a2 id=a2 class="input" required/></div>
<div class="inputfield">
<label>Your first friend ? :</label><input type=text name=a3 id=a3 class="input" required/></div>
<div class="inputfield">
<input type=submit value="Register" class="btn" />
</div>
</form>
</div>
<br/>
</div>
</body>
</html>