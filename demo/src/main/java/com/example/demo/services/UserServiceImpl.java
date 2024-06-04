package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User u){
        return userRepository.save(u);
    }
    @Override
    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public User updateHighscore(String username, String newHighscore) {
        Optional<User> userOpt = Optional.ofNullable(userRepository.findByUsername(username));
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setHighScore(newHighscore);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public boolean getUserByUsernameAndPassword(String username, String password) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    @Override
    public String getHighscoreByUsername(String username) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isPresent()) {
            return user.get().getHighScore();
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
