package com.example.demo.comDAO;

import com.example.demo.model.User;

public interface UserDAO {
    boolean userRegister(User us);
    User login(String email, String password);
    boolean checkPassword(int id, String ps);
    boolean updateProfile(User us);
    boolean checkUser(String em);
}
