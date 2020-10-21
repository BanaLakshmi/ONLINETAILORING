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
UserId: <input type=text name=userId /><br/>
Password: <input type=text name=password /><br/>
FirstName: <input type=text name=firstName /><br/>
LastName: <input type=text name=lastName /><br/>
DateOfBirth: <input type=date name=dob /><br/>
Gender: <input type=text name=gender /><br/>
ContactNo: <input type=text name=contactNo /><br/>
Email: <input type=text name=email /><br/>
UserCategory: <input type=text name=userCategory /><br/>
SecretQuestions: <input type=text name=secretQuestions /><br/>

<input type=submit />
</form><br/>
<table border="1">
<thead><th>UserID</th><th>Password</th><th>FirstName</th><th>LastName</th><th>DateOFBirth</th>
<th>Gender</th><th>ContactNo</th><th>Email</th><th>UserCategory</th><th>SecretQuestions</th></thead>
<c:forEach var="u" items="${users}">
<tr><td>${u.userId }</td><td>${u.password }</td><td>${u.firstName }</td><td>${u.lastName }</td><td>${u.dob }</td><td>${u.gender }</td><td>${u.contactNo }</td>
<td>${u.email }</td><td>${u.userCategory }</td><td>${u.secretQuestions }</td></tr>
</c:forEach>
</table>
</body>
</html>

