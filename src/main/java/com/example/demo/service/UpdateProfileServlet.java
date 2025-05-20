package com.example.demo.service;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.comDAO.UserDAOImpl;
import com.example.demo.model.User;
import com.example.demo.repository.DBConnect;

@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("fname");
            String email = req.getParameter("email");
            String phno = req.getParameter("phno");
            String password = req.getParameter("password");

            User us = new User();
            us.setId(id);
            us.setName(name);
            us.setEmail(email);
            us.setPhno(phno);
            
            HttpSession session=req.getSession();

            UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());

            boolean f = dao.checkPassword(id, password);
            if (f) {
                boolean f2 = dao.updateProfile(us);
                if (f2) {
                    session.setAttribute("succMsg", "Profile Update Successfully..");
                    resp.sendRedirect("edit_profile.jsp");

                } else {

                
                session.setAttribute("failedMsg", "Something wrong on server");
                resp.sendRedirect("edit_profile.jsp");
                
                }
            } else {
                 session.setAttribute("failedMsg", "Your Password is incorrect");
                resp.sendRedirect("edit_profile.jsp");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}