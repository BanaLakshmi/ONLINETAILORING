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
       Help Form:
    </div>
    
    <div class="form">
<form method="get" action="saveHelp">
<div class="inputfield">
<label>Issue</label><div class="custom_select"><select name="issue" id="issue">
              <option value="">Select</option>
              <option value="loginIssues">LoginIssues</option>
              <option value="paymentIssues">PaymentIssues</option>
            </select>
            </div>
            </div>
            
<div class="inputfield">
<label>Description</label><input type=text name=description id=description class="input" required/></div>
<div class="inputfield">
<label>DateOfTicket</label><input type=date name=dateOfTicket id=dateOfTicket class="input" value="${date}"/></div>
<div class="inputfield">
<input type=submit value="Submit" class="btn" />
</div>

</form>
</div>
<br/>
</div>
<h5>please contact <b>7539964461</b> to report any issues...</h5>
</body>
</html>