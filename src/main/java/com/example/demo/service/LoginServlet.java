package com.example.demo.service;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.comDAO.UserDAOImp;
import com.example.demo.model.User;
import com.example.demo.repository.DBConnect;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            Connection conn = DBConnect.getConn();
            UserDAOImp userDAO = new UserDAOImp(conn);

            User user = userDAO.loginUser(email, password);

            if (user != null) {
                session.setAttribute("user", user);
                resp.sendRedirect("dashboard.jsp");
            } else {
                session.setAttribute("error", "Invalid email or password!");
                resp.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Something went wrong.");
            resp.sendRedirect("login.jsp");
        }
    }
}

