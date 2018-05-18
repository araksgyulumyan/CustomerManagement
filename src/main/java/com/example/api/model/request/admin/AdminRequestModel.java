package com.example.api.model.request.admin;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:28 PM
 */

public class AdminRequestModel implements Serializable {

    private static final long serialVersionUID = -1887221277178794474L;

    // Properties
    @NotNull
    private String email;

    @NotNull
    private String password;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public AdminRequestModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        AdminRequestModel rhs = (AdminRequestModel) obj;
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
