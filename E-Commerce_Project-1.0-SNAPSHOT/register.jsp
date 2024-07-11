<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
        <%@include file="components/common_css_js.jsp" %>
    </head> 
    <body>
        <%@include file="components/navbar.jsp" %>
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card mt-4 mb-4">
                    <div class="card-header text-center theme-color">
                        
                        <h3>Register Yourself</h3>  
                    </div>
                    <div class="card-body">
                        <form action="RegisterServlet" method="POST">
                            
                            <%@include file="components/message.jsp" %>
                            <div class="form-group">
                                <label>Enter User Name:</label>
                                <input type="text" name="name" class="form-control" placeholder="Enter User Name">
                            </div>
                            <div class="form-group">
                                <label>Enter User Email-Id:</label>
                                <input type="email" name="email" class="form-control" placeholder="Enter User Email-Id">
                            </div>
                            <div class="form-group">
                                <label>Enter User Password:</label>
                                <input type="password" name="password" class="form-control" placeholder="Enter User Password">
                            </div>
                            <div class="form-group">
                                <label>Enter User Contact Number:</label>
                                <input type="number" name="contact" class="form-control" placeholder="Enter User Contact Number">
                            </div>
                            <div class="form-group">
                                <label>Upload User Profile Picture:</label>
                                <input type="file" name="pic" class="form-control" placeholder="Upload User Profile Picture">
                            </div>
                            <div class="form-group">
                                <label>Enter User Address:</label>
                                <textarea rows="3" cols="35" name="address" placeholder="Enter User Address">
        
                                </textarea>
                            </div>
                    </div>
                    <div class="card-footer text-center theme-color">
                        <button class="btn btn-success" type="submit">Register</button>
                        <button class="btn btn-danger" type="reset">Reset</button><br>
                        <a class="text-white" href="login.jsp"><u>Already Registered!! Login Here</u></a>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="components/footer.jsp" %>
        <%@include file="components/common_modal.jsp" %>
    </body>
</html>
