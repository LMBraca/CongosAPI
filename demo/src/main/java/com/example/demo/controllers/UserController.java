package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @ResponseBody
    public User insertUser(@RequestBody User u) throws Exception {
        return userService.saveUser(u);
    }

    @GetMapping("/find/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/{username}/highscore")
    public User updateHighscore(@PathVariable String username, @RequestParam String highscore) {
        return userService.updateHighscore(username, highscore);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User u) {
        boolean isAuthenticated = userService.getUserByUsernameAndPassword(u.getUsername(), u.getPassword());
        if (isAuthenticated) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    @GetMapping("/{username}/highscore")
    public String getHighscoreByUsername(@PathVariable("username") String username) {
        return userService.getHighscoreByUsername(username);
    }
}
