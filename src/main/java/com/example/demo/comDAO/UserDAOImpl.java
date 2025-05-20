package com.example.demo.comDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.demo.model.User;

public class UserDAOImpl implements UserDAO {

    private Connection conn;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean userRegister(User us) {
        boolean f = false;
        try {
            String sql = "INSERT INTO users(name, email, phno, password, address, landmark, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, us.getName());
            ps.setString(2, us.getEmail());
            ps.setString(3, us.getPhno());
            ps.setString(4, us.getPassword());
            ps.setString(5, us.getAddress());
            ps.setString(6, us.getLandmark());
            ps.setString(7, us.getCity());
            ps.setString(8, us.getState());
            ps.setString(9, us.getPincode());

            int i = ps.executeUpdate();
            f = (i == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public User login(String email, String password) {
        User us = null;
        try {
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                us = new User();
                us.setId(rs.getInt("id"));
                us.setName(rs.getString("name"));
                us.setEmail(rs.getString("email"));
                us.setPhno(rs.getString("phno"));
                us.setPassword(rs.getString("password"));
                us.setAddress(rs.getString("address"));
                us.setLandmark(rs.getString("landmark"));
                us.setCity(rs.getString("city"));
                us.setState(rs.getString("state"));
                us.setPincode(rs.getString("pincode"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public boolean checkPassword(int id, String pswd) {
        boolean f = false;
        try {
            String sql = "SELECT * FROM users WHERE id=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, pswd);
            ResultSet rs = pst.executeQuery();
            f = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean updateProfile(User us) {
        boolean f = false;
        try {
            String sql = "UPDATE users SET name=?, email=?, phno=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, us.getName());
            ps.setString(2, us.getEmail());
            ps.setString(3, us.getPhno());
            ps.setInt(4, us.getId());
            f = (ps.executeUpdate() == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean checkUser(String em) {
        boolean f = true;
        try {
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, em);
            ResultSet rs = ps.executeQuery();
            f = !rs.next(); // if user exists, f = false
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
