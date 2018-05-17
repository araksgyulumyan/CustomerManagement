package com.example.api.model.customer;

import com.example.api.model.user.AbstractUserModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:47 PM
 */
public class CustomerModel extends AbstractUserModel {

    private static final long serialVersionUID = 1642165484706266683L;

    @NotNull
    private String firstName;

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
        CustomerModel rhs = (CustomerModel) obj;
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
