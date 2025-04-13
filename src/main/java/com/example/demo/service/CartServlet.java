package com.example.demo.service;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.model.Cart;
import com.example.demo.comDAO.CartDAOImpl;
import com.example.demo.repository.DBConnect;
import com.example.demo.comDAO.cartdao;


public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("bid"));
        int uid = Integer.parseInt(req.getParameter("uid"));
        String bookName = req.getParameter("bookname");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));

        Cart cart = new Cart();
        cart.setBookId(bid);
        cart.setUserId(uid);
        cart.setBookName(bookName);
        cart.setAuthor(author);
        cart.setPrice(price);
        cart.setTotalPrice(price);

        CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.addToCart(cart)) {
            session.setAttribute("succMsg", "Book added to cart.");
            res.sendRedirect("all_recent_book.jsp");
        } else {
            session.setAttribute("failMsg", "Failed to add book.");
            res.sendRedirect("all_recent_book.jsp");
        }
    }
}