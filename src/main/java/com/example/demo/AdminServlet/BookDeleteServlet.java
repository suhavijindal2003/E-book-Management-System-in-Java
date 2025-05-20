package com.example.demo.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.comDAO.BookDAOImpl;
import com.example.demo.repository.DBConnect;

@WebServlet("/delete")
public class BookDeleteServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            String idParam = req.getParameter("id");

            if (idParam == null || idParam.trim().isEmpty()) {
                setError(session, "Book ID is required", resp);
                return;
            }

            try {
                int id = Integer.parseInt(idParam);
                BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
                
                if (dao == null) {
                    setError(session, "Database connection failed", resp);
                    return;
                }

                boolean result = dao.deleteBooks(id);
                if (result) {
                    session.setAttribute("succMsg", "Book deleted successfully");
                } else {
                    setError(session, "Failed to delete book", resp);
                    return;
                }

            } catch (NumberFormatException e) {
                setError(session, "Invalid book ID format: " + idParam, resp);
                return;
            }

        } catch (Exception e) {
            setError(session, "Server error: " + e.getMessage(), resp);
            e.printStackTrace();
        }
        resp.sendRedirect("admin/all_books.jsp");
    }

    private void setError(HttpSession session, String message, HttpServletResponse resp) throws IOException {
        session.setAttribute("errorMsg", message);
        resp.sendRedirect("admin/all_books.jsp");
    }
}