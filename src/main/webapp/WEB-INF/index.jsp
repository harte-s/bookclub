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
    <br><br>
    <h1 class="text-center">Welcome</h1>
    <br>
    <div class="row">
        <div class="col border border-info ">
            <h2 class="text-center">Register</h2>
            <form:form action="/register" method="post" modelAttribute="newUser">
                <div class="form-group">
                    <label>Name:</label>
                    <form:input path="name" class="form-control"/>
                    <form:errors path="name" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <form:input path="email" class="form-control"/>
                    <form:errors path="email" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <form:password path="password" class="form-control"/>
                    <form:errors path="password" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label>Confirm Password:</label>
                    <form:password path="confirm" class="form-control"/>
                    <form:errors path="confirm" class="text-danger"/>
                </div>
                    <input type="submit" value="Register" class="btn btn-info mt-3">
			</form:form>
            <br>
        </div>

        <div class="col border border-info">
            <h2 class="text-center">Login</h2>
                <form:form action="/login" method="post" modelAttribute="newLogin">
                <div class="form-group">
                    <label>Email:</label>
                    <form:input path="email" class="form-control"/>
                    <form:errors path="email" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <form:password path="password" class="form-control"/>
                    <form:errors path="password" class="text-danger"/>
                </div>
                    <input type="submit" value="Register" class="btn btn-info mt-3">
			</form:form>
        </div>
    </div>
</body>
</html>