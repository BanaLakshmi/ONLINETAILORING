<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add feedback questions</title>
</head>
<body>
<div class="wrapper">
<div class="title">
      Question Form:
    </div>
    
    <div class="form">
<form method="get" action="saveFeedbackQuestion">

            
<div class="inputfield">
<label>Add the Question</label><input type=text name=question id=question class="input" required/></div>

<div class="inputfield">
<input type=submit value="Submit" class="btn" />
</div>

</form>
</div>
<br/>
</div>
</body>
</html>