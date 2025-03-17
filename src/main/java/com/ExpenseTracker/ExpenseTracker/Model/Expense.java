package com.ExpenseTracker.ExpenseTracker.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private Double amount;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense() {}

    public Expense(String category, Double amount, Date date, User user) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.user = user;
    }

    public Long getId() { return id; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
