package com.example.demo.services;

import com.example.demo.models.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {

    User saveUser(User u);
    Optional<User> getUserById(long id);
    ArrayList<User> getAllUsers();
    User updateHighscore(String username, String newHighscore);
    boolean getUserByUsernameAndPassword(String username, String password);
    String getHighscoreByUsername(String username);
}
