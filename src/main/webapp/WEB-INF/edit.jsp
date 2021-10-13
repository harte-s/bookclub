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
<h2>Please edit book details :</h2>
<form:form action="/processupdate/${book.id}" method="post" modelAttribute="book">
	<input type="hidden" name="_method" value="put">
	<form:hidden path="user" value="${book.user.id}"/>
	
    <p>
        <form:label path="title">Title:</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="author">Author:</form:label>
        <form:errors path="author"/>
        <form:input path="author"/>
    </p>
    <p>
        <form:label path="numPages">Number of Pages:</form:label>
        <form:errors path="numPages"/>     
        <form:input type="number" path="numPages"/>
    </p>  
    <p>
        <form:label path="thoughts">Thoughts:</form:label>
        <form:errors path="thoughts"/>     
        <form:textarea path="thoughts"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>   
</body>
</html>