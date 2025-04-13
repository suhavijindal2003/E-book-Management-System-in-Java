package com.example.demo.comDAO;



import java.sql.*;
import java.util.*;
import com.example.demo.model.Cart;

public class CartDAOImpl implements CartDAO {
    private Connection conn;

    public CartDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addToCart(Cart cart) {
        boolean success = false;
        try {
            String sql = "INSERT INTO cart(book_id, user_id, book_name, author, price, total_price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cart.getBookId());
            ps.setInt(2, cart.getUserId());
            ps.setString(3, cart.getBookName());
            ps.setString(4, cart.getAuthor());
            ps.setDouble(5, cart.getPrice());
            ps.setDouble(6, cart.getTotalPrice());

            int i = ps.executeUpdate();
            success = i == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public List<Cart> getBooksByUser(int userId) {
        List<Cart> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cart WHERE user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("cart_id"));
                cart.setBookId(rs.getInt("book_id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setBookName(rs.getString("book_name"));
                cart.setAuthor(rs.getString("author"));
                cart.setPrice(rs.getDouble("price"));
                cart.setTotalPrice(rs.getDouble("total_price"));

                list.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean removeBook(int bookId, int userId, int cartId) {
        boolean success = false;
        try {
            String sql = "DELETE FROM cart WHERE book_id=? AND user_id=? AND cart_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookId);
            ps.setInt(2, userId);
            ps.setInt(3, cartId);

            int i = ps.executeUpdate();
            success = i == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
