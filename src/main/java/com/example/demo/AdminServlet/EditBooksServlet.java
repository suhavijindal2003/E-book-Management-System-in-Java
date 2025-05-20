package com.example.demo.AdminServlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.comDAO.BookDAOImpl;
import com.example.demo.model.BookDtls;
import com.example.demo.repository.DBConnect;

@WebServlet("/editbooks")
public class EditBooksServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String bookName = req.getParameter("bName");
            String author = req.getParameter("author");
            String price = req.getParameter("price");

            String status = req.getParameter("status");

            BookDtls b = new BookDtls();
            b.setBookId(id);
            b.setBookName(bookName);
            b.setAuthor(author);
            b.setPrice(price);
            b.setStatus(status);

            BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
            boolean f = dao.updateEditBooks(b);

            HttpSession session = req.getSession();
            if (f) {
                session.setAttribute("succMsg", "Book Update Succesfully..");
                resp.sendRedirect("admin/all_books.jsp");

            } else {
                session.setAttribute("FailedMsg", "Something wrong on server..");
                resp.sendRedirect("admin/all_books.jsp");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}