package com.yash.ExpenseAdvisor.service;

import com.yash.ExpenseAdvisor.model.Expense;
import com.yash.ExpenseAdvisor.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // ✅ Save an expense
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // ✅ Get all expenses for a specific user
    public List<Expense> getAllByUserEmail(String userEmail) {
        return expenseRepository.findByUserEmail(userEmail);
    }

    // ✅ Delete an expense by ID
    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense getById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        return optionalExpense.orElse(null);
    }

    // ✅ Search expenses for a specific user by keyword
    public List<Expense> searchExpensesByDescription(String email, String keyword) {
        return expenseRepository.findByUserEmailAndDescriptionContainingIgnoreCase(email, keyword);
    }


}
