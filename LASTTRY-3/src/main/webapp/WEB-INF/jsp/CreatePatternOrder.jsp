<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function ShowHideDiv(valid) {
		console.log(valid)
		var text = "";
		text = "radiobtn " + valid
		console.log(text)
		var ele = document.getElementById(text).value;
		console.log(ele)
		var val = ele.split(' ')
		var topwear = (val[3]);
		console.log(topwear)
		document.getElementById("tailorDressId").value = val[0];
		document.getElementById("tailorId").value = val[5];
		if (topwear == "YES") {
			document.getElementById('bottomwear').style.display = 'none';
			document.getElementById('topwear').style.display = 'block';

		} else {
			document.getElementById('topwear').style.display = 'none';
			document.getElementById('bottomwear').style.display = 'block';
		}

	}
	function showAlert(){
		alert("Order has been placed successfully")};
	
</script>
</head>
<body>
	<div class="wrapper">

		<form method="get" action="placeorder">

			<br>
			<h2>Types Of Dresses</h2>
			<table border="1">
				<tr>
					<td>Select Only One</td>
					<td>Category</td>
					<td>DressType</td>
					<td>DressKind</td>
					<td>Cost</td>
					<td>Pattern Image</td>
				</tr>
				<c:forEach var="s" items="${tailorDresses}" varStatus="i">
					<tr>
						<td><input type="radio" name="radiobtn" value="${s}"
							id="${'radiobtn ' += i.index}"  onclick="ShowHideDiv(${i.index})" /></td>
						<td>${s.tailorId}</td>
						<td>${s.dressType}</td>
						<td>${s.dressKind}</td>
						<td>${s.cost}</td>
						<td><img width="150" height="150"
							src="data:image/jpeg;base64,${s.pic1}" /></td>
					</tr>
				</c:forEach>
			</table>

			<div id="topwear" style="display: none;">
				<div class="inputfield">
					<label>fabric</label><input type=text name=fabric id=fabric
						class="input" />
				</div>
				<div class="inputfield">
					<label>materialType</label><input type=text name=materialType
						id=materialType class="input" />
				</div>
				<div class="inputfield">
					<label>topLengths</label><input type=text name=topLengths
						id=topLengths class="input" />
				</div>
				<div class="inputfield">
					<label>neck</label><input type=text name=neck id=neck class="input" />
				</div>
				<div class="inputfield">
					<label>topwaist</label><input type=text name=topwaist id=topwaist
						class="input" />
				</div>
				<div class="inputfield">
					<label>chest</label><input type=text name=chest id=chest
						class="input" />
				</div>
				<div class="inputfield">
					<label>shoulderLength</label><input type=text name=shoulderLength
						id=shoulderLength class="input" />
				</div>
			</div>
			<div id="bottomwear" style="display: none;">
				<div class="inputfield">
					<label>bottomFabric</label><input type=text name=bottomFabric
						id=bottomFabric class="input" />
				</div>
				<div class="inputfield">
					<label>bottomMaterialType</label><input type=text
						name=bottomMaterialType id=bottomMaterialType class="input" />
				</div>
				<div class="inputfield">
					<label>bottomLengths</label><input type=text name=bottomLengths
						id=bottomLengths class="input" />
				</div>
				<div class="inputfield">
					<label>hip</label><input type=text name=hip id=hip class="input" />
				</div>
				<div class="inputfield">
					<label>kneeLength</label><input type=text name=kneeLength
						id=kneeLength class="input" />
				</div>


			</div>

			<div class="inputfield">
				<label>comments</label><input type=text name=comments id=comments
					class="input" required />
			</div>
			<div class="inputfield">
				<label>expectedDate</label><input type=date name=expectedDate
					id=expectedDate class="input" required />
			</div>
			<div class="inputfield" style="display: none;">
				<label>tailorDressId</label><input type=text name=tailorDressId
					id=tailorDressId class="input" />
			</div>
			<div class="inputfield" style="display: none;">
				<label>tailorId</label><input type=text name=tailorId
					id=tailorId class="input" />
			</div>
			
			<div class="inputfield" id="customerId" style="display: none;">
				<label>customerId</label><input type=text name=customerId
					value="${user.userId }" id=customerId class="input" />
			</div>
			<div class="inputfield" id="delAreaIds" style="display: none;">
				<label>delArea</label><input type=text name=deliveryArea
					value="${delArea}" id=deliveryArea class="input" />
			</div>
			<input type=submit value="Submit" class="btn" onclick="showAlert()"  />

		</form>
	</div>

	<p style="color: blue;">${message}</p>
	<br>

	<a href="logout">Log Out</a>
</body>
</html>