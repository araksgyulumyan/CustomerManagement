package com.example.api.model.response.admin;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/18/18
 * Time - 4:48 PM
 */

public class AdminResponseModel implements Serializable {

    private static final long serialVersionUID = 8536156015183054929L;

    // Properties
    @NotNull
    private String email;

    private List<String> errors;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public AdminResponseModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
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
        AdminResponseModel rhs = (AdminResponseModel) obj;
        return new EqualsBuilder()
                .append(this.email, rhs.email)
                .append(this.errors, rhs.errors)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(email)
                .append(errors)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("email", email)
                .append("errors", errors)
                .toString();
    }
}
