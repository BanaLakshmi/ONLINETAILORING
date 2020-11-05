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
<div class="wrapper">
<div class="title">
     DRESS TYPE FORM
    </div>
    <div class="form">
<form method="get" action="addDressType">
<div class="inputfield">
					<label>Category</label> <select name="categoryId" id="categoryId"
						required>
						<option></option>
						<c:forEach items="${dressCategorylist}" var="category">
							<option value="${category.categoryId}">${category.dressCategoery}</option>
						</c:forEach>
					</select><br />
				</div>
				
				
				
<div class="inputfield">
<label> Dress Kind : </label><input type=text name=dressKind id=dressKind class="input" /></div>
 
<div class="inputfield">
<label> Dress Type : </label><input type=text name=dressType id=dressType class="input" required /></div>
<div class="inputfield">
<input type=submit value="Submit" class="btn" />
</div>
</form>
</div>
<br>
<p style="color:red;">${message }</p><br>
	</div>	
</body>
</html>