package com.example.api.facade.customer.impl;

import com.example.api.facade.customer.CustomerFacade;
import com.example.api.model.request.customer.CustomerRequestModel;
import com.example.api.model.response.common.ErrorType;
import com.example.api.model.response.customer.CustomerResponseModel;
import com.example.core.dto.CustomerDto;
import com.example.core.entity.user.Customer;
import com.example.core.service.customer.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 6/5/18
 * Time - 7:02 PM
 */

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerFacadeImpl.class);

    @Override
    public CustomerResponseModel createCustomer(CustomerRequestModel customerRequestModel) {
        Assert.notNull(customerRequestModel, "Request model should not be null");
        final CustomerResponseModel responseModel = new CustomerResponseModel();
        validateRequest(customerRequestModel, responseModel);
        if (responseModel.hasErrors()) {
            return responseModel;
        }
        final Customer customer = customerService.createCustomer(customerRequestModel.getEmail(), toDto(customerRequestModel));
        return convertToCustomerResponseModel(customer, responseModel);
    }

    @Override
    public CustomerResponseModel updateCustomer(Long customerId, CustomerRequestModel customerRequestModel) {
        Assert.notNull(customerRequestModel, "Request model should not be null");
        final CustomerResponseModel responseModel = getCustomerById(customerId);
        validateRequest(customerRequestModel, responseModel);
        if (responseModel.hasErrors()) {
            return responseModel;
        }
        final Customer customer = customerService.updateCustomer(customerId, toDto(customerRequestModel));
        return convertToCustomerResponseModel(customer, responseModel);
    }

    @Override
    public List<CustomerResponseModel> getLimitedCustomers(Integer limit, Integer offset) {
        List<Customer> customers = customerService.getLimitedCustomers(limit, offset);
        List<CustomerResponseModel> customerResponseModels = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponseModels.add(createCustomerResponseModel(customer));
        }
        return customerResponseModels;
//        return customers.stream().map(this::createCustomerResponseModel).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseModel getCustomerById(Long customerId) {
        Assert.isNull(customerId, "Customer id should not be null");
        return createCustomerResponseModel(customerService.getCustomerById(customerId));
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Assert.isNull(customerId, "Customer id should not be null");
        customerService.removeUserById(customerId);
    }

    // Utility methods
    private CustomerResponseModel convertToCustomerResponseModel(final Customer customer, final CustomerResponseModel customerResponseModel) {
        customerResponseModel.setId(customer.getId());
        customerResponseModel.setEmail(customer.getEmail());
        customerResponseModel.setEmail(customer.getFirstName());
        return customerResponseModel;
    }

    private CustomerResponseModel createCustomerResponseModel(final Customer customer) {
        CustomerResponseModel customerResponseModel = new CustomerResponseModel();
        customerResponseModel.setEmail(customer.getEmail());
        customerResponseModel.setFirstName(customer.getFirstName());
        return customerResponseModel;
    }

    private static void validateRequest(final CustomerRequestModel customerRequestModel, final CustomerResponseModel responseModel) {
        if (StringUtils.isEmpty(customerRequestModel.getEmail())) {
            responseModel.getErrors().add(ErrorType.CUSTOMER_INVALID_EMAIL);
        }
        if (StringUtils.isEmpty(customerRequestModel.getPassword())) {
            responseModel.getErrors().add(ErrorType.CUSTOMER_INVALID_PASSWORD);
        }
        if (StringUtils.isEmpty(customerRequestModel.getFirstName())) {
            responseModel.getErrors().add(ErrorType.CUSTOMER_INVALID_FIRST_NAME);
        }
    }

    private CustomerDto toDto(CustomerRequestModel customerRequestModel) {
        return new CustomerDto()
                .setPassword(customerRequestModel.getPassword())
                .setFirstName(customerRequestModel.getEmail());
    }

}
