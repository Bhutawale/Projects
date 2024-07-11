
<%@page import="com.ecommerce.entities.User"%>
<%

    HttpSession se = request.getSession();
    User u1 = (User) se.getAttribute("currentUser");

%>

<nav class="navbar navbar-expand-lg navbar-light navbar-background theme-color">
    <div class="container">
        <a class="navbar-brand" href="index.jsp"><span class="fa fa-cart-plus"></span> E-Commerce</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp"><span class="fa fa-home"></span> Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="fa fa-sort"></span> Categories 
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <%                if (u1 == null) {
                %>

                <li class="nav-item active">
                    <a class="nav-link" href="#"><i class="fa fa-cart-plus cart-items" data-toggle="modal" data-target="#cart"> (0) </i></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="login.jsp"><span class="fa fa-user"></span> Login</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="register.jsp"><span class="fa fa-user-plus"></span> Register</a>
                </li>

                <%
                } else {
                %>
                
                 <li class="nav-item active">
                    <a class="nav-link" href="#"><i class="fa fa-cart-plus cart-items" data-toggle="modal" data-target="#cart"> (0) </i></a>
                </li>
                
                <li class="nav-item active">
                    <a class="nav-link" href="<%= u1.getUserType().equals("admin")?"admin_user.jsp":"normal_user.jsp" %>"></a> 
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="admin_user.jsp">||&nbsp;&nbsp;<span class="fa fa-user"></span> Welcome : <%= u1.getUserName()%></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="LogoutServlet">||&nbsp;&nbsp; <span class="fa fa-power-off"></span> Logout</a>
                </li>



                <%
                    }
                %>
            </ul>

        </div>
    </div>
</nav>
