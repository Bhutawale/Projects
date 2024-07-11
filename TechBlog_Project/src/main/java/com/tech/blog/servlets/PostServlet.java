package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Posts;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

@MultipartConfig
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		int cid = Integer.parseInt(req.getParameter("cid"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String code = req.getParameter("code");
		Part part = req.getPart("pic");
		String pic = part.getSubmittedFileName();

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("currentUser");
		int uid = user.getId();

		Posts post = new Posts(title, content, code, pic, cid, uid);

		PostDao pdao = new PostDao(ConnectionProvider.getConnection());

		if (pdao.savePost(post)) {
			generateAlert(out, "Success!", "Post Submitted Successfully.", "success", "profile.jsp");
		} else {
			generateAlert(out, "Error!", "Something went wrong.", "error", "profile.jsp");
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
