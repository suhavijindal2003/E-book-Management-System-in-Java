package com.example.demo.service;


import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.comDAO.BookOrderImpl;
import com.example.demo.model.Book;
import com.example.demo.comDAO.BookOrderDAO;
import com.example.demo.repository.DBConnect;

public class SearchBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String search = req.getParameter("ch");

        BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
        List<Book> list = dao.searchBooks(search);

        req.setAttribute("bookList", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
        dispatcher.forward(req, res);
    }
}
