package com.example.core.service.customer;

import com.example.core.dto.AbstractUserDto;
import com.example.core.dto.CustomerDto;
import com.example.core.entity.Customer;
import com.example.core.enums.UserRole;
import com.example.core.service.user.AbstractUserService;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 8:55 PM
 */
public interface CustomerService extends AbstractUserService<Customer> {

    Customer createCustomer(final AbstractUserDto<Customer> abstractUserDto, final CustomerDto customerDto, final UserRole userRole);

    Customer updateCustomer(final Long userId, final Long customerId, final AbstractUserDto<Customer> abstractUserDto, final CustomerDto customerDto, final UserRole userRole);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);


}
