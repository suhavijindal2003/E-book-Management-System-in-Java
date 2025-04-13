package com.example.demo.service;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.comDAO.CartDAOImpl;
import com.example.demo.comDAO.cartdao;
import com.example.demo.model.Cart;
import com.example.demo.repository.DBConnect;

public class RemoveBookCart extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("bid"));
        int uid = Integer.parseInt(req.getParameter("uid"));
        int cid = Integer.parseInt(req.getParameter("cid"));

        CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.removeBook(bid, uid, cid)) {
            session.setAttribute("succMsg", "Book removed from cart.");
        } else {
            session.setAttribute("failMsg", "Failed to remove book.");
        }
        res.sendRedirect("checkout.jsp");
    }
}