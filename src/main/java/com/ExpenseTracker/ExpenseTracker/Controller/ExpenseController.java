package com.ExpenseTracker.ExpenseTracker.Controller;

import com.ExpenseTracker.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.ExpenseTracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String showExpenses(Model model) {
        List<Expense> expenses = expenseService.getExpensesByUser(1L);
        model.addAttribute("expenses", expenses);
        return "expenseTracker";
    }

    @PostMapping("/add")
    public String addExpense(@RequestParam String category,
                             @RequestParam Double amount,
                             @RequestParam String date) {
        Expense expense = new Expense(category, amount, java.sql.Date.valueOf(date), null);
        expenseService.addExpense(expense);
        return "redirect:/expenses";
    }

    @PostMapping("/delete")
    public String deleteExpense(@RequestParam Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
}