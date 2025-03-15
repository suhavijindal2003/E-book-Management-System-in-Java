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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        try {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            String confirmPassword = req.getParameter("confirmPassword");

            if (!password.equals(confirmPassword)) {
                session.setAttribute("error", "Passwords do not match!");
                resp.sendRedirect("register.jsp");
                return;
            }

            User user = new User(name, email, phone, password);

            Connection conn = DBConnect.getConn();
            UserDAOImp userDAO = new UserDAOImp(conn);

            boolean success = userDAO.userRegister(user);

            if (success) {
                session.setAttribute("message", "Registration successful! Please log in.");
                resp.sendRedirect("login.jsp");
            } else {
                session.setAttribute("error", "Registration failed! Try again.");
                resp.sendRedirect("register.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Something went wrong. Please try again.");
            resp.sendRedirect("register.jsp");
        }
    }
}
