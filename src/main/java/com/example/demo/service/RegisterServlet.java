package com.example.demo.service;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.model.User;
import com.example.demo.comDAO.UserDAOImpl;
import com.example.demo.comDAO.UserController;
import com.example.demo.repository.DBConnect;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        User user = new User(0, name, email, password, phone, address);
        UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());

        HttpSession session = req.getSession();
        if (dao.userRegister(user)) {
            session.setAttribute("succMsg", "Registered successfully.");
            res.sendRedirect("register.jsp");
        } else {
            session.setAttribute("failMsg", "Something went wrong!");
            res.sendRedirect("register.jsp");
        }
    }
}