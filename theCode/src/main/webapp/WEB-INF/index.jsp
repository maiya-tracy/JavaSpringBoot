<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${error}" />
	<form action="/login" method="POST">
		<input type="text" name="thecode" placeholder="What is the code?">
		<button>Try Code</button>
	</form>
</body>
</html>