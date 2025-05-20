package com.example.demo.Controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.comDAO.UserDAO;
import com.example.demo.comDAO.UserDAOImpl;
import com.example.demo.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    private UserDAO userDAO;

    public HomeController() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_db", "username", "password");
            this.userDAO = new UserDAOImpl(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ==== REGISTER ====

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user, Model model) {
        if (!userDAO.checkUser(user.getEmail())) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }
        boolean saved = userDAO.userRegister(user);
        if (saved) {
            return "redirect:/login";
        }
        model.addAttribute("error", "Something went wrong!");
        return "register";
    }

    // ==== LOGIN ====

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                Model model,
                                HttpSession session) {
        User user = userDAO.login(email, password);
        if (user == null) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
        session.setAttribute("user", user);
        return "main";
    }

    // Other mappings...

    @GetMapping("/admin")
    public String showIndex() {
        return "AdminDashboard";
    }

    @GetMapping("/books")
    public String showBooks() {
        return "books";
    }

    @GetMapping("/edit_book")
    public String showEditBook() {
        return "edit_book";
    }

    @GetMapping("/add_book")
    public String addBook() {
        return "add_book";
    }

    @GetMapping("/orderlist")
    public String orderlist() {
        return "orderlist";
    }

    @GetMapping("/navbar")
    public String showNavbar() {
        return "navbar";
    }

    @GetMapping("/footer")
    public String showFooter() {
        return "footer";
    }

    @GetMapping("/main")
    public String showMain() {
        return "main";
    }

    @GetMapping("/recentbooks")
    public String recentbook() {
        return "recentbooks";
    }

    @GetMapping("/oldbooks")
    public String oldbooks() {
        return "oldbooks";
    }

    @GetMapping("/newbooks")
    public String newbooks() {
        return "newbooks";
    }

    @GetMapping("/Setting")
    public String Setting() {
        return "Setting";
    }

    @GetMapping("/view_cart")
    public String viewCart() {
        return "view_cart";
    }

    @GetMapping("/edit_profile")
    public String editProfile() {
        return "edit_profile";
    }
}
