package com.tech.blog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.entities.Message;

public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		
		HttpSession session = req.getSession();
		session.removeAttribute("currentUser");
		
		Message msg=new Message("Logout Successfully", "success", "alert-success");
		
		session.setAttribute("msg", msg);
		
		res.sendRedirect("login.jsp");
	}
}
