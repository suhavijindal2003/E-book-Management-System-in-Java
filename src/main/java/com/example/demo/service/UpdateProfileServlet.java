package com.example.demo.service;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.comDAO.UserDAOImpl;
import com.example.demo.repository.DBConnect;
import com.example.demo.model.User;

public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);

        UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.updateUser(user)) {
            session.setAttribute("succMsg", "Profile updated.");
        } else {
            session.setAttribute("failMsg", "Something went wrong.");
        }

        res.sendRedirect("edit_profile.jsp");
    }
}