package com.example.core.entity;

import com.example.core.enums.UserRole;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 5:08 PM
 */
//todo
@Entity(name = "Admin")
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    private static final long serialVersionUID = -7401350750545816139L;

    // Constructor
    public Admin() {
        this.setUserRole(UserRole.ADMIN);
    }
}
