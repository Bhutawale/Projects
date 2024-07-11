<%@page import="com.tech.blog.entities.Posts"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.entities.Message"%>
<%@page import="com.tech.blog.entities.User"%>
<%@page errorPage="error_page.jsp"%>
<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
	response.sendRedirect("login.jsp");
}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile of <%=user.getName()%></title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/stylesheet.css">
<style type="text/css">
	
</style>
</head>
<body>

	<!-- navbar -->

	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<a class="navbar-brand" href="index.jsp"><span
			class="fa fa-delicious"></span>TechBlog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#"><span
						class="fa fa-book"></span>Learn Code With Satish <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item dropdown active"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <span class="fa fa-check-square-o"></span>Categories
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Programming Language</a> <a
							class="dropdown-item" href="#">Database Language</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Data Structure</a>
					</div></li>
				<li class="nav-item active"><a class="nav-link" href="#"><span
						class="fa fa-rocket"></span>Contact</a></li>

				<li class="nav-item active"><a class="nav-link" href="#"
					data-toggle="modal" data-target="#postModal"><span
						class="fa fa-hand-o-right"></span>Post Here</a></li>


			</ul>
			<ul class="navbar-nav mr-right">
				<li class="nav-item active"><a class="nav-link" href="#"
					data-toggle="modal" data-target="#profileModal"><span
						class="fa fa-user"></span><%=user.getName()%></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="LogoutServlet"><span class="fa fa-user-times"></span>Logout</a>
				</li>
			</ul>

		</div>
	</nav>


	<!-- navbar end -->

	<%
	HttpSession s = request.getSession();
	Message m = (Message) s.getAttribute("msg");
	if (m != null) {
	%>
	<div class="<%=m.getCssClass()%>" role="alert">
		<%=m.getContent()%>
	</div>

	<%
	s.removeAttribute("msg");
	}
	%>


	<!--main body of page -->

	<main>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="container mt-5">
					<h2>Post Categories</h2>
					</div>
					<div class="list-group mt-5">
						<a href="#" onclick="getAllPosts(0)"
							class="list-group-item list-group-item-action"
							>
							Posts (All)
						</a>

						<%
						PostDao pdao = new PostDao(ConnectionProvider.getConnection());

						ArrayList<Categories> clist = pdao.getAllCategories();

						for (Categories c : clist) {
						%>

						<a href="#" onclick="getAllPosts(<%=c.getCid()%>)"
							class="list-group-item list-group-item-action"><%=c.getCname()%></a>
						<%
						}
						%>
					</div>

				</div>
				<div class="col-md-8">

					<div class="container mt-5">

						<h2 class="ml-4">Posts :
						</h2>

						<div class="container" id="post-container"></div>


					</div>

				</div>
			</div>
		</div>
	</main>


	<!--main body of page end -->


	<!--profile  Modal -->
	<div class="modal fade" id="profileModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header primary-background text-white">
					<h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<img src="pics/<%=user.getProfile()%>" class="img-fluid"
							style="border-radius: 50%; max-width: 150px;"> <br>
						<h5 class="modal-title" id="exampleModalLabel">
							Welcome
							<%=user.getName()%></h5>

						<!-- table -->
						<div id="profile-details">
							<table class="table">

								<tr>
									<td>User-Id</td>
									<td><%=user.getId()%></td>
								</tr>
								<tr>
									<td>Name</td>
									<td><%=user.getName()%></td>
								</tr>
								<tr>
									<td>Email</td>
									<td><%=user.getEmail()%></td>
								<tr>
									<td>About</td>
									<td><%=user.getAbout()%></td>
								</tr>
								<tr>
									<td>Registration Date</td>
									<td><%=user.getRegdate()%></td>
								</tr>


							</table>
						</div>

						<!-- profile edit -->

						<div id="profile-edit" style="display: none;">

							<h2>Edit User Details</h2>

							<form action="EditServlet" method="post"
								enctype="multipart/form-data">

								<table class="table">

									<tr>
										<td>Id:</td>
										<td><%=user.getId()%></td>
									</tr>
									<tr>
										<td>Email:</td>
										<td><input class="form-control" type="email" name="email"
											value="<%=user.getEmail()%>"></td>
									</tr>
									<tr>
										<td>Name:</td>
										<td><input class="form-control" type="text" name="name"
											value="<%=user.getName()%>"></td>
									</tr>
									<tr>
										<td>About:</td>
										<td><textarea rows="5" cols="10" class="form-control"
												name="about">
											<%=user.getAbout()%>
										</textarea></td>
									</tr>
									<tr>
										<td>Password:</td>
										<td><input class="form-control" type="password"
											name="password" value="<%=user.getPassword()%>"></td>
									</tr>
									<tr>
										<td>Gender:</td>
										<td><%=user.getGender().toUpperCase()%></td>
									</tr>
									<tr>
										<td>New Profile Image:</td>
										<td><input type="file" class="form-control"
											name="profileimg"></td>
									</tr>


								</table>
								<div>
									<button type="submit"
										class="btn btn primary-background text-white">Save
										User Details</button>

								</div>

							</form>

						</div>

						<!-- profile edit end -->
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="edit-profile-button" type="button"
						class="btn primary-background text-white">Edit Details</button>
				</div>
			</div>
		</div>
	</div>

	<!-- profile modal end -->

	<!-- 	add post modol -->

	<!-- Button trigger modal -->


	<!-- Modal -->
	<div class="modal fade" id="postModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header primary-background text-white">
					<h5 class="modal-title" id="exampleModalLabel">
						TechBlog of
						<%=user.getName()%>, Please Post your Content.
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">


					<form action="PostServlet" method="post"
						enctype="multipart/form-data">

						<div class="form-group">
							<label>Select Category of your Content: </label> <select
								name="cid" class="primary-background text-white">
								<option selected="selected" disabled="disabled">--Select
									Category--</option>

								<%
								PostDao dao = new PostDao(ConnectionProvider.getConnection());

								ArrayList<Categories> list = dao.getAllCategories();

								for (Categories c : list) {
								%>

								<option value="<%=c.getCid()%>"><%=c.getCname()%></option>
								<%
								}
								%>
							</select>
						</div>

						<div class="form-group">
							<input type="text" name="title" placeholder="Enter Post Title">
						</div>

						<div class="form-group">
							<textarea name="content" rows="5" cols="50"
								placeholder="Enter Post Content"></textarea>
						</div>

						<div class="form-group">
							<textarea name="code" rows="5" cols="50"
								placeholder="Enter Programming Code (if any)"></textarea>
						</div>

						<div class="form-group">
							<label>Enter Image: </label> <input name="pic" type="file">
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn primary-background text-white">Post
						Content</button>
				</div>
				</form>
			</div>

		</div>

	</div>



	<!-- 	end add post modol -->



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


	<script>
		$(document).ready(function() {

			let editStatus = false;

			$("#edit-profile-button").click(function() {

				if (editStatus == false) {
					$("#profile-details").hide()

					$("#profile-edit").show()
					editStatus = true;
					$(this).text("Back")
				} else {
					$("#profile-details").show()

					$("#profile-edit").hide()
					editStatus = false;
					$(this).text("Edit Details")
				}
			})
		})
	</script>

	<!-- 	Loading posts through Ajax -->

	<script type="text/javascript">
	
		function getAllPosts(catid){
			$.ajax({
				url: "allPosts.jsp",
				data: {cid:catid},
				success: function(data,textStatus,jqXHR){
					$("#post-container").html(data);	
				}
			})
		}
		$(document).ready(function(){
			getAllPosts(0)
			
		})
	
	</script>


</body>
</html>