package com.example.demo.comDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Book;
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

    // 🔍 Search Books by keyword (title, author, or category)
    public List<Book> searchBooks(String keyword) {
        List<Book> bookList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM books WHERE book_name LIKE ? OR author LIKE ? OR category LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            String likePattern = "%" + keyword + "%";
            ps.setString(1, likePattern);
            ps.setString(2, likePattern);
            ps.setString(3, likePattern);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setStatus(rs.getString("status"));
                book.setPhoto(rs.getString("photo"));
                book.setEmail(rs.getString("email"));
                book.setPrice(rs.getDouble("price"));

                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

  
    public boolean deleteBookById(int id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            success = rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    public boolean addBook(Book book) {
        boolean success = false;
        try {
            String sql = "INSERT INTO books(book_name, author, category, status, photo, email, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getBookName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setString(4, book.getStatus());
            ps.setString(5, book.getPhoto());
            ps.setString(6, book.getEmail());
            ps.setDouble(7, book.getPrice());

            int rows = ps.executeUpdate();
            success = rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
