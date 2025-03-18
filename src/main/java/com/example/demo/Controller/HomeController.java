
package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

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

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
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
    
}