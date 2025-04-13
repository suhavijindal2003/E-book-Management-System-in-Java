
package com.example.demo.comDAO;
import java.sql.*;
import com.example.demo.model.User;
import com.example.demo.comDAO.UserDAO;


public class UserDAOImpl implements UserDAO {
    private Connection conn;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean userRegister(User user) {
        boolean success = false;
        try {
            String sql = "INSERT INTO users(name, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());

            int i = ps.executeUpdate();
            success = i == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public User login(String email, String password) {
        User user = null;
        try {
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(email);
                user.setPassword(password);
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        boolean success = false;
        try {
            String sql = "UPDATE users SET name=?, phone=?, address=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getAddress());
            ps.setInt(4, user.getId());

            int i = ps.executeUpdate();
            success = i == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
