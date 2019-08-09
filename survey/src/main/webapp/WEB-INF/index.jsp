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
	<c:out value="${error}" />
	<div id="wrapper">
		<form action='/submit' method='post'>
			<div class="form-group">
				<label for="your_name">Your Name:</label>
				<input type="text" class="form-control" id="your_name" name="your_name">
			</div>
			<div class="form-group">
				<label for="location">Dojo Location:</label>
				<select class="form-control" id="location" name='location'>
					<option>San Jose</option>
					<option>Berkeley</option>
					<option>Burbank</option>
					<option>Chicago</option>
					<option>Orange County</option>
				</select>
			</div>
			<div class="form-group">
				<label for="language">Favorite Language:</label>
				<select class="form-control" id="language" name='language'>
					<option>Python</option>
					<option>CSS</option>
					<option>C++</option>
					<option>Java</option>
					<option>JavaScript</option>
					<option>HTML</option>
				</select>
			</div>
			<div class="form-group">
				<label for="comment">Comment (optional):</label>
				<textarea class="form-control" id="comment" name="comment" rows="3"></textarea>
			</div>
			<input type='submit' class="btn btn-primary" value='Button'>
		</form>
	</div>
</body>
</html>