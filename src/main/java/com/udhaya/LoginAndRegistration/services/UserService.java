package com.udhaya.LoginAndRegistration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udhaya.LoginAndRegistration.repository.*;
import com.udhaya.LoginAndRegistration.Models.User;


@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User registerUser(User user) {
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }


        return userRepository.save(user);
    }

    public boolean loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        // Check if the user exists
        if (user == null) {
            return false;
        }

        // Check if the provided password matches the stored password
        return password.equals(user.getPassword());
    }
}
