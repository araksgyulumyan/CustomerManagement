package com.example.core.service.customer;

import com.example.core.dto.CustomerDto;
import com.example.core.entity.Customer;
import com.example.core.service.user.AbstractUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 8:55 PM
 */
public interface CustomerService extends AbstractUserService<Customer> {

    Customer createCustomer(final String email, final CustomerDto customerDto);

    Customer updateCustomer(final Long customerId, final CustomerDto customerDto);

    Page<Customer> getAllCustomers(Pageable pageable);

    Customer getCustomerById(Long customerId);


}
