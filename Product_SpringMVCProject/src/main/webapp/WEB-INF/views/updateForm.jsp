<!doctype html>
<%@page import="org.hibernate.Session"%>
<%@page import="com.productApp.Model.Product"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Product</title>
</head>

<body>

	<%
		Product product=(Product)request.getAttribute("productById");
		String path=request.getContextPath();
	%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center md-3">Update Product Details</h1>

				<form action="<%= path %>/saveProduct" method="post">
				<input type="hidden" name="pid" value="<%= product.getPid() %>">
				
					<div class="form-group">
						<label>Product Name</label> 
						<input
							type="text" 
							class="form-control" 
							id="productName"
							name="name"
							placeholder="Enter Product Name"
							value="<%= product.getName() %>"> 
					</div>
					<div class="form-group">
						<label>Product Description</label> 
						<textarea
							class="form-control" 
							id="productDesc"
							name="description"
							rows="5"
							placeholder="Describe Your Product"><%= product.getDescription() %></textarea>
					</div>
					<div class="form-group">
						<label>Product Price</label> 
						<input
							type="number" 
							class="form-control" 
							id="productPrice"
							name="price"
							placeholder="Your Product Price"
							value="<%= product.getPrice() %>">
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-warning">Update</button>
					</div>
				</form>

			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
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