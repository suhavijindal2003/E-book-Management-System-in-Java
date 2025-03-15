package com.example.demo.comDAO;

import com.example.demo.model.User;
public interface UserController {
    boolean userRegister(User us);
    User loginUser(String email, String password);
}
