package com.example.demo.service;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.comDAO.BookOrderImpl;
import com.example.demo.model.Book;
import com.example.demo.repository.DBConnect;
import com.example.demo.comDAO.BookOrderDAO;

public class DeleteOldBook extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
        HttpSession session = req.getSession();
        if (dao.deleteBook(id)) {
            session.setAttribute("succMsg", "Book deleted.");
        } else {
            session.setAttribute("failMsg", "Failed to delete book.");
        }
        res.sendRedirect("view_books.jsp");
    }
}
