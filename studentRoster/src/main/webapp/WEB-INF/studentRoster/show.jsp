<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${song.title}" />
	</h1>
	<p>
		Artist:
		<c:out value="${song.artist}" />
	</p>
	<p>
		Rating:
		<c:out value="${song.rating}" />
	</p>
	<a href="/songs/${song.id}/edit">Edit Book</a>
	<form action="/songs/${song.id}" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete">
	</form>
</body>
</html>