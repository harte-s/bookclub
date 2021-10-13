<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<title>Book Club</title>
</head>
<body>
<a href="/logout">log out</a>
<a href="/dashboard">back to dashboard</a>
<h1>${book.title}</h1>
<br>

<h5>ID:</h5>
<p>${book.id}</p>
<h5>Author:</h5>
<p>${book.author}</p>
<h5>Number of Pages:</h5>
<p>${book.numPages}</p>
<h5>Posted By:</h5>
<p>${book.user.name}</p>
<h5>${book.user.name}'s thoughts:</h5>
<p>${book.thoughts}</p>

<c:choose>
	<c:when test="${book.user.id == user.id}">
		<a href="/edit/${book.id}" class="btn btn-warning mt-3">Edit Book Details</a>
		<a href="/delete/${book.id}" class="btn btn-danger mt-3">Delete this book</a>
	</c:when>
	<c:otherwise>
		<p style="color:red;">This is not your book</p>
	</c:otherwise>
</c:choose>

</body>
</html>