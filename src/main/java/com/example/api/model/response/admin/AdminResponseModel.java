package com.example.api.model.response.admin;

import com.example.api.model.response.AbstractResponseModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by araksgyulumyan
 * Date - 5/18/18
 * Time - 4:48 PM
 */

public class AdminResponseModel extends AbstractResponseModel {

    private static final long serialVersionUID = 8536156015183054929L;

    // Properties
    private Long id;

    private String email;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                .appendSuper(super.equals(obj))
                .append(this.id, rhs.id)
                .append(this.email, rhs.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(id)
                .append(email)
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("id", id)
                .append("email", email)
                .toString();
    }
}
