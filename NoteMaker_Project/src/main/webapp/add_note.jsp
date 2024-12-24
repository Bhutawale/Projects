<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Note</title>
<%@include file="bootstrap_js_css.jsp"%>
</head>
<body>
	
	<div class="container">
	<%@include file="navbar.jsp"%>
		<form action="addNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> <input required="required" type="text"
					class="form-control" id="title"
					placeholder="Enter your Note Title Here." name="title">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea required="required" name="content" class="form-control" id="content"
					placeholder="Enter your Note Here.">Content:
			</textarea>
			</div>
			<div class="form-group">
				<label for="author">Author</label> 
				<input required="required" type="text"
					class="form-control" id="title"
					placeholder="Enter Author Name Here." name="author">
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Add Note</button>
			</div>
		</form>
	</div>
</body>
</html>