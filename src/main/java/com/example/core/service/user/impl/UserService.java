package com.example.core.service.user.impl;

import com.example.core.dto.AbstractUserDto;
import com.example.core.entity.User;
import com.example.core.repository.user.AbstractUserRepository;
import com.example.core.service.user.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Created by araksgyulumyan
 * Date - 5/14/18
 * Time - 3:50 PM
 */
public class UserService implements AbstractUserService<User> {

    @Autowired
    private AbstractUserRepository<User> userRepository;

    // Service methods
    @Override
    public User createUser(String email, AbstractUserDto<User> userDto) {
        return null;
    }

    @Override
    public User updateUser(Long userId, AbstractUserDto<User> userDto) {
        return null;
    }

    @Override
    public void removeUserById(Long id) {

    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        assertEmail(email);
        if (userRepository.findByEmail(email) == null) {
            throw new NullPointerException("User is not found");
        }
        return userRepository.findByEmail(email);
    }


    // Utility methods
    private static void assertEmail(String email) {
        Assert.hasText(email, "Id should not be null");
    }


}
