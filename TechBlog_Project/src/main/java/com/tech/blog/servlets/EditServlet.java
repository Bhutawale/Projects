package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.ProfilePicHelper;

@MultipartConfig
public class EditServlet extends HttpServlet  
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String about = req.getParameter("about");
		String password = req.getParameter("password");
		Part part = req.getPart("profileimg");
		String imageName = part.getSubmittedFileName();
		
		HttpSession session = req.getSession();
		User user =(User) session.getAttribute("currentUser");
		
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setAbout(about);
		String oldpic=user.getProfile();
		user.setProfile(imageName);
		
		UserDao udao=new UserDao(ConnectionProvider.getConnection());
		
		boolean updateUser = udao.updateUser(user);
		
		if(updateUser)
		{
			String patholdpic=req.getRealPath("/")+"pics"+File.separator+oldpic;
		
			String path=req.getRealPath("/")+"pics"+File.separator+user.getProfile();
			
			if(!oldpic.equals("default.png"))
			{
				ProfilePicHelper.deleteFile(patholdpic);
			}
				if(ProfilePicHelper.saveFile(part.getInputStream(), path))
				{
					Message msg=new Message("Profile Updated Successfully", "success","alert alert-success");
					
					session.setAttribute("msg", msg);
					
					res.sendRedirect("profile.jsp");
				}
				else
				{
					Message msg=new Message("Profile Not Updated", "error","alert alert-danger");
					
					session.setAttribute("msg", msg);

					res.sendRedirect("profile.jsp");

				}
			
		}
		else
		{
			Message msg=new Message("Profile Not Updated", "error","alert alert-danger");
			
			session.setAttribute("msg", msg);

			res.sendRedirect("profile.jsp");
		}
		
	}
}
