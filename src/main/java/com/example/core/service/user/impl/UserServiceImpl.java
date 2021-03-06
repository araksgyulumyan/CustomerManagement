package com.example.core.service.user.impl;

import com.example.core.entity.user.User;
import com.example.core.repository.user.UserRepository;
import com.example.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by araksgyulumyan
 * Date - 5/14/18
 * Time - 3:50 PM
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Service methods
    @Override
    public User getUserByEmail(String email) {
        assertEmail(email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User is not found");
        }
        return user;
    }

    // Utility methods
    private static void assertEmail(String email) {
        Assert.hasText(email, "Email should not be null");
    }

}
