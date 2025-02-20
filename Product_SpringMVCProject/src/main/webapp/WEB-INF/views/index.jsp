<!doctype html>
<%@page import="com.productApp.Model.Product"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Product App</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product CRUD
					Application in Spring MVC</h1>

				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Serial No.</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Product Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					 <%
                List<Product> allProducts = (List<Product>) request.getAttribute("allProducts");
                if (allProducts != null) {
                    for (Product p : allProducts) {
            %>
            <tr>
                <td><%= "TechOnlyId"+p.getPid() %></td>
                <td><%= p.getName() %></td>
                <td><%= p.getDescription() %></td>
                <td> &#x20B9; <%=p.getPrice() %></td>
                <td><a href="deleteProduct/<%=p.getPid()%>"><i class="fa fa-eraser text-danger" style="font-size:24px"></i></a>
                <td><a href="updateProduct/<%=p.getPid()%>"><i class="fa fa-edit text-warning" style="font-size:24px"></i></a>
                
                </td>
                
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4">No products available.</td>
            </tr>
            <%
                }
            %>
					</tbody>
				</table>
				<div class="container text-center">
				<a href="addProductForm"><button class="btn btn-success">Add Product</button></a>
				</div>
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