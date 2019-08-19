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
	<div class="container">
		<div>
			<a class="btn btn-outline-info" href="/students">Home</a> <a
				class="btn btn-outline-info" href="/dorms">Dorms</a>
		</div>
		<h1>
			<c:out value="${dorm.name}" />
		</h1>

		<form action="/dorms/addStudent" method="post">
			<p>
				<label for="stu_id">Students: </label> <select class="form-control"
					name="stu_id" id="stu_id">
					<c:forEach items="${students}" var="student">
						<option value="${student.id}">${student.first_name}
							${student.last_name}</option>
					</c:forEach>
				</select> <input type="hidden" name="dorm_id" value="${dorm.id}" />
			</p>
			<input class="btn btn-outline-primary" type="submit" value="Submit" />
		</form>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dorm.students}" var="student">
					<tr>
						<td><c:out value="${student.first_name}" /></td>
						<td>
							<form action="/dorms/removeStudent" method="post">
								<p>
									<input type="hidden" name="dorm_id" value="${dorm.id}" /> <input
										type="hidden" name="stu_id" value="${student.id}" />
								</p>
								<input class="btn btn-outline-warning" type="submit"
									value="Submit" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>