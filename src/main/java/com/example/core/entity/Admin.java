package com.example.core.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 5:08 PM
 */

@Entity(name = "Admin")
@DiscriminatorValue("Admin")
public class Admin extends User {
}
