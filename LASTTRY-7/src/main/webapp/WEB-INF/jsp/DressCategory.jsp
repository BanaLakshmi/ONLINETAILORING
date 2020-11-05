<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Registration Form</title>
	<link rel="stylesheet" href="Style.css">
	
</head>
<body>
<div class="wrapper">
<div class="title">
      Dress Category Form
    </div>
<div class="form">
<form method="get" action="addDressCategory">
<div class="inputfield">
<label>Add Dress Category</label><input type=text name=dressCategoery id=dressCategoery class="input" required /></div>
<div class="inputfield">
<input type=submit value="Submit" class="btn" />
</div>
</form>
</div>
<br>

<p style="color:red;">${message}</p><br>
</div>
</body>
</html>