<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contacts Page</title>

<!-- adding Bootstrap CSS CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">First</th>
				<th scope="col">Last</th>
				<th scope="col">Handle</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="contact" items="${allContacts}"></c:forEach>

			<tr>
				<th scope="row">1</th>
				<td>${contact.contactName}</td>
				<td>${contact.contactNumber}</td>
				<td>${contact.contactEmail}</td>
			</tr>

		</tbody>
	</table>






	<!-- adding jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<!-- adding bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
