package com.example.core.entity;

import com.example.core.enums.UserRole;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 3:21 PM
 */

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type")

public abstract class User implements Serializable {

    // Properties
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "type", nullable = false, insertable = false, updatable = false)
    private String type;

    @Column(name = "role", nullable = false, insertable = false, updatable = false)
    private UserRole userRole;

    // Properties getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
