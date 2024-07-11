package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.LikeDao;
import com.tech.blog.helper.ConnectionProvider;

public class LikeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		String operation = req.getParameter("operation");
		
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		int pid = Integer.parseInt(req.getParameter("pid"));
		
		LikeDao dao =new LikeDao(ConnectionProvider.getConnection());
		
		if(operation.equals("like"))
		{
			boolean hasUserLikedPost = dao.hasUserLikedPost(uid, pid);
			{
				if(hasUserLikedPost)
				{
					out.println("already liked");
				}
				else
				{
					boolean f=dao.insertLike(uid, pid);
					out.println(f);
				}
			}
		} 
	}
}
