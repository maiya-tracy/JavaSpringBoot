<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/date.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1 class="blue"><fmt:formatDate pattern = "EEEE', the 'dd' of 'MMMM, yyyy" value="${date}" /></h1>
</body>
</html>