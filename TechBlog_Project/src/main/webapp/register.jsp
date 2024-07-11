<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/stylesheet.css">

<style type="text/css">
.banner-background {
	clip-path: polygon(20% 0%, 80% 0%, 100% 0, 100% 91%, 65% 100%, 33% 91%, 0 100%, 0 0
		);
}
</style>

</head>
<body>
	<%@ include file="navbar.jsp"%>

	<main class="primary-background banner-background" style="padding-bottom: 80px;" 
		style="height: 70vh">
		<div class="container">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-header primary-background text-white text-center">
							<span class="fa fa-vcard-o fa-3x"></span><br>
							<h5>Register Here</h5>
						</div>
						<div class="card-body">

							<form action="RegisterServlet" method="post">

								<div class="form-group">
									<label for="exampleInputName">Name</label> <input
										type="text" class="form-control" id="exampleInputName"
										placeholder="Enter name" name="name">
									
								</div>

								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label> 
									<input name="email"
										type="email" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" placeholder="Enter email">
									<small id="emailHelp" class="form-text text-muted">We'll
										never share your email with anyone else.</small>
								</div>


								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" class="form-control"
										id="exampleInputPassword1" placeholder="Password" name="password">
								</div>
								
								<div class="form-group">
									<label>Select Gender</label> &nbsp;&nbsp;
									<input
										type="radio" name="gender" value="Male">Male
										&nbsp;&nbsp;
										<input type="radio" name="gender" value="Female">Female
								</div>
								
								<div class="form-group">
									<label>About</label>
									<textarea class="form-control" name="about" rows="2" cols="50" placeholder="Something about yourself">
										
									</textarea>
								</div>


								<div class="form-check text-center">
									<input name="check" type="checkbox" class="form-check-input"
										id="exampleCheck1"> <label class="form-check-label"
										for="exampleCheck1">Agree terms and conditions</label>
								</div>

								<div class="button text-center">
								<button type="submit"
									class="btn btn-light primary-background text-white">Register</button>
									</div>
							</form>


						</div>
						<div class="card-footer primary-background"></div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>