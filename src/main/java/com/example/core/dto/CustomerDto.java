package com.example.core.dto;

import com.example.core.entity.Customer;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 7:54 PM
 */
public class CustomerDto extends AbstractUserDto<Customer> {

    private static final long serialVersionUID = 987278176273977886L;

    // Properties
    private String firstName;

    // Getters and Setters
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
