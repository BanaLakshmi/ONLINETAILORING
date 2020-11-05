<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
  function expiryDate() {
   alert('enter valid date');}
  </script>
<div class="container">
<div class="row">

<h3 class="panel-title display-td" >Payment Details</h3>
<div class="display-td" >                            
<img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">
</div>
</div>                    
</div>
<div class="form">
<form method="get" action="submitDetails"> <br/>
<div class="inputfield">
<label >CARD NUMBER</label>
<input type="tel" class="input" name="cardNumber" placeholder="Valid Card Number" required autofocus />
</div>
<div class="inputfield">
<label for="cardExpiry" >Expiry Date </label>
<input type="tel"  id="cardExpiry" class="input"    name="cardExpiry" placeholder="MM / YY" required />
</div>

<div class="input">
<label for="CVV">CVV CODE</label>
<input 
type="number" id="CVV" class="input" maxlength="3"  name="cardCVV" placeholder="CVV" required/>
</div>
<div class="input">
<button class="btn" type="submit" onchange="expiryDate()">Pay</button>

</div>
</form>

</div>
</body>
</body>
</html>