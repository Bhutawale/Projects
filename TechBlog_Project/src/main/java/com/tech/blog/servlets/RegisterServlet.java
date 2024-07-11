package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;


public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String check = req.getParameter("check");
		if(check!=null)
		{
			
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String gender = req.getParameter("gender");
			String about = req.getParameter("about");
			
			if(name!=null && email!=null && password!=null && gender!=null)
			{	
				
				User user=new User(name, email, password, gender, about);
			
				UserDao dao=new UserDao(ConnectionProvider.getConnection());
				
				
				if(dao.saveUser(user))
				{
                    generateAlert(out, "Success!", "User Registered Successfully.", "success", "login.jsp");
                } 
				else 
				{
                    generateAlert(out, "Error!", "Something went wrong. User not registered.", "error", "register.jsp");
                }	
            } 
			else 
			{
                generateAlert(out, "Error!", "Please fill all the details. User not registered.", "error", "register.jsp");
            }
        }
		else 
		{
            generateAlert(out, "Warning!", "Please agree to terms and conditions to continue and register yourself.", "warning", "register.jsp");
        }
    }

    private void generateAlert(PrintWriter out, String title, String message, String icon, String redirectURL) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title + "</title>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<script>");
        out.println("Swal.fire({");
        out.println("  title: '" + title + "',");
        out.println("  text: '" + message + "',");
        out.println("  icon: '" + icon + "',");
        out.println("  confirmButtonText: 'OK'");
        out.println("}).then((result) => {");
        out.println("  if (result.isConfirmed) {");
        out.println("    window.location = '" + redirectURL + "';");
        out.println("  }");
        out.println("});");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }
}
