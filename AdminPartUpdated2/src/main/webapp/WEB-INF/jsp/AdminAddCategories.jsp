<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add category</title>
</head>
<body>
<div class="wrapper">
<div class="title">
       DressCategory Form:
    </div>
    
    <div class="form">
<form method="get" action="AdminsubmitCategories">
<div class="inputfield">
<label>Category ID</label><input type=text name=categoryId id=categoryId class="input" required/></div>
<div class="inputfield">
<label>Category</label><div class="custom_select"><select name="category" id="category">
              <option value="">Select</option>
              <option value="Men">Men</option>
              <option value="Women">Women</option>
              <option value="Girl">Girl</option>
              <option value="Boy">Boy</option>
            </select>
            </div>
            </div>

</form>
</div>
<br/>
</div>

</body>
</html>