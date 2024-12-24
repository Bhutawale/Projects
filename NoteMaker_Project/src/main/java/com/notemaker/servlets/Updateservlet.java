package com.notemaker.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notemaker.helper.ConnectionProvider;
import com.notemaker.note.Notes;

public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
			String title=request.getParameter("title");
			String content = request.getParameter("content");
			String author = request.getParameter("author");
			int id=Integer.parseInt(request.getParameter("id"));
			
			Session session = ConnectionProvider.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			Notes note = session.get(Notes.class, id);
			
			note.setNoteTitle(title);
			note.setNoteContent(content);
			note.setNoteAuthor(author);
			note.setNoteDate(new Date());
			
			session.save(note);
			
			transaction.commit();
			
			response.sendRedirect("show_notes.jsp");
	}

}
