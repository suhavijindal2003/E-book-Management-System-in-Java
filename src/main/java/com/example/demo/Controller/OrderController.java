// package com.example.demo.Controller;


// import java.io.IOException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import model.order;

// @WebServlet("/OrderController")
// public class OrderController extends HttpServlet {
//     private static final long serialVersionUID = 1L;

//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         ArrayList<order> orders = new ArrayList<>();
//         Connection con = null;
//         PreparedStatement ps = null;
//         ResultSet rs = null;

//         try {
//             // Database Connection
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "password");

//             // Query to get all orders
//             String sql = "SELECT * FROM orders";
//             ps = con.prepareStatement(sql);
//             rs = ps.executeQuery();

//             while (rs.next()) {
//                 order order = new order();
//                 order.setorderId(rs.getInt("order_id"));
//                 order.setName(rs.getString("name"));
//                 order.setEmail(rs.getString("email"));
//                 order.setAddress(rs.getString("address"));
//                 order.setPhoneNumber(rs.getString("phone_number"));
//                 order.setBookName(rs.getString("book_name"));
//                 order.setAuthor(rs.getString("author"));
//                 order.setPrice(rs.getDouble("price"));
//                 order.setPaymentType(rs.getString("payment_type"));

//                 orders.add(order);
//             }

//             request.setAttribute("orders", orders);
//             request.getRequestDispatcher("orderlist.jsp").forward(request, response);
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (rs != null) rs.close();
//                 if (ps != null) ps.close();
//                 if (con != null) con.close();
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
