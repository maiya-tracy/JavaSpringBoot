<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<a class="btn btn-outline-info" href="/">Home</a>
	<a class="btn btn-outline-info" href="/songs/new">New Song</a>
	<a class="btn btn-outline-info" href="/search/TopTen">Top Ten</a>
	<form action="/search" method="post">
		<input type="text" name="searchArtist" />
		<button class="btn btn-outline-primary">Search Artists</button>
	</form>

	<h1>All Songs</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td><c:out value="${song.title}" /></td>
					<td><c:out value="${song.artist}" /></td>
					<td><c:out value="${song.rating}" /></td>
					<td><a class="btn btn-outline-warning"
						href="/songs/${song.id}/edit">Edit</a> |
						<form style="display: inline-block;" action="/songs/${song.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> <input style="display: inline-block;" class="btn btn-outline-danger" type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>