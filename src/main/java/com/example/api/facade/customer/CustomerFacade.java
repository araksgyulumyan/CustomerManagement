package com.example.api.facade.customer;

import com.example.api.model.request.customer.CustomerRequestModel;
import com.example.api.model.response.customer.CustomerResponseModel;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 6/5/18
 * Time - 5:27 PM
 */
public interface CustomerFacade {

    CustomerResponseModel createCustomer(final CustomerRequestModel customerRequestModel);

    CustomerResponseModel updateCustomer(final Long customerId, final CustomerRequestModel customerRequestModel);

    List<CustomerResponseModel> getLimitedCustomers(final Integer limit, final Integer offset);

    CustomerResponseModel getCustomerById(final Long customerId);

    void deleteCustomer(final Long customerId);

}
