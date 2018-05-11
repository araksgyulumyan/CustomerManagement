package com.example.core.dto;

import com.example.core.entity.User;

import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 6:49 PM
 */
public abstract class AbstractUserDto<T extends User> implements Serializable {

    // Properties
    private String password;

    // Getters and Setters
    public String getPassword() {
        return password;
    }

    public AbstractUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    // Utility methods
    public void updateDomainModelProperties(final User user) {
        user.setPassword(this.getPassword());
    }
}
