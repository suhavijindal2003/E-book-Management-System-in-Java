package com.example.demo.comDAO;
import com.example.demo.model.User;
public interface UserController {
    public boolean userRegister(User user);
    public User login(String email, String password);
    public boolean updateUser(User user);
}
