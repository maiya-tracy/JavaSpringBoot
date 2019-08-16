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
	<a class="btn btn-outline-info" href="/student/new">New Student</a>
	<a class="btn btn-outline-info" href="/contact/new">New Contact</a>

	<h1>All Students</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.first_name} ${student.last_name}" /></td>
					<td><c:out value="${student.age}" /></td>
					<td><c:out value="${student.address.address}" /></td>
					<td><c:out value="${student.address.city}" /></td>
					<td><c:out value="${student.address.state}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>