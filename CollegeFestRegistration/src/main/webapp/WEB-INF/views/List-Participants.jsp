<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Books Directory</title>
</head>

<body>

	<div class="container">

		<h3>Participants Register</h3>
		<hr>

		<!-- Add a search form -->

		<form action="/CollegeFestRegistration/registration/search"
			class="form-inline">
			<!-- Add a button -->
			<a href="/CollegeFestRegistration/registration/addParticipant"
				class="btn btn-primary btn-sm mb-3"> Add Participant </a> <input
				type="search" name="name" placeholder="Name"
				class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
				name="department" placeholder="Department"
				class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
				name="country" placeholder="Country"
				class="form-control-sm ml-5 mr-2 mb-3" />

			<button type="submit" class="btn btn-success btn-sm ml-5 mb-3">Search</button>

		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="participant">
					<tr>
						<td><c:out value="${participant.name}" /></td>
						<td><c:out value="${participant.department}" /></td>
						<td><c:out value="${participant.country}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CollegeFestRegistration/registration/Update?studentId=${participant.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/CollegeFestRegistration/registration/delete?studentId=${participant.id}"
							class="btn btn-danger btn-sm ml-2"
							onclick="if (!(confirm('Are you sure you want to delete this participant?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

		<hr>
		<a href="/CollegeFestRegistration">Back to Home</a>
	</div>

</body>
</html>



