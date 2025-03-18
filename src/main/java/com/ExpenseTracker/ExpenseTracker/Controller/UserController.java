package com.ExpenseTracker.ExpenseTracker.Controller;



import com.ExpenseTracker.ExpenseTracker.Model.User;
import com.ExpenseTracker.ExpenseTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}

