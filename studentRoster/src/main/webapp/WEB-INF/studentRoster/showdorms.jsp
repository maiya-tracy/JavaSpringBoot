<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<div class="container">
		<div>
			<a class="btn btn-outline-info" href="/students">Home</a> <a
				class="btn btn-outline-info" href="/dorms">Dorms</a>
		</div>
		<div>
			<a class="btn btn-outline-info" href="/student/new">New Student</a> <a
				class="btn btn-outline-info" href="/contact/new">New Contact</a> <a
				class="btn btn-outline-info" href="/dorm/new">New Dorm</a>
		</div>


		<h1>All Dorms</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Number of Students</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dorms}" var="dorm">
					<tr>
						<td><c:out value="${dorm.name}" /></td>
						<td><c:out value="${fn:length(dorm.students)}" /></td>
						<td><a class="btn btn-outline-warning"
							href="/dorms/${dorm.id}">View Dorm</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>