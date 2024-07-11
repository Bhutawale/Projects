<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/stylesheet.css">

<style type="text/css">
	.banner-background
	{
		clip-path: polygon(20% 0%, 80% 0%, 100% 0, 100% 91%, 65% 100%, 33% 91%, 0 100%, 0 0);
	}
</style>

</head>
<body>

	<!-- navigation bar -->
	<%@include file="navbar.jsp"%>

	<!-- banner -->

	<div class="container-fluid p-0 m-0 banner-background">
		<div class="jumbotron jumbotron-fluid primary-background text-white">
			<div class="container">
				<h3 class="display-3">Welcome to TechBlog</h3>
				<h6>Programming language Blog.</h6>
				<button class="btn btn-outline-light btn-lg">
					<span class="fa fa-rupee fa-spin"></span>Start Now It's Free
				</button>
				<a href="login.jsp" class="btn btn-outline-light btn-lg">
					<span class="fa fa-hand-o-up fa-spin"></span>Login
				</a>
			</div>
		</div>
	</div>


	<!-- cards -->
	<div class="container">
		<div class="row mb-2" >
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">SQL Programming</h5>
						<p class="card-text">SQL (Structured Query Language) is used to perform operations on the records stored in the database, such as updating records, inserting records, deleting records, creating and modifying database tables, views, etc.</p>
						<a href="#" class="btn btn-outline-light primary-background">Read More</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<p class="card-text">Java is a programming language and a platform. Java is a high level, robust, object-oriented and secure programming language.

Java was developed by Sun Microsystems (which is now the subsidiary of Oracle) in the year 1995. James Gosling is known as the father of Java. Before Java, its name was Oak. Since Oak was already a registered company, so James Gosling and his team changed the name from Oak to Java.</p>
						<a href="#" class="btn btn-outline-light primary-background">Read More</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">JSP</h5>
						<p class="card-text">JSP technology is used to create web application just like Servlet technology. It can be thought of as an extension to Servlet because it provides more functionality than servlet such as expression language, JSTL, etc.

A JSP page consists of HTML tags and JSP tags. The JSP pages are easier to maintain than Servlet because we can separate designing and development. It provides some additional features such as Expression Language, Custom Tags, etc.</p>
						<a href="#" class="btn btn-outline-light primary-background">Read More</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Hibernate</h5>
						<p class="card-text">Hibernate is a Java framework that simplifies the development of Java application to interact with the database. It is an open source, lightweight, ORM (Object Relational Mapping) tool. Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.</p>
						<a href="#" class="btn btn-outline-light primary-background">Read More</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Android Studio Tutorial</h5>
						<p class="card-text">Android is a software package and linux based operating system for mobile devices such as tablet computers and smartphones.

It is developed by Google and later the OHA (Open Handset Alliance). Java language is mainly used to write the android code even though other languages can be used.</p>
						<a href="#" class="btn btn-outline-light primary-background">Read More</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Struts</h5>
						<p class="card-text">The struts 2 framework is used to develop MVC-based web application.

The struts framework was initially created by Craig McClanahan and donated to Apache Foundation in May, 2000 and Struts 1.0 was released in June 2001.</p>
						<a href="#" class="btn btn-outline-light primary-background">Read More</a>
					</div>
				</div>
			</div>
		</div>
	</div>


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