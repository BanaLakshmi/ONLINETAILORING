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
<label>Shop Name :</label><input type=text name=shopName id=shopName class="input"  required /></div>
<div class="inputfield">
<label> Shop Address :</label><input type=text name=shopAddress id=shopAddress  class="input" required/></div>
<div class="inputfield">
<label>Working Hours :</label><input type=time name=workingHours id=workingHours class="input" required/></div>
<div class="inputfield">
<label> Delivery Service Available :</label><input type=radio name=yes id=yes value=YES class="input"  required /></div>
<div class="inputfield">
<label>Delivery Service Available </label><div class="custom_select"><select name="deliverAvialable" id="deliverAvilable">
              <option value="No">NO</option>
              <option value="Yes">Yes</option>
            </select>
            </div>
            </div>
<div class="inputfield">
<label> Areas Where you can Deliver :</label><input type=text name=deliveryAreas id=deliveryAreas  class="input" /></div><br/>
<p> Enter areas separated by commas(,) example: (Shastri Nagar,Pratap Nagar,..)</p><br/>
<div class="inputfield">
<input type=submit value="Register" class="btn" />
</div>
</form>
</div>
<br/>
</div>
</body>
</html>