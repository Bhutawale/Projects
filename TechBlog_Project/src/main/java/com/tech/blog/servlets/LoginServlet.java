package com.tech.blog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDao userDao=new UserDao(ConnectionProvider.getConnection());
		
		User u = userDao.getUserByEmailAndPassword(email, password);
		
		if(u == null)
		{
			//error password/email mismatch
			//out.println("Invalid User Details. Please type Correct Details");
			
			Message msg=new Message("Invalid Details!!", "error","alert alert-danger");
			HttpSession session = req.getSession();
			session.setAttribute("msg", msg);
			
			res.sendRedirect("login.jsp");
		}
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("currentUser", u);
			res.sendRedirect("profile.jsp");
		}	
	}
}
