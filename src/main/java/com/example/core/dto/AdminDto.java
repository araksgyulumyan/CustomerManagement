package com.example.core.dto;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 7:59 PM
 */
public class AdminDto {

    private static final long serialVersionUID = -8165746313249328764L;

    // Properties
    private String password;

    // Getters and Setters
    public String getPassword() {
        return password;
    }

    public AdminDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
