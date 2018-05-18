package com.example.core.dto;

import com.example.core.entity.user.Customer;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 7:54 PM
 */
public class CustomerDto {

    private static final long serialVersionUID = 987278176273977886L;

    // Properties
    private String password;

    private String firstName;

    // Getters and Setters
    public String getPassword() {
        return password;
    }

    public CustomerDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    // Utility methods
    public void updateDomainModelProperties(final Customer customer) {
        customer.setFirstName(this.getFirstName());
    }
}
