<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

	function showOrHideDiv(value) {
		if (value == "true") {
			document.getElementById('delAreadiv').style.display = 'block';
		} else {
				document.getElementById('delAreadiv').style.display = 'none';
		}
	}

	
</script>
</head>

<body>
<div class="wrapper">
<div class="form">
<form method="get" action="saveadditionaldetails">
<div class="inputfield">
<label>Tailor Id:</label><input type=text name=tailorId id=tailorId class="input" value="${user.userId }"  readonly /></div>
<div class="inputfield">
<label>Contact No:</label><input type=text name=contactNo id=contactNo class="input" value="${user.contactNo }"  readonly /></div>
<div class="inputfield">
<label>Shop Name :</label><input type=text name=shopName id=shopName class="input"  required /></div>
<div class="inputfield">
<label> Shop Address :</label><input type=text name=address id=address  class="input" required/></div>
<div class="inputfield">
<label>Working Hours :</label><input type=text name=workingHours id=workingHours class="input" required/></div>
<div class="inputfield">
<label>Delivery Service Available </label><div class="custom_select"><select name="courier" id="courier" onchange="showOrHideDiv(this.value)">
              <option value="false">NO</option>
              <option value="true">Yes</option>
            </select>
            </div>
            </div>
<div class="inputfield" id="delAreadiv" style="display: none;">
<label> Areas Where you can Deliver :</label><input type=text name=deliveryAddress id=deliveryAddress  class="input" />
<p> Enter areas separated by commas(,) example: (Shastri Nagar,Pratap Nagar,..)</p><br/>
</div><br/>

<div class="inputfield">
<input type=submit value="Register" class="btn" />
</div>
</form>
</div>
<br/>
<p style="color:blue;">${message}</p><br>
<a href="logout">Log Out</a>
</div>
</body>
</html>