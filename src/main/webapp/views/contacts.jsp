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
				<form:form class="form" action="save_contact" method="POST"
					modelAttribute="contact">
					<!-- 1st row -->
					<div class="row">
						<div class="col-2">
							<label for="contactName">Contact Name</label>
						</div>
						<div class="col-5">
							<form:input type="text" class="form-control" id="contactName"
								name="contactName" path="contactName" required="required" />
						</div>
						<div class="col-5">
							<span class="text-danger">Please Enter Your Correct Name</span>
						</div>
					</div>
					<!-- 2th row -->
					<div class="row">
						<div class="col-2">
							<label for="contactEmail">Contact Email</label>
						</div>
						<div class="col-5">
							<input type="email" name="contactEmail" id="contactEmail"
								class="form-control" required="required" />
						</div>
						<div class="col-5">
							<span class="text-danger">Please Enter Your Email</span>
						</div>
					</div>
					<!-- 3rd row -->
					<div class="row">
						<div class="col-2">
							<label for="contactNumber">Contact Number</label>
						</div>
						<div class="col-5">
							<form:input type="number" class="form-control" id="contactNumber"
								name="contactNumber" path="contactNumber" required="required" />
						</div>
						<div class="col-5">
							<span class="text-danger">Please Enter Your Contact Number</span>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
				</form:form>
				<!-- Form Ends -->
			</div>
			<div class="card-footer text-white">
				<a href="viewAllcontacts" class="btn btn-primary">View All Contacts</a>
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