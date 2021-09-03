<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Contacts Page</title>
<!-- adding Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
<style>
.row {
	margin-bottom: 20px;
	margin-top: 20px;
}

.div-relative {
	position: relative;
	margin: 1rem 0;
}

.heading-absolute {
	position: absolute;
	top: 0.3rem;
	left: 2rem;
	opacity: 0.7;
}

.form-input:focus ~ .heading-absolute {
	color: red;
	top: -2rem;
	left: 0rem;
	opacity: 1;
}
</style>
</head>
<body>

	<div class="container text-center">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h1 class="py-2">Save Contact Here</h1>
			</div>
			<h5 class="text-success">${success}</h5>
			<h5 class="text-danger">${error}</h5>
			<div class="card-body">

				<!-- Form Starts -->
				<form:form class="form"
					action="save_contact?contactId=${contact.contactId}" method="POST"
					modelAttribute="contact">
					<!-- 1st row -->
					<div class="row align-items-center justify-content-center">

						<div class="col-md-6 div-relative">
							<form:input type="text" class="form-control form-input"
								id="contactName" name="contactName" path="contactName" />
							<h5 class="heading-absolute">Contact Name</h5>
							<form:errors path="contactName" class="error" />
						</div>

					</div>
					<!-- 2th row -->
					<div class="row align-items-center justify-content-center">

						<div class="col-md-6 div-relative">
							<input type="email" name="contactEmail" id="contactEmail"
								class="form-control form-input" />
							<h5 class="heading-absolute">Contact Email</h5>
							<form:errors path="contactEmail" class="error" />
						</div>

					</div>
					<!-- 3rd row -->
					<div class="row align-items-center justify-content-center">

						<div class="col-md-6 div-relative">
							<form:input type="number" class="form-control form-input"
								id="contactNumber" name="contactNumber" path="contactNumber" />
							<h5 class="heading-absolute">Contact Number</h5>
							<form:errors path="contactNumber" class="error" />
						</div>

					</div>
					<button type="submit" class="btn btn-primary">Save</button>
				</form:form>
				<!-- Form Ends -->
			</div>
			<div class="card-footer text-white">
				<a href="viewAllcontacts" class="btn btn-primary">View All
					Contacts</a>
			</div>
		</div>
	</div>





	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>