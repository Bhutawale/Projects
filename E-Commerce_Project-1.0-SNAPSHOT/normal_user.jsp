
<%@page import="com.ecommerce.entities.User"%>
<%
    HttpSession sess=request.getSession();
    User u2=(User)sess.getAttribute("currentUser");
    
    if(u2==null)
    {
        sess.setAttribute("error_message", "Please Login First.");
        response.sendRedirect("login.jsp");
        return;
    }
    else
    {
        if(u2.getUserType().equals("admin"))
        {
            sess.setAttribute("error_message", "You are Admin User. Cannot access Normal User.");
            response.sendRedirect("admin_user.jsp");
            return;
        }
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Normal User Page</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        <%@include file="components/message.jsp" %>
        <h1>Normal User</h1>
        <%@include file="components/common_modal.jsp" %>
        <%@include file="components/footer.jsp" %>
    </body>
</html>
