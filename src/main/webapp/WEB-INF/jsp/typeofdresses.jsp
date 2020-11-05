<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">


function populatedresskinddropdown(value, elementId, url, flag) {
	var length = document.getElementById(elementId).length;
	if (flag) {
		document.getElementById("dressKind").innerHTML = '';
		document.getElementById("dressType").innerHTML = '';
	} else {
		var categoryId = document.getElementById("categoryId").value;
		if (length == 0) {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = JSON.parse(this.responseText);
					var text = "";
					for (var i = 0; i < result.length; i++) {
						if (result[i].trim() == ""
								|| result[i] == 'undefined')
							continue;
						text = text + "<option>";
						text = text + result[i];
						text = text + "</option>";
					}
					document.getElementById(elementId).innerHTML = text;
				}
			};
			xhttp.open("GET", url + categoryId, true);
			xhttp.send();
		}
	}

}

function showOrHideDiv(value) {
	if (value == "Yes") {
		document.getElementById('delAreadiv').style.display = 'block';
	} else {
		if (value == "No") {
			document.getElementById('delAreadiv').style.display = 'none';
		}
	}
}

function populatedressTypedropdown(flag) {
	var length = document.getElementById("dressType").length;
	if (flag) {
		document.getElementById("dressType").innerHTML = '';
		document.getElementById("delArea").innerHTML = '';
	} else {
		if (length == 0) {
			var categoryId = document.getElementById("categoryId").value;
			var dressKindId = document.getElementById("dressKind").value;
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = JSON.parse(this.responseText);
					//			alert(result);
					var text = "";
					for (var i = 0; i < result.length; i++) {
						//						  alert(result[i].trim());
						if (result[i].trim() == ""
								|| result[i] == 'undefined')
							continue;
						text = text + "<option>";
						text = text + result[i];
						text = text + "</option>";
					}
					document.getElementById("dressType").innerHTML = text;
				}
			};
			xhttp.open("GET", "getDressTypeByDressKindNCategory?dressKind="
					+ dressKindId + "&categoryId=" + categoryId, true);
			xhttp.send();

		}

	}

}

</script>

<link rel="stylesheet" href="Style.css">
</head>
<body>

<div class="wrapper">
<div class="title">
      Type of Dress Tailor can stitch
    </div>
    <a href="logout">Log Out</a>
    
<div class="form">
<form method="POST" action="submittypeOfDresses" enctype="multipart/form-data">
<div class="inputfield">
<label>Tailor Id</label><input type=text name=tailorId id=tailorId value=${user.userId } class="input" required /></div>




<div class="inputfield">
					<label>Category</label> <select name="categoryId" id="categoryId"
						onchange="populatedresskinddropdown(this.value,'dressKind','getDressKindByCategory?categoryId=',true)"
						required>
						<option>Choose...</option>
						<c:forEach items="${dressCategorylist}" var="category">
							<option value="${category.categoryId}">${category.dressCategoery}</option>
						</c:forEach>
					</select><br />
				</div>


<div class="inputfield">
					<label>Dress Kind</label> <select id="dressKind" name="dressKind"
						onchange="populatedressTypedropdown(true)"
						onclick="populatedresskinddropdown(this.value,'dressKind','getDressKindByCategory?categoryId=',false)"
						required>
						<!-- <option>Choose...</option> -->
					</select> <br /> <label>Dress Type</label> <select id="dressType"
						name="dressType" onclick="populatedressTypedropdown(false)"
						 required>
						<!-- <option>Choose...</option> -->
					</select>
				</div>


<div class="inputfield">
<label>Pattern</label><input type=file name=pattern  accept="image/png" /><br/></div>

<div class="inputfield">
<label>Cost:</label><input type=text name=cost id=cost class="input" required /></div>

	<div class="inputfield">
					<label>Is Top wear?</label>
					<div class="custom_select">
						<select name="typeOfWear" id="typeOfWear">
						<option value="YES">Yes</option>
							<option value="NO">NO</option>
						</select>
					</div>
				</div>
				
<input type=submit value="Submit" class="btn" />



</form>
</div>
<br>
<p style="color:blue;">${message}</p><br>
<a href="logout">Log Out</a>
</div>

</body>
</html>