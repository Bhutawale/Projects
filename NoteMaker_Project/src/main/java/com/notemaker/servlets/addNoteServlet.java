package com.notemaker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notemaker.helper.ConnectionProvider;
import com.notemaker.note.Notes;


public class addNoteServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String author = request.getParameter("author");
			
			Notes note=new Notes();
			
			note.setNoteTitle(title);
			note.setNoteContent(content);
			note.setNoteAuthor(author);
			note.setNoteDate(new Date());
			
			Session session = ConnectionProvider.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.save(note);
			
			transaction.commit();
			
			//session.close();
			
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<h2 style='text-align: center;'>Note Added Successfully!!</h2>");
			writer.println("<h3 style='text-align: center;'><a href='add_note.jsp'>Go Back Add Another Note</a><h3>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
