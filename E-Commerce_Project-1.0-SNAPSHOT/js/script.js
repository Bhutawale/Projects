function add_to_cart(pid, pname, pprice) {
    let cart = localStorage.getItem("cart");
    if (cart === null) {
        // No cart present
        let products = [];
        let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: pprice};
        products.push(product);
        localStorage.setItem("cart", JSON.stringify(products));
        console.log("Product Added for first time.");
        swal("Congratulations!!", "Product Added to Cart", "success");

    } else {
        // If cart already present
        let pcart = JSON.parse(cart);
        let old_product = pcart.find((item) => item.productId === pid); // Corrected comparison operator
        if (old_product) {
            // We have to increase the quantity
            old_product.productQuantity += 1;
            console.log("Product Quantity Increased");
            swal("Wow you ordered one more!!", "Product Quantity Increased : "+old_product.productQuantity, "success");

        }
       
        else 
        {
            let product = {productId: pid, productName: pname, productQuantity: 1, productPrice: pprice};
            pcart.push(product);
            console.log("Product is added");
            swal("Congratulations!", product.productName +" Product is added to cart!", "success");

        }
        localStorage.setItem("cart", JSON.stringify(pcart)); // Save the updated cart
    }
    updateCart();
}


//updating cart

function updateCart()
{
    let cartString=localStorage.getItem("cart");
    let cart=JSON.parse(cartString);
    if(cart===null || cart.length===0)
    {
        //if cart is empty.
        console.log("Cart is Empty.");
        $(".cart-items").html(" ( 0 ) ");
        $(".cart-body").html("<h3>No Items in Cart.</h3>");
        $(".checkout-btn").attr('disabled',true);
        //swal("Your Cart is Empty!", " Please Order Now and Enjoy Shopping!", "info");

    }
    else
    {
        //if cart have products in it.
        
        console.log(cart);
        $(".cart-items").html(`( ${cart.length})`);
        
        let table=`
                <table class='table'>
                <thead class='thead-light'>
                <tr>
                 <th>Product Name</th>
                 <th>Price</th>
                 <th>Quantity</th>
                 <th>Total Price</th>
                 <th>Action</th>   
                </tr>
                <thead>
        

                `;
     
                let totalPrice=0;
                 cart.map((item)=>{
                   
                   table+= `
                        <tr>
                        <td> ${item.productName} </td>
                        <td> ${item.productPrice} </td>
                        <td> ${item.productQuantity} </td>
                        <td> ${item.productQuantity * item.productPrice} </td>
                        <td> <button onclick='deleteItemFromCart(${item.productId})' class='btn btn-danger btn-sm'>Remove</button></td>
                        
                        
                        </tr>
                        `;
            totalPrice+=item.productPrice*item.productQuantity;
            
               }); 
        
        
        
        
        table=table+`
        <tr><td colspan='5' class='text-right font-weight-bold'>Total Price: ${totalPrice}</td></tr>
    </table>`;
        $(".cart-body").html(table);
         $(".checkout-btn").attr('disabled',false);
        
    }    
}

$(document).ready(function()
{
    updateCart();
});


//delete item from cart

function deleteItemFromCart(pid)
{
    let cart=JSON.parse(localStorage.getItem('cart'));
    
    let newCart=cart.filter((item)=> item.productId !== pid);
    
    localStorage.setItem("cart",JSON.stringify(newCart));
    
    updateCart();
    
    
    
    swal("Product Deleted!","Product is Deleted from your Cart", "error");
    
     
    
    if(newCart.length===0 || newCart===null)
    {
        $(".checkout-btn").attr('disabled',true);
    }


}


function gotoCheckout()
{
    window.location="checkout.jsp";
}
