package com.example.core.service.user.impl;

import com.example.core.entity.user.User;
import com.example.core.repository.user.AbstractUserRepository;
import com.example.core.service.user.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 6:57 PM
 */
@Service
public abstract class AbstractUserServiceImpl<T extends User> implements AbstractUserService<T> {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Override
    public T getUserById(Long userId) {
        assertUserId(userId);
        return getUserRepository().getOne(userId);
    }

    // Abstract methods
    protected abstract T createNewInstance();

    protected abstract AbstractUserRepository<T> getUserRepository();


    // Utility methods

    private static void assertUserId(Long userId) {
        Assert.notNull(userId, "Id should not be null");
    }

}