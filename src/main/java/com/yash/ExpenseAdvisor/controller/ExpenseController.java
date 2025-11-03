package com.yash.ExpenseAdvisor.controller;

import com.yash.ExpenseAdvisor.model.Expense;
import com.yash.ExpenseAdvisor.service.ExpenseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // ✅ View all expenses
    @GetMapping("/view")
    public String viewExpenses(HttpSession session, Model model) {
        String email = (String) session.getAttribute("userEmail");
        if (email == null) return "redirect:/login";

        List<Expense> expenses = expenseService.getAllByUserEmail(email);
        model.addAttribute("expenses", expenses);
        return "viewExpenses";
    }

    // ✅ Show "Add Expense" form
    @GetMapping("/addExpense")
    public String showAddExpenseForm(Model model, HttpSession session) {
        if (session.getAttribute("userEmail") == null) return "redirect:/login";

        model.addAttribute("expense", new Expense());
        return "addExpense";
    }

    // ✅ Handle Add Expense submission
    @PostMapping("/addExpense")
    public String addExpense(@ModelAttribute Expense expense, HttpSession session) {
        String email = (String) session.getAttribute("userEmail");
        if (email == null) return "redirect:/login";

        expense.setUserEmail(email);
        expense.setDate(LocalDate.now());
        expenseService.saveExpense(expense);

        return "redirect:/expenses/view";
    }

    // ✅ Delete Expense
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("userEmail") == null) return "redirect:/login";

        expenseService.deleteById(id);
        return "redirect:/expenses/view";
    }
    
    @GetMapping("/edit/{id}")
    public String editExpense(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("userEmail") == null)
            return "redirect:/login";

        Expense expense = expenseService.getById(id);
        model.addAttribute("expense", expense);
        return "editExpense"; // corresponds to /WEB-INF/jsp/editExpense.jsp
    }
    
    @PostMapping("/update")
    public String updateExpense(@ModelAttribute Expense expense, HttpSession session) {
        if (session.getAttribute("userEmail") == null)
            return "redirect:/login";
      
        expenseService.saveExpense(expense); // reuses save() to update the record
        return "redirect:/expenses/view";
    }
    
    @GetMapping("/logout")
    public String logoutPage(HttpSession session) {
        session.invalidate();
        return "redirect:/login";  // redirect after logout
    }
    @GetMapping("/search")
    public String searchExpenses(@RequestParam("keyword") String keyword,
                                 Model model,
                                 HttpSession session) {

        String email = (String) session.getAttribute("userEmail");
        if (email == null) {
            return "redirect:/login";
        }

        List<Expense> expenses;

        if (keyword != null && !keyword.trim().isEmpty()) {
            expenses = expenseService.searchExpensesByDescription(email, keyword.trim());
        } else {
            expenses = expenseService.getAllByUserEmail(email);
        }

        model.addAttribute("expenses", expenses);
        return "viewExpenses";
    }




}
