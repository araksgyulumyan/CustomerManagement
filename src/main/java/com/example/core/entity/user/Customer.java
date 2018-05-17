package com.example.core.entity.user;

import com.example.core.enums.UserRole;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 4:59 PM
 */
@Entity
@Table(name = "customer")
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

    private static final long serialVersionUID = 3210175392787115313L;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Customer rhs = (Customer) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.firstName, rhs.firstName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(firstName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("firstName", firstName)
                .toString();
    }
}
