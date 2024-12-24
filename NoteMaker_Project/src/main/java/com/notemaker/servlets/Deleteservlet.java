package com.notemaker.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notemaker.helper.ConnectionProvider;
import com.notemaker.note.Notes;

public class Deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		Session session = ConnectionProvider.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Notes note = session.get(Notes.class, id);
		
		session.delete(note);
		
		transaction.commit();
		response.sendRedirect("show_notes.jsp");
	}

	

}
