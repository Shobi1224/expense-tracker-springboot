package com.ExpenseTracker.ExpenseTracker.Controller;

import com.ExpenseTracker.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.ExpenseTracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Expense>> getExpensesByUser(@PathVariable Long userId) {
        List<Expense> expenses = expenseService.getExpensesByUser(userId);
        return ResponseEntity.ok(expenses);
    }

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.addExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
