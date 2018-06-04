package com.example.api.model.response;

import com.example.api.model.response.common.ErrorType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by araksgyulumyan
 * Date - 6/4/18
 * Time - 9:41 PM
 */
public abstract class AbstractResponseModel implements Serializable {

    private static final long serialVersionUID = -7692096629199975136L;

    private List<ErrorType> errors;

    public List<ErrorType> getErrors() {
        if (Objects.isNull(errors)) {
            errors = new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<ErrorType> errors) {
        this.errors = errors;
    }

    public boolean hasErrors() {
        return getErrors().size() > 0;
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
        AbstractResponseModel rhs = (AbstractResponseModel) obj;
        return new EqualsBuilder()
                .append(this.getErrors(), rhs.getErrors())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getErrors())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("errors", errors)
                .toString();
    }

}
