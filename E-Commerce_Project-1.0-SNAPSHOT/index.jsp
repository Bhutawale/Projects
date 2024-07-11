
<%@page import="com.ecommerce.helper.Helper"%>
<%@page import="com.ecommerce.entities.Product"%>
<%@page import="com.ecommerce.dao.ProductDao"%>
<%@page import="com.ecommerce.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.dao.CategoryDao"%>
<%@page import="com.ecommerce.helper.FactoryProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Commerce/Home Page</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        <div class="container-fluid text-center mt-4">
            <h1 style="color: #82b1ff">Welcome to S-MART</h1>
        </div>
        <div class="container mb-4">
            <div class="row mt-4">
                <div class="col-md-3 mt-4">
                     <a href="index.jsp?category=All" class="list-group-item list-group-item-action">
                            All Categories
                        </a>
                   
                    <% 
                       
                       
                        CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
                        
                        List<Category> clist = cdao.getAllCategories();
                        for (Category c : clist) {
                    %>
                    
                    <div class="list-group">
                       
                        <a href="index.jsp?category=<%=c.getCategoryId() %>" class="list-group-item list-group-item-action">
                            <%= c.getCategoryName()%>
                        </a>

                    </div>  
                    <% }
                    %>

                </div>
   
            <div class="col-md-9">

                <div class="row mt-4">
                    <div class="col-md-12">
                        <div class="card-columns">
                            <%
                                String cat=request.getParameter("category");
                                 if (cat == null || cat.trim().isEmpty()) {
                                    cat = "All";
                                }
                                
                                ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
                                
                                List<Product> plist =null;
                                
                                if(cat.trim().equals("All"))
                                {
                                    plist = pdao.getAllProducts();
                                }
                                else
                                {
                                    int cid= Integer.parseInt(cat);
                                    plist= pdao.getProductsByCatId(cid);
                                }
                                for (Product p : plist)
                                {
                            %>
                            <div class="card" id="card-decoration">
                                <img class="card-img-top" src="img/products/<%= p.getProductImage() %>" style="max-height:270px; max-width: 100%; ">
                                <div class="card-body">
                                    <h5 class="card-title"><%= p.getProductName() %></h5>
                                    <p class="card-text"> <%= Helper.show10words(p.getProductDescription()) %> </p>
                                    <a href="#" class="btn theme-color text-white">Read More</a>
                                    <a href="#" class="btn btn-danger text-white">Selling Price <span class="fa fa-inr">&nbsp;<%= p.calculateSellingPrice(p.getProductPrice()) %>/-</span> </a>
                                    <button class="btn btn-warning">MRP <span class="fa fa-inr mrp-label">&nbsp;<%= p.getProductPrice() %>/-</span>
                                    Discount <span class="text-secondary discount-label fa fa-inr">&nbsp;<%= p.getProductDiscount()%>%</span>
                                    </button>
                                    
                                </div>
                                <div class="card-footer theme-color text-center">
                                    <button class="btn btn-success" onclick="add_to_cart(<%=p.getProductId() %>,'<%= p.getProductName() %>',<%= p.calculateSellingPrice(p.getProductPrice()) %>)">Add to Cart</button>
                                    
                                </div>
                            </div>


                            <%
                                }
                                if(plist.size()==0)
                                    {
                                  %>
                                  <h3>No Items in this Category.</h3>
                                  <%
                                    }
                            %>
                        </div>
                    </div>                    
                </div>                
            </div>
            </div>
        </div>

        <%@include file="components/footer.jsp" %>
        <%@include file="components/common_modal.jsp" %>
    </body>
</html>
