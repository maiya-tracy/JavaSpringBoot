<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<h3>Submitted Info:</h3>
	<p>Name: <c:out value="${name}" /></p>
	<p>Dojo Location: <c:out value="${location}" /></p>
	<p>Favorite Language: <c:out value="${language}" /></p>
	<p>Comment: <c:out value="${comment}" /></p>
	<a class="btn btn-primary" href="/">Go Back</a>
</body>
</html>