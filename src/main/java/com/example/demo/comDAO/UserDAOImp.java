package com.example.demo.comDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.demo.model.User;

public class UserDAOImp implements UserController {
    private Connection conn;

    public UserDAOImp(Connection conn) {
        super();
        this.conn = conn;
    }

    @Override
    public boolean userRegister(User us) {
        boolean f = false;

        try {
            String sql = "INSERT INTO user(name, email, phno, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, us.getName());
            ps.setString(2, us.getEmail());
            ps.setString(3, us.getPhno());
            ps.setString(4, us.getPassword());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }


    public User loginUser(String email, String password) {
        User user = null;
        try {
            String sql = "SELECT * FROM user WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"), 
                    rs.getString("phno"),
                    rs.getString("address"),
                    rs.getString("landmark"),
                    rs.getString("city"),
                    rs.getString("state"),
                    rs.getString("pincode")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
}


