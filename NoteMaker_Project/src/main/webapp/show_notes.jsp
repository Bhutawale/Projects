<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.notemaker.note.Notes"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.notemaker.helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Notes</title>
<%@include file="bootstrap_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<h2>All Notes</h2>


		<div class="row">
			<div class="col-12">

				<%
				Session s = ConnectionProvider.getSession();

				Query query = s.createQuery("from Notes");
				List<Notes> notesList = query.list();
				for (Notes n : notesList) {
				%>


				<div class="card mt-3" >
					<img class="card-img-top"  style="max-height: 100px; max-width: 100px"
					src="img/notebook.png" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=n.getNoteTitle() %></h5>
						<p class="card-text"><%=n.getNoteContent() %></p>
						<h6 class="card-title">Author: <%=n.getNoteAuthor() %></h6>
						<h6 style="text-align: right;" class="card-title">Note Created/Updated on: <%=n.getNoteDate() %></h6>
						<a href="Deleteservlet?id=<%=n.getId() %>" class="btn btn-danger">Delete Note</a>
						<a href="edit.jsp?id=<%=n.getId() %>" class="btn btn-success">Update Note</a>
					</div>
				</div>
				
				<%
				}
				%>

			</div>
		</div>
	</div>
</body>
</html>