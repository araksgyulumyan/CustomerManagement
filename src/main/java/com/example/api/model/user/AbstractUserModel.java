package com.example.api.model.user;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:44 PM
 */

public abstract class AbstractUserModel implements Serializable {
    private static final long serialVersionUID = 3225967404144212994L;

    // Properties
    @NotNull
    private String email;

    @NotNull
    private String password;

    private List<String> errors;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public AbstractUserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AbstractUserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<String> getErrors() {
        return errors;
    }

    public AbstractUserModel setErrors(List<String> errors) {
        this.errors = errors;
        return this;
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
        AbstractUserModel rhs = (AbstractUserModel) obj;
        return new EqualsBuilder()
                .append(this.email, rhs.email)
                .append(this.password, rhs.password)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(email)
                .append(password)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("email", email)
                .append("password", password)
                .toString();
    }
}
