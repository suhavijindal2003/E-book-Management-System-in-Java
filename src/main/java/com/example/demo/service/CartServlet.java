package com.example.demo.service;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.List;
import com.example.demo.model.Cart;
import com.example.demo.comDAO.CartDAOImpl;
import com.example.demo.repository.DBConnect;

public class CartServlet extends HttpServlet {
    // For adding a book to the cart
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("bid"));
        int uid = Integer.parseInt(req.getParameter("uid"));
        String bookName = req.getParameter("bookname");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));

        // Create a Cart object
        Cart cart = new Cart();
        cart.setBookId(bid);
        cart.setUserId(uid);
        cart.setBookName(bookName);
        cart.setAuthor(author);
        cart.setPrice(price);
        cart.setTotalPrice(price);

        // Initialize DAO
        CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
        HttpSession session = req.getSession();

        // Add to cart logic
        if (dao.addToCart(cart)) {
            session.setAttribute("succMsg", "Book added to cart.");
            res.sendRedirect("all_recent_book.jsp");
        } else {
            session.setAttribute("failMsg", "Failed to add book.");
            res.sendRedirect("all_recent_book.jsp");
        }
    }

    // For viewing the cart (list of books in the cart)
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("uid"));

        // Initialize DAO
        CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());

        // Get the list of books in the user's cart
        List<Cart> cartItems = dao.getBooksByUser(userId);
        req.setAttribute("cartItems", cartItems);

        // Forward to the cart page to display cart
        RequestDispatcher dispatcher = req.getRequestDispatcher("view_cart.jsp");
        dispatcher.forward(req, res);
    }
}
