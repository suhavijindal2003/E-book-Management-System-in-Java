<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Cart" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
</head>
<body>
    <h2>Your Cart</h2>

    <% 
        List<Cart> cartItems = (List<Cart>) request.getAttribute("cartItems");
        if (cartItems != null && !cartItems.isEmpty()) {
            for (Cart cart : cartItems) {
    %>
                <div>
                    <p><b>Book Name:</b> <%= cart.getBookName() %></p>
                    <p><b>Author:</b> <%= cart.getAuthor() %></p>
                    <p><b>Price:</b> <%= cart.getPrice() %></p>
                    <form action="CartServlet" method="POST">
                        <input type="hidden" name="cartId" value="<%= cart.getCartId() %>" />
                        <input type="hidden" name="bookId" value="<%= cart.getBookId() %>" />
                        <input type="hidden" name="uid" value="<%= cart.getUserId() %>" />
                        <button type="submit">Remove from Cart</button>
                    </form>
                </div>
                <hr>
            <% 
            }
        } else {
    %>
            <p>Your cart is empty.</p>
    <% 
        }
    %>

</body>
</html>
