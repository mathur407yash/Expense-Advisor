package com.yash.ExpenseAdvisor.service;

import com.yash.ExpenseAdvisor.model.User;
import com.yash.ExpenseAdvisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ Register user
    public void saveUser(User user) {
        // ⚠️ Note: In production, hash password before saving
        userRepository.save(user);
    }

    // ✅ Simple password check (plain text)
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }

    // ✅ Find user by email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
