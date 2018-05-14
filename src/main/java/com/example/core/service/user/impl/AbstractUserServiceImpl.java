package com.example.core.service.user.impl;

import com.example.core.dto.AbstractUserDto;
import com.example.core.entity.User;
import com.example.core.repository.user.AbstractUserRepository;
import com.example.core.service.user.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 6:57 PM
 */

public abstract class AbstractUserServiceImpl<T extends User> implements AbstractUserService<T> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public T createUser(String email, AbstractUserDto<T> userDto) {
        checkUserExistenceForEmail(getUserRepository().findByEmail(email));
        final String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        T user = createNewInstance();
        userDto.updateDomainModelProperties(user);
        user.setPassword(encodedPassword);
        user = getUserRepository().save(user);
        return user;
    }

    @Override
    public T updateUser(Long userId, AbstractUserDto<T> userDto) {
        final String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        T user = getUserById(userId);
        userDto.updateDomainModelProperties(user);
        user.setPassword(encodedPassword);
        user = getUserRepository().save(user);
        return user;
    }

    @Override
    public T getUserById(Long userId) {
        assertUserId(userId);
        return getUserRepository().getOne(userId);
    }

    @Override
    public T getUserByEmail(String email) {
        assertEmail(email);
        if (getUserRepository().findByEmail(email) == null) {
            //todo
            throw new NullPointerException("User is not found");
        }
        return getUserRepository().findByEmail(email);
    }

    // Abstract methods
    protected abstract T createNewInstance();

    protected abstract AbstractUserRepository<T> getUserRepository();


    // Utility methods
    private static void checkUserExistenceForEmail(User user) {
        if (user != null) {
            throw new RuntimeException("Email is already taken");
        }
    }

    private static void assertUserId(Long userId) {
        Assert.notNull(userId, "Id should not be null");
    }

    private static void assertEmail(String email) {
        Assert.hasText(email, "Email should not be null");
    }
}