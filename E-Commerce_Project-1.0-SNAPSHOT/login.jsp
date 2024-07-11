

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>

        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card mt-4 mb-4">
                    <div class="card-header text-center theme-color">
                        <h3>Login Here</h3>
                    </div>

                    <div class="card-body">
                        <%@include file="components/message.jsp" %>
                        <form  action="LoginServlet" method="POST">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email-Id</label>
                                <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Enter Password">
                            </div> 
                    </div>

                    <div class="card-footer theme-color text-center">
                        <button type="submit" class="btn btn-success">Submit</button>
                        <button type="reset" class="btn btn-danger">Reset</button>
                        <br>
                        <a class="text-white" href="register.jsp"><u>Not Registered!! Register Here</</a>
                    </div>

                </div>
                </form>
            </div>
        </div>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/common_modal.jsp" %>
    </body>
</html>
