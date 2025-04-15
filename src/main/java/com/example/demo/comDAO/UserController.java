package com.example.demo.comDAO;
import com.example.demo.model.User;
public interface UserController {
    public String userRegister(User user);
    public User login(String email, String password);
    public String updateUser(User user);
}
