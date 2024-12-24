<%@page import="com.notemaker.note.Notes"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.notemaker.helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Notes</title>
<%@include file="bootstrap_js_css.jsp"%>
</head>
<body>
<div class="container">
	<%@include file="navbar.jsp"%>
	
	<%
		
		int id=Integer.parseInt(request.getParameter("id"));
		Session s=ConnectionProvider.getSession();
		Notes note=(Notes)s.get(Notes.class, id);
			
	%>
	
	<form action="Updateservlet" method="post">
		
		<input value="<%= note.getId() %>" name="id" hidden="true" >
	
			<div class="form-group">
				<label for="title">Note Title</label> 
				<input required="required" type="text"
					class="form-control" id="title"
					placeholder="Enter your Note Title Here." name="title" value="<%=note.getNoteTitle() %>">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea required="required" name="content" class="form-control" id="content"
					placeholder="Enter your Note Here.">Content:<%= note.getNoteContent() %>
			</textarea>
			</div>
			<div class="form-group">
				<label for="author">Author</label> 
				<input required="required" type="text"
					class="form-control" id="title"
					placeholder="Enter Author Name Here." name="author" value="<%= note.getNoteAuthor()%>">
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Update Note</button>
			</div>
		</form>
</div>
</body>
</html>