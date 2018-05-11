package com.example.core.entity;

import com.example.core.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 4:59 PM
 */

@Entity(name = "Customer")
@DiscriminatorValue("Customer")
public class Customer extends User {

    // Properties
    @Column(name = "firstName", nullable = false)
    private String firstName;

    // Constructor
    public Customer() {
        this.setUserRole(UserRole.CUSTOMER);
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
