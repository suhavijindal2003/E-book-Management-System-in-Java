package com.example.demo.comDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Cart;

public class CartDAOImpl implements cartdao {
    private Connection conn;

    // Constructor to initialize the connection
    public CartDAOImpl(Connection conn) {
        this.conn = conn;
    }

    // Add book to the cart
    @Override
    public boolean addToCart(Cart cart) {
        boolean success = false;
        String sql = "INSERT INTO cart(book_id, user_id, book_name, author, price, total_price) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cart.getBookId());
            ps.setInt(2, cart.getUserId());
            ps.setString(3, cart.getBookName());
            ps.setString(4, cart.getAuthor());
            ps.setDouble(5, cart.getPrice());
            ps.setDouble(6, cart.getTotalPrice());

            int rowsAffected = ps.executeUpdate();
            success = rowsAffected == 1;  // Check if the insert was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    // Retrieve all books in the cart for a specific user
    @Override
    public List<Cart> getBooksByUser(int userId) {
        List<Cart> cartList = new ArrayList<>();
        String sql = "SELECT * FROM cart WHERE user_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cart cart = new Cart();
                    cart.setCartId(rs.getInt("cart_id"));
                    cart.setBookId(rs.getInt("book_id"));
                    cart.setUserId(rs.getInt("user_id"));
                    cart.setBookName(rs.getString("book_name"));
                    cart.setAuthor(rs.getString("author"));
                    cart.setPrice(rs.getDouble("price"));
                    cart.setTotalPrice(rs.getDouble("total_price"));
                    cartList.add(cart);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartList;
    }

    // Remove a book from the cart
    @Override
    public boolean removeBook(int bookId, int userId, int cartId) {
        boolean success = false;
        String sql = "DELETE FROM cart WHERE book_id = ? AND user_id = ? AND cart_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, bookId);
            ps.setInt(2, userId);
            ps.setInt(3, cartId);

            int rowsAffected = ps.executeUpdate();
            success = rowsAffected == 1;  // Check if the delete was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
