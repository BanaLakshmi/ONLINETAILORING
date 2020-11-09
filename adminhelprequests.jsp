<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="helpRequestDetailsForAdmin">

<div class="container">
	
		<h2    style="background-color:ORANGE;" class="text-center">List of HelpRequests</h2>
		<table class="table"; align="center">
			<thead>
				<tr>
					<th  style="background-color:ORANGE;">Request Id</th>
					<!-- <th  style="background-color:ORANGE;">Issue</th>
					<th  style="background-color:ORANGE;">Description</th>
					<th  style="background-color:ORANGE;">Date Of Ticket</th>
					<th  style="background-color:ORANGE;">Resolution</th> -->
					
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${helpRequests}" var="helps">
					<tr>
					<%-- <input type="hidden" name="requestId" value="${helps.requestId}"/> --%>
						<td><input id="requestId" type=submit name="requestId" value="${helps.requestId}" class="btn" /></td>
						
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</form>
</body>
 <head>
    <style type="text/css">
    
  
 
    body
    {

              text-align= center;
	      background-image: url("https://cdn.hipwallpaper.com/i/23/51/3HlLrP.jpg");
	    color:#ffffff;
	     font-family: "Times New Roman", Times, serif; 
	      width:45%;


  border: 5px solid #f26724 ;
  border-radius: 25px;
  box-sizing: border-box;
  margin-top: 40px;
  margin-bottom: 12px;
  padding: 2px; 
}
h2{
text-align: center;
color:white;
padding: 2px; 

    

}

   label{  
    color:yellow;  
    font-size: 17px;
padding: 5px;  
width: 240px;
display: inline-block;
}   

/*css for tab*/
.input{height:20px; width:170px; border:3px solid #000000; color:#000000; font-weight:bold; border-left:5px solid #f7f7f7; opacity:0.9;}
    
     .input:focus{height:28px; border:1px solid #f26724; outline:none; border-left:5px solid #f7f7f7;}
           /* css code for button*/
   .btn{width:180px; height:32px; outline:none; padding:5px; color:#f7f7f7; font-weight:bold; border:0px solid #f26724; 
    text-shadow: 0px 0.5px 0.5px #fff; border-radius: 2px; font-weight: 600; color: #f26724; letter-spacing: 1px; 
    font-size:14px; background-color:#f1f1f1; -webkit-transition: 1s; -moz-transition: 1s; transition: 1s;}
}
  .btn:hover{background-color:#f26724; outline:none;  border-radius: 2px; color:#f1f1f1; border:1px solid #f1f1f1;
    -webkit-transition: 1s; -moz-transition: 1s; transition: 1s;
    
 }
       </head>
</html>