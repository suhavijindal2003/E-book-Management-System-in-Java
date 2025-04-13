package com.example.demo.comDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.example.demo.model.Cart;

public class BookOrderImpl implements BookOrderDAO {
    private Connection conn;

    public BookOrderImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean saveOrder(List<Cart> carts) {
        boolean success = false;
        try {
            String sql = "INSERT INTO orders(book_id, user_id, book_name, author, price, total_price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (Cart cart : carts) {
                ps.setInt(1, cart.getBookId());
                ps.setInt(2, cart.getUserId());
                ps.setString(3, cart.getBookName());
                ps.setString(4, cart.getAuthor());
                ps.setDouble(5, cart.getPrice());
                ps.setDouble(6, cart.getTotalPrice());
                ps.addBatch();
            }

            int[] result = ps.executeBatch();
            success = result.length == carts.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
}
}