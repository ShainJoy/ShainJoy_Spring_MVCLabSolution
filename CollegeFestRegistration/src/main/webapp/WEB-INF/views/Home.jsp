<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Debate Registration Management System</title>

<style>
.mBtn {
	background-color: #ff8533;
	border: none;
	padding: 32px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 24px;
	border-radius: 12px;
	color: white;
}
</style>

</head>
<body>
	<div class="container">
		<h3>Debate Registration Management System</h3>
		<hr>
		<p class="h4 mb-4">Home</p>

		<form>
			<!-- Add a button -->
			<a href="/CollegeFestRegistration/registration/addParticipant"
				class="mBtn"> Add Participant </a> <a
				href="/CollegeFestRegistration/registration/list" class="mBtn">
				List Participants </a>
		</form>
	</div>
</body>

</html>










