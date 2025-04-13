package com.example.demo.service;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.comDAO.BookOrderImpl;
import com.example.demo.comDAO.BookOrderDAO;
import com.example.demo.repository.DBConnect;
import com.example.demo.model.Book;
import com.example.demo.model.User;

public class AddOldBook extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("bname");
        String author = req.getParameter("author");
        String category = "Old";
        String status = "Active";
        String price = req.getParameter("price");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("userObj");

        Book book = new Book();
        book.setBookName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setStatus(status);
        book.setPrice(Double.parseDouble(price));
        book.setEmail(user.getEmail());

        BookOrderImpl dao = new BookOrderImpl(DBConnect.getConn());
        if (dao.addBook(book)) {
            session.setAttribute("succMsg", "Book added successfully.");
            res.sendRedirect("sell_book.jsp");
        } else {
            session.setAttribute("failMsg", "Something went wrong.");
            res.sendRedirect("sell_book.jsp");
        }
    }
}
