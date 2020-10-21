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
UserId : <input type=number name= userId /></br>
What was your First School?: <input type=text name=answer1 /><br/>
Your birth place?: <input type=text name=answer2 /><br/>
Your first friend?: <input type=text name=answer3 /><br/>
<input type=submit />
</form><br/>
<table border="1">
<thead><th>UserId</th><th>Answer 1</th><th>Answer 2</th><th>Answer 3</th></thead>
<c:forEach var="b" items="${secretQuestions}">
<tr><td>${b.userId}<td>${b.answer1}</td><td>${b.answer2}</td><td>${b.answer3}</td></tr>
</c:forEach>
</table>
</body>
</html>