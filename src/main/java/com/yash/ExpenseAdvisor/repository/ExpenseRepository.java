package com.yash.ExpenseAdvisor.repository;

import com.yash.ExpenseAdvisor.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserEmail(String userEmail); // ✅ correct query method
    
    List<Expense> findByUserEmailAndDescriptionContainingIgnoreCase(String email, String description);

}
