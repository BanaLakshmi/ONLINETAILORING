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
			document.getElementById('delAreadiv').style.display = 'none';
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

	function showPatterns() {
		var categoryId = document.getElementById("categoryId").value;
		var dressKindId = document.getElementById("dressKind").value;
		var dressType = document.getElementById("dressType").value;
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				console.log("result")
				document.getElementById('patterntable').style.display = 'block';
				var table = document.getElementById("myTable");
				table.refresh();
			}

		};
		xhttp.open("GET", "getPatternsOnBasisOfSelection?categoryId="
				+ categoryId + "&dressKind=" + dressKindId + "&dressType="
				+ dressType, true);
		xhttp.send();

	}

	function populatedeliveryareadropdown(flag) {
		var length = document.getElementById("delArea").length;
		if (length == 0 || flag) {
			var categoryId = document.getElementById("categoryId").value;
			var dressKindId = document.getElementById("dressKind").value;
			var dressType = document.getElementById("dressType").value;
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = JSON.parse(this.responseText);
					var text = "";
					for (var i = 0; i < result.length; i++) {
						if (result[i].trim() == "" || result[i] == 'undefined')
							continue;
						text = text + "<option>";
						text = text + result[i];
						text = text + "</option>";
					}
					document.getElementById("delArea").innerHTML = text;
				}
			};
			xhttp.open("GET", "getDeliveryAreas?categoryId=" + categoryId
					+ "&dressKind=" + dressKindId + "&dressType=" + dressType,
					true);
			xhttp.send();
		}
	}
</script>

</head>
<body>
	tailor
	<div class="wrapper">
		<div class="title">Tailor Search Form</div>
		<div class="form">
			<form method="get" action="getPatternsOnBasisOfSelection">

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
						onchange="populatedeliveryareadropdown(true)" required>
						<!-- <option>Choose...</option> -->
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
				
				<div id="delAreadiv" class="inputfield" style="display: none;">
					<label>Deliver Area:</label> <select id="delArea" name="delArea"
						onclick="populatedeliveryareadropdown(false)">
						<!-- <option>Choose...</option> -->
					</select>
				</div>

				<div class="inputfield">
					<input type=submit value="Search" class="btn" />
				</div>

			</form>

			<a href="logout">Log Out</a>
		</div>
	</div>

</body>
</html>