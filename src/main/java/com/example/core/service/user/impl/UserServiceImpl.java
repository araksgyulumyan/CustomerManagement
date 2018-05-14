package com.example.core.service.user.impl;

import com.example.core.entity.User;
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
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    // Service methods
    @Override
    public User getUserByEmail(String email) {
        assertEmail(email);
        if (userRepository.findByEmail(email) == null) {
            throw new RuntimeException("User is not found");
        }
        return userRepository.findByEmail(email);
    }

    // Utility methods
    private static void assertEmail(String email) {
        Assert.hasText(email, "Id should not be null");
    }

}
