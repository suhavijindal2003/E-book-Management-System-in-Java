package com.example.demo.service;
import com.example.demo.comDAO.BookDAOImpl; 
import com.example.demo.comDAO.UserDAOImpl;
import com.example.demo.repository.DBConnect;
import com.example.demo.model.User;
import com.example.demo.model.Book;
import com.example.demo.model.Cart;
import com.example.demo.comDAO.cartdao;
import com.example.demo.comDAO.CartDAOImpl;
import java.util.List;
import com.example.demo.comDAO.BookOrderDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/remove_book")
public class RemoveBookCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int bid = Integer.parseInt((req.getParameter("bid")));
        int uid =Integer.parseInt((req.getParameter("uid")));
        int cid =Integer.parseInt((req.getParameter("cid")));
        CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
        boolean f = dao.deleteBook(bid,uid,cid);

        HttpSession session = req.getSession();

        if (f) {
            session.setAttribute("succMsg", "Book Removed from cart");
            resp.sendRedirect("checkout.jsp");
        } else {
            session.setAttribute("failedMsg", "Something wrong on Server");
            resp.sendRedirect("checkout.jsp");

        }
    }

}