package com.example.demo.service;
import com.example.demo.comDAO.BookDAOImpl;
import com.example.demo.repository.DBConnect;
import com.example.demo.model.BookDtls;
import com.example.demo.comDAO.CartDAOImpl;
import com.example.demo.model.Cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            int bid = Integer.parseInt(req.getParameter("bid"));
            int uid = Integer.parseInt(req.getParameter("uid"));

            BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
            BookDtls b = dao.getBookById(bid);

            Cart c = new Cart();
            c.setBid(bid);
            c.setUserId(uid);
            c.setBookName(b.getBookName());
            c.setAuthor(b.getAuthor());
            c.setPrice(Double.parseDouble(b.getPrice()));
            c.setTotalPrice(Double.parseDouble(b.getPrice()));

            CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConn());
            boolean f = dao2.addCart(c);

            HttpSession session = req.getSession();

            if (f) {
                session.setAttribute("addCart", "Book Added to cart");
                resp.sendRedirect("all_new_book.jsp");

            } else {
                session.setAttribute("failed", "Something Wrong ion Server");
                resp.sendRedirect("all_new_book.jsp");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}