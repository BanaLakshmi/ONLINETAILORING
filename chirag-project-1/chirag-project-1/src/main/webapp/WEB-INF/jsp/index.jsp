<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hello world
<form action="add">
BID: <input type=text name=bid /><br/>
Name: <input type=text name=bname /><br/>
City: <input type=text name=bcity /><br/>
<input type=submit />
</form><br/>
<table border="1">
<thead><th>Branch ID</th><th>Name</th><th>City</th></thead>
<c:forEach var="b" items="${branches}">
<tr><td>${b.bid }</td><td>${b.bname }</td><td>${b.bcity }</td></tr>
</c:forEach>
</table>
</body>
</html>