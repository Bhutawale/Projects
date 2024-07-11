<%@page import="com.tech.blog.dao.LikeDao"%>
<%@page import="com.tech.blog.entities.User"%>
<%@page import="com.tech.blog.entities.Posts"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<div class="row">
<%
	User user=(User)session.getAttribute("currentUser");

	PostDao dao=new PostDao(ConnectionProvider.getConnection());

	int cid=Integer.parseInt(request.getParameter("cid"));
	
	int uId=user.getId();
	
	List<Posts> list=null;
	
	if(cid==0)
	{
		list=dao.getAllPosts();
	}
	else
	{
		list=dao.getPostByCatId(cid);
	}
	if(list.size()==0)
	{
		out.println("<h3 class='display-3 text-center'>No Post in this category!!</h3>");
		return;
	}

	for(Posts p:list)
	{
%>

<div class="col-md-6 mt-2">
	<div class="card">
		<img class="card-img-top" src="pics/<%=p.getPpic()%>">
		<div class="card-body">
			
			<b><%= p.getPtitle() %></b>
			<hr>
			<p><%= p.getPcontent() %></p>
			<b>Code</b>
			<p><%= p.getPcode() %></p>
			<b>Posted on:</b>
			<p><%= p.getPdate() %></p>
		</div>
		
		<div class="card-footer text-center primary-background text-white">
			<a href="show_post.jsp?post_id=<%= p.getPid() %>" class="btn btn-outline-light btn-sm">Read More</a>
			
			</div>
	
	</div>
	

</div>
<% 
	}
%>
</div>

</body>
</html>