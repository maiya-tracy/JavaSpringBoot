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
	<div class="container">
    <div class="header row">
      <label for="your_gold">Your Gold:</label>
      <input id='your_gold' disabled type="text" value=<c:out value="${request.session.total_gold}"/>>
    </div>
    <div class="boxes row">
      <div class="farm border col-3">
        <form action="/ninja_gold/process_money/farm" method="post">
          <h3>Farm</h3>
          <h6>(earns 10-20 golds)</h6>
          <input style="btn btn-outline-primary" type="submit" value="Find Gold!">
        </form>
      </div>
      <div class="cave border col-3">
        <form action="/ninja_gold/process_money/cave" method="post">
          <h3>Cave</h3>
          <h6>(earns 5-10 golds)</h6>
          <input style="btn btn-outline-primary" type="submit" value="Find Gold!">
        </form>
      </div>
      <div class="house border col-3">
        <form action="/ninja_gold/process_money/house" method="post">
          <h3>House</h3>
          <h6>(earns 2-5 golds)</h6>
          <input style="btn btn-outline-primary" type="submit" value="Find Gold!">
        </form>
      </div>
      <div class="casino border col-3">
        <form action="/ninja_gold/process_money/casino" method="post">
          <h3>Casino</h3>
          <h6>(earns/takes 0-50 golds)</h6>
          <input style="btn btn-outline-primary" type="submit" value="Find Gold!">
        </form>
      </div>
    </div>
    <div class="footer row">
      <label for="activities_box">Activities: </label>
      
    </div>
    <form action="/ninja_gold/clear" method="POST"><input type="submit" value="Clear game" class="btn btn-outline-danger"></form>
  </div>
</body>
</html>