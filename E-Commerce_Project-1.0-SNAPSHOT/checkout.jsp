<%

    HttpSession ses=request.getSession();
    User user=(User)ses.getAttribute("currentUser");
    if(user==null){
        ses.setAttribute("error_message", "Login First to Place Orders!!");
        response.sendRedirect("login.jsp");
        return;
    }
    else
    {
        //response.sendRedirect("checkout.jsp");
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>

        <div class="container">
            <div class="row mt-4 mb-4">
                <div class="col-md-6">

                    <div class="card">
                        <div class="card-header theme-color text-white">
                            <h3 class="text-center">Products Ordered</h3> 
                        </div>
                        <div class="card-body">
                            <div class="cart-body">

                            </div>
                        </div>
                        <div class="card-footer theme-color">

                        </div>
                    </div>


                </div>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header theme-color text-white">
                            <h3 class="text-center">Customer Details</h3>
                        </div>
                        <div class="card-body">
                            <form action="" method="POST">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input value="<%= user.getUserEmail() %>" type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input value="<%= user.getUserName() %>" type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Name">
                                </div>
                                <div class="form-group">
                                    <label>Shipping Address</label>
                                    <textarea value="<%= user.getUserAddress() %>" class="form-control" name="address" placeholder="Enter Address">
                                       
                                    </textarea>
                                    <div class="form-group">
                                        <label>Contact Number</label>
                                        <input value="<%= user.getUserPhone() %>" type="number" name="contact" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Contact Number">
                                    </div>
                                </div>
                                <div class="container text-center">
                                    <button type="submit" class="btn btn-success">Order Now</button>
                                    <button type="submit" class="btn btn-primary">Continue Shopping</button>
                                </div>
                            </form>
                        </div>
                        <div class="card-footer theme-color">

                        </div>

                    </div>


                </div>
            </div>
        </div>


        <%@include file="components/footer.jsp" %>
        <%@include file="components/common_modal.jsp" %>
    </body>
</html>
