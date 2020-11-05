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
      SignUp Form
    </div>
<div class="form">
<form method="get" action="add">
<div class="inputfield">
<label>User Id</label><input type=text name=userId id=userId class="input" required /></div>
<div class="inputfield">
<label>Password</label><input type=text name=password id=password class="input" required /></div>
<div class="inputfield">
<label>First Name</label><input type=text name=firstName id=firstName class="input" required /></div>
<div class="inputfield">
<label>Last Name</label><input type=text name=lastName id=lastName class="input" required /></div>
<div class="inputfield">
<label>Contact Number</label><input type=text name=contactNo id=contactNo class="input" required /></div>
<div class="inputfield">
<label>Date of Birth</label><input type="date" name=dob id=dob class="input" required /></div>
<div class="inputfield">
<label>Gender</label><div class="custom_select"><select name="gender" id="gender" required>
              <option value="">Select</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
            </select>
            </div>
            </div>
<div class="inputfield">
<label>Email</label><input type=text name=email id=email class="input" required /></div>
<div class="inputfield">
<label>Category</label><div class="custom_select"><select name="category" id="category" required>
              <option value="">Select</option>
              <option value="customer">Customer</option>
              <option value="tailor">Tailor</option>
            </select>
            </div>
            </div>
<div class="inputfield">
<input type=submit value="SignUp" class="btn" />
</div>
</form>
</div>
<br>

<p style="color:blue;">Already Registered Click <a href="Login">  Login</a></p>
<p style="color:red;">${message}</p><br>
</div>
</body>
</html>