<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Student</h1>
<form:form action="/students" method="post" modelAttribute="student">
    <p>
        <form:label path="first_name">First Name</form:label>
        <form:errors path="first_name"/>
        <form:input path="first_name"/>
    </p>
    <p>
        <form:label path="last_name">Last Name</form:label>
        <form:errors path="last_name"/>
        <form:input path="last_name"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>     
        <form:input type="number" path="age"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>  
</body>
</html>