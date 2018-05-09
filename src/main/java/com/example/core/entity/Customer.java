package com.example.core.entity;

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

    @Column(name = "firstName", nullable = false)
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
