package com.example.demo.service;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.model.Cart;
import com.example.demo.comDAO.CartDAOImpl;
import com.example.demo.repository.DBConnect;
import com.example.demo.comDAO.cartdao;
import com.example.demo.comDAO.BookOrderImpl;
import com.example.demo.comDAO.BookOrderDAO;

public class OrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));

        CartDAOImpl cartDao = new CartDAOImpl(DBConnect.getConn());
        List<Cart> cartList = cartDao.getBooksByUser(uid);

        BookOrderImpl orderDao = new BookOrderImpl(DBConnect.getConn());
        boolean f = orderDao.saveOrder(cartList);

        HttpSession session = req.getSession();
        if (f) {
            session.setAttribute("succMsg", "Order placed successfully.");
            res.sendRedirect("order_success.jsp");
        } else {
            session.setAttribute("failMsg", "Order failed.");
            res.sendRedirect("checkout.jsp");
        }
    }
}