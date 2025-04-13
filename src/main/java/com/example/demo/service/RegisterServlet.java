package com.example.demo.service;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.model.User;
import com.example.demo.comDAO.UserDAOImpl;
import com.example.demo.repository.DBConnect;

@WebServlet("/register")  // Make sure this URL pattern matches your web.xml or servlet-mapping configuration
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Get parameters from the request
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        // Create a User object with plain password (not hashed)
        User user = new User(name, email, password, phone, address);

        // Initialize DAO and DB connection
        UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());

        // Create a session to store messages
        HttpSession session = req.getSession();
        
        // Register the user
        if (dao.userRegister(user)) {
            // If registration is successful, set success message
            session.setAttribute("succMsg", "Registered successfully.");
            res.sendRedirect("register.jsp");
        } else {
            // If registration fails, set failure message
            session.setAttribute("failMsg", "Something went wrong!");
            res.sendRedirect("register.jsp");
        }
    }
}
