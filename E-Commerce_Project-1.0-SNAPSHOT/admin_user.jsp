<%@page import="com.ecommerce.entities.Product"%>
<%@page import="com.ecommerce.dao.ProductDao"%>
<%@page import="com.ecommerce.entities.Category"%>
<%@page import="com.ecommerce.dao.CategoryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page import="com.ecommerce.dao.UserDao"%>
<%@page import="com.ecommerce.entities.User"%>
<%
    HttpSession httpsession = request.getSession();
    User user = (User) httpsession.getAttribute("currentUser");
    if (user == null) {
        httpsession.setAttribute("error_message", "Please Login First.");
        response.sendRedirect("login.jsp");
        return;
    } else {
        if (user.getUserType().equals("normal")) {
            httpsession.setAttribute("error_message", "Login as Admin to access Admin Rights.");
            response.sendRedirect("normal_user.jsp");
            return;
        }
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
       

        <div class="container text-center" id="admin">
            <div class="row mt-4 mb-4 mr-5 ml-5">
                <div class="container-fluid">
                     <%@include file="components/message.jsp" %>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-header">
                            <h2>Users</h2>
                            <img class="img-fluid" src="img/teamwork.png" style="max-width: 125px">
                        </div>
                        <div class="card-body">
                            <% 
                                UserDao udao = new UserDao(FactoryProvider.getFactory());
                                List<User> list = udao.getAllUsers();

                            %>
                            <h4>Total Users: <%= list.size()%></h4>

                        </div>
                        <div class="card-footer">

                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card">
                        <div class="card-header">
                            <h2>Categories</h2>
                            <img class="img-fluid" src="img/options.png" style="max-width: 125px" />
                        </div>
                        <div class="card-body">
                            <%
                              CategoryDao catdao=new CategoryDao(FactoryProvider.getFactory());
                              List<Category> clist=catdao.getAllCategories();
                            %>
                            <h4>Total Categories: <%= clist.size() %></h4>
                        </div>
                        <div class="card-footer">

                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card">
                        <div class="card-header">
                            <h2>Products</h2>
                            <img class="img-fluid" src="img/products.png" style="max-width: 125px" />
                        </div>
                        <div class="card-body">
                            <%
                                ProductDao pdao=new ProductDao(FactoryProvider.getFactory());
                                
                                List<Product> plist=pdao.getAllProducts();
                            %>
                            <h4>Total Products: <%= plist.size() %></h4>
                        </div>
                        <div class="card-footer">

                        </div>
                    </div>
                </div>
            </div>
            <div class="row mt-4 mb-4 mr-5 ml-5">
                <div class="col-md-6">
                    <div class="card" data-toggle="modal" data-target="#categoryModal">
                        <div class="card-header" >
                            <h2>Add Categories</h2>
                            <img class="img-fluid" src="img/category.png" style="max-width: 125px"/>
                        </div>
                        <div class="card-body">

                        </div>
                        <div class="card-footer">

                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card" data-toggle="modal" data-target="#productModal">
                        <div class="card-header">
                            <h2>Add Products</h2>
                            <<img class="img-fluid" src="img/ecommerce.png" style="max-width: 125px"/>
                        </div>
                        <div class="card-body">

                        </div>
                        <div class="card-footer">

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Add Categories Modal Start-->


        <!-- Modal -->
        <div class="modal fade" id="categoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header theme-color">
                        <h5 class="modal-title" id="exampleModalLabel">Add Category</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">


                        <form action="AddCategoryServlet" method="POST">
                            <div class="form-group">
                                <label><h6>Enter Category Name:</h6></label>
                                <input class="form-control" type="text" name="cname" placeholder="Category Name">
                                <label><h6>Category Description:</h6></label>
                                <textarea class="form-control" name="cdesc" rows="10" cols="6">
                               
                                </textarea>
                            </div>

                    </div>
                    <div class="modal-footer theme-color">
                        <div class="container text-center">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success">Save Category</button>
                        </div>
                    </div>
                    </form>

                </div>

            </div>
        </div>

        <!--Add Categories Modal End-->


        <!--Add Products Modal Start-->

        <div class="modal fade" id="productModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header theme-color">
                        <h5 class="modal-title" id="exampleModalLabel">Add Category</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">


                        <form action="AddProductServlet" method="POST" enctype="multipart/form-data">
                            <div class="form-group">
                                <label><h6>Enter Product Name:</h6></label>
                                <input class="form-control" type="text" name="pname" placeholder="Product Name">
                                <label><h6>Product Description:</h6></label>
                                <textarea class="form-control" name="pdesc" rows="10" cols="6">                               
                                </textarea>
                                <label><h6>Product Image:</h6></label>
                                <input class="form-control" type="file" name="pimage">
                                <label><h6>Enter Product Price:</h6></label>
                                <input class="form-control" type="number" name="pprice" placeholder="Product Price">
                                <label><h6>Enter Product Discount:</h6></label>
                                <input class="form-control" type="number" name="pdiscount" placeholder="Product Discount">
                                <label><h6>Enter Product Quantity:</h6></label>
                                <input class="form-control" type="number" name="pquantity" placeholder="Product Quantity">
                                <label><h6>Enter Product Category:</h6></label>
                                <select class="form-control" name="pcategory">
                                    <option> Select Category </option>    
                                        <%
                                           CategoryDao cdao =new CategoryDao(FactoryProvider.getFactory());
                                           
                                           List<Category> lcat=cdao.getAllCategories();
                                          
                                           for(Category c:lcat)
                                           {
                                          %>
                                        
                                          <option value="<%= c.getCategoryId() %>">
                                               <%= c.getCategoryName() %>
                                           </option>
                                        <% 
                                            }
                                        %>
                                </select>
                            </div>

                    </div>
                    <div class="modal-footer theme-color">
                        <div class="container text-center">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success">Add Product</button>
                        </div>
                    </div>
                    </form>

                </div>

            </div>
        </div>


        <!--Add Products Modal End-->

        <%@include file="components/footer.jsp" %>
        <%@include file="components/common_modal.jsp" %>
    </body>
</html>
