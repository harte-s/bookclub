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

<title>Dashboard</title>
</head>
<body>
<h1>Welcome, ${user.name}!</h1>
<a href="/logout">log out</a>
<br>
<a href="/newbook" class="btn btn-info mt-3">+ Add a new book</a>
<table class="table table-striped table-warning">
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Posted By</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="book" items="${allBooks}" >
		<tr>
			<td><c:out value="${book.id}" ></c:out></td>
			<td><a href="/book/${book.id}"><c:out value="${book.title}" ></c:out></a></td>
			<td><c:out value="${book.author}"></c:out></td>
			<td><c:out value="${book.user.name}"></c:out></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
 
</body>
</html>