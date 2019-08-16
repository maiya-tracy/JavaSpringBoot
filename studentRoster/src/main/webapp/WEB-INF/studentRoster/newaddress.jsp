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
	<h1>New Address</h1>
	<form:form action="/contacts" method="post" modelAttribute="contact">
		<p>
			<form:label path="student">Student</form:label>
			<form:errors path="student" />
			<form:select class="form-control" path="student">
				<c:forEach items="${students}" var="student">
					<option value="${student.id}">${student.first_name} ${student.last_name}</option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="address">Address</form:label>
			<form:errors path="address" />
			<form:input path="address" />
		</p>
		<p>
			<form:label path="city">City</form:label>
			<form:errors path="city" />
			<form:input path="city" />
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state" />
			<form:input path="state" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>