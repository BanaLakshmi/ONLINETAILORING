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
<div>
	<h2> Feedback(s)</h2> 
	<table border="1">
<c:forEach var="s" items="${feedbackList}">
<tr>
<td>${s.answer1}</td>
</tr>
</c:forEach>
</table>
<a href="logout">Log Out</a>
</div>
</body>
</html>