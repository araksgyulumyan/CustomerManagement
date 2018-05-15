package com.example.core.dto;

import com.example.core.entity.Customer;

import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 7:54 PM
 */
public class CustomerDto extends AbstractUserDto<Customer> implements Serializable{

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
        super.updateDomainModelProperties(customer);
        customer.setFirstName(this.getFirstName());
    }
}
