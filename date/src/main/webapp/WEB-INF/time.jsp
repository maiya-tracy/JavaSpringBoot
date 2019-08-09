<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/time.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1 class="green"><fmt:formatDate type="time" timeStyle="short" value="${time}" /></h1>
</body>
</html>