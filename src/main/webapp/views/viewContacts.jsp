<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contacts Page</title>

<!-- adding Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
</head>

<body>
	<!-- 	table starts -->
	<div class="container text-center">
		<div class="bg-primary">
			<h1 class="text-white">All Contacts</h1>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Contact Id</th>
					<th scope="col">Contact Name</th>
					<th scope="col">Contact Number</th>
					<th scope="col">Contact Email</th>
					<th scope="col">Created_Date</th>
					<th scope="col">Updated_Date</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="contact" items="${allContacts}">

					<tr>
						<td>${contact.contactId}</td>
						<td>${contact.contactName}</td>
						<td>${contact.contactNumber}</td>
						<td>${contact.contactEmail}</td>
						<td>${contact.createdDate}</td>
						<td>${contact.updatedDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 	table ends -->




	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
