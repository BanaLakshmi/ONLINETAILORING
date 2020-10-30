<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function populatesubdropdown(value,elementId,url)
{
	console.log(value);
	console.log(elementId);
	console.log(url);
//	alert("function is called");
//	alert(categoryId);
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var result=JSON.parse(this.responseText);
//	alert(result);
			      var text="";
		      for(var i=0;i<result.length;i++)
			  {
//				  alert(result[i].trim());
				  if(result[i].trim()=="" || result[i]=='undefined')
					  continue;
		    	  text=text+"<option>";
		    	  text=text+result[i];
		    	  text=text+"</option>";				  
			  }
			  document.getElementById(elementId).innerHTML=text;
		     }
		  };
		  xhttp.open("GET", url+value, true);
		  xhttp.send();
}

function showOrHideDiv(value) {
	console.log(value)
	if (value == "Yes") {
				document.getElementById('delArea').style.display = 'block';
				document.getElementById("address").setAttribute("required", "")
	} else {
		if (value == "No") {
			document.getElementById('delArea').style.display = 'none';
			document.getElementById("address").removeAttribute(
					"required")
		} 
	}
}

function populatedropdown() {
	var categoryId=document.getElementById("categoryId").value;
	var dressKindId=document.getElementById("dressKind").value;
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var result=JSON.parse(this.responseText);
//	alert(result);
			      var text="";
		      for(var i=0;i<result.length;i++)
			  {
//				  alert(result[i].trim());
				  if(result[i].trim()=="" || result[i]=='undefined')
					  continue;
		    	  text=text+"<option>";
		    	  text=text+result[i];
		    	  text=text+"</option>";				  
			  }
			  document.getElementById("dressTypeKind").innerHTML=text;
		     }
		  };
		  xhttp.open("GET", "getDressTypeByDressKindNCategory?dressKind="+dressKindId+"&categoryId="+categoryId, true);
		  xhttp.send();
}
</script>

</head>
<body>
	tailor
	<div class="wrapper">
		<div class="inputfield">
			<label>Category</label> <select id="categoryId"
				onchange="populatesubdropdown(this.value,'dressKind','getDressKindByCategory?categoryId=')">
				<option>Choose...</option>
				<c:forEach items="${dressCategorylist}" var="category">
					<option value="${category.categoryId}">${category.dressCategoery}</option>
				</c:forEach>
			</select><br />
		</div>
		<div class="inputfield">
			<label>Dress Kind</label> <select id="dressKind"
				onchange="populatesubdropdown(this.value,'dressTypeKind','getDressTypeByDressKind?dressKind=')">
				<option>Choose...</option>
			</select><br /> <label>Dress Type</label> <select id="dressTypeKind" onclick="populatedropdown()">
			<option>Choose...</option>
			</select>

		</div>
		<div class="inputfield">
			<label>Need Courier </label>
			<div class="custom_select">
				<select name="courier" id="courier"
					onclick="showOrHideDiv(this.value)">
					<option value="No">NO</option>
					<option value="Yes">Yes</option>
				</select>
			</div>
		</div>
		<div class="inputfield" id="delArea" style="display: none;">
			<label>Address :</label><input type=text name=address id=address
				class="input" />
		</div>


	</div>
</body>
</html>