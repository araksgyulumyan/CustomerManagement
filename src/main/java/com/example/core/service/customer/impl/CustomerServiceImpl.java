package com.example.core.service.customer.impl;

import com.example.core.dto.CustomerDto;
import com.example.core.entity.Customer;
import com.example.core.repository.customer.CustomerRepository;
import com.example.core.repository.user.AbstractUserRepository;
import com.example.core.service.customer.CustomerService;
import com.example.core.service.user.impl.AbstractUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 8:56 PM
 */

@Service
public class CustomerServiceImpl extends AbstractUserServiceImpl<Customer> implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Abstract Methods
    @Override
    protected Customer createNewInstance() {
        return new Customer();
    }

    @Override
    protected AbstractUserRepository<Customer> getUserRepository() {
        return customerRepository;
    }


    // Service methods
    @Override
    @Transactional
    public Customer createCustomer(String email, CustomerDto customerDto) {
        assertCustomerDto(customerDto);
        checkCustomerExistenceForEmail(getUserRepository().findByEmail(email));
        Customer customer = createNewInstance();
        customerDto.updateDomainModelProperties(customer);
        customer.setEmail(email);
        customer = getUserRepository().save(customer);
        return customer;
    }

    @Override
    @Transactional
    public Customer updateCustomer(Long customerId, CustomerDto customerDto) {
        assertCustomerId(customerId);
        assertCustomerDto(customerDto);
        Customer customer = getCustomerById(customerId);
        customerDto.updateDomainModelProperties(customer);
        customer = getUserRepository().save(customer);
        return customer;
    }

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return getUserRepository().findAll(pageable);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        assertCustomerId(customerId);
        if (getUserRepository().getOne(customerId) == null) {
            throw new NullPointerException("Customer is not found");
        }
        return getUserRepository().getOne(customerId);
    }

    @Override
    public void removeUserById(Long customerId) {
        assertCustomerId(customerId);
        getUserRepository().deleteById(customerId);
    }

    // Utility methods
    private static void checkCustomerExistenceForEmail(Customer customer) {
        if (customer != null) {
            throw new RuntimeException("Email is already taken");
        }
    }

    private static void assertCustomerDto(final CustomerDto customerDto) {
        Assert.notNull(customerDto, "User dto should not be null");
        Assert.hasText(customerDto.getFirstName(), "User dto first name should not be null");
        Assert.hasText(customerDto.getPassword(), "User dto password should not be null");
    }

    private static void assertCustomerId(Long customerId) {
        Assert.notNull(customerId, "Customer Id should not be null");
    }
}
