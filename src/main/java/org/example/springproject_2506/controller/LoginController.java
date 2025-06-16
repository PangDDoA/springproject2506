package org.example.springproject_2506.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin-dashboard"; // templates/admin-dashboard.html
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "user-home"; // templates/user-home.html
    }
}
