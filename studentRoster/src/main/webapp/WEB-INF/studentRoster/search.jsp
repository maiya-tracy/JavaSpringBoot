<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		Songs by artist:
		<c:out value="${artist}" />
	</p>
	<form action="/search" method="post">
		<input type="text" name="searchArtist" />
		<button class="btn btn-outline-primary">Search Artists</button>
	</form>
	<a class="btn btn-outline-info" href="/dashboard">Dashboard</a>
	<h1>All Songs</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td><c:out value="${song.title}" /></td>
					<td><c:out value="${song.artist}" /></td>
					<td><c:out value="${song.rating}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>