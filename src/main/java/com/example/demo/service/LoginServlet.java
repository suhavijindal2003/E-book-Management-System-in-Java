package com.example.demo.service;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;   
import com.example.demo.comDAO.UserDAOImpl;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.example.demo.repository.DBConnect;
import com.example.demo.model.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
        User user = dao.login(email, password);

        HttpSession session = req.getSession();

        if (user != null) {
            session.setAttribute("userObj", user);
            res.sendRedirect("home.jsp");  // Or dashboard.jsp
        } else {
            session.setAttribute("failMsg", "Invalid email or password.");
            res.sendRedirect("login.jsp");
        }
    }
}