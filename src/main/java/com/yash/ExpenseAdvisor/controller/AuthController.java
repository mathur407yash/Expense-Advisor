package com.yash.ExpenseAdvisor.controller;

import com.yash.ExpenseAdvisor.model.User;
import com.yash.ExpenseAdvisor.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // ✅ Home — redirect based on login status
    @GetMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("userEmail") != null) {
            return "redirect:/expenses/view";
        }
        return "redirect:/login";
    }

    // ✅ Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // ✅ Handle registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already registered. Please login!");
            return "register";
        }

        userService.saveUser(user);
        model.addAttribute("success", "Registration successful! Please login.");
        return "login";
    }

    // ✅ Show login form
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // ✅ Handle login
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User existingUser = userService.findByEmail(user.getEmail()).orElse(null);

        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }

        // ✅ Save user info in session
        session.setAttribute("userEmail", existingUser.getEmail());
        session.setAttribute("userName", existingUser.getName());
        return "redirect:/expenses/view";
    }

    // ✅ Handle logout
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("message", "You have been logged out successfully!");
        return "login";
    }
}
