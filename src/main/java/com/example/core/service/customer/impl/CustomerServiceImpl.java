package com.example.core.service.customer.impl;

import com.example.core.dto.AbstractUserDto;
import com.example.core.dto.CustomerDto;
import com.example.core.entity.Customer;
import com.example.core.entity.User;
import com.example.core.enums.UserRole;
import com.example.core.repository.customer.CustomerRepository;
import com.example.core.repository.user.AbstractUserRepository;
import com.example.core.service.customer.CustomerService;
import com.example.core.service.user.impl.AbstractUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 8:56 PM
 */

@Service
public class CustomerServiceImpl extends AbstractUserServiceImpl<Customer> implements CustomerService {

    public static final String ADMIN_PERMISSION = "Admin";

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
    public Customer createCustomer(AbstractUserDto<Customer> abstractUserDto, CustomerDto customerDto, UserRole userRole) {
        checkTypeOfUser(customerRepository.findByType(ADMIN_PERMISSION));
        createUser(abstractUserDto, userRole);
        Customer customer = createNewInstance();
        customerDto.updateDomainModelProperties(customer);
        customer = getUserRepository().save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Long userId, Long customerId, AbstractUserDto<Customer> abstractUserDto, CustomerDto customerDto, UserRole userRole) {
        checkTypeOfUser(customerRepository.findByType(ADMIN_PERMISSION));
        assertUserId(userId);
        assertCustomerId(customerId);
        updateUser(userId, abstractUserDto, userRole);
        Customer customer = getCustomerById(customerId);
        customerDto.updateDomainModelProperties(customer);
        customer = getUserRepository().save(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        checkTypeOfUser(customerRepository.findByType(ADMIN_PERMISSION));
        return getUserRepository().findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return getUserRepository().getOne(customerId);
    }

    @Override
    public void removeUserById(Long customerId) {
        checkTypeOfUser(customerRepository.findByType(ADMIN_PERMISSION));
        assertCustomerId(customerId);
        getUserRepository().deleteById(customerId);
    }

    // Utility methods

    private static void checkTypeOfUser(User user) {
        if (!user.getType().equals("Admin")) {
            throw new RuntimeException("You have no permission to make this action");
        }
    }

    private static void assertCustomerId(Long customerId) {
        Assert.notNull(customerId, "Customer Id should not be null");
    }

    private static void assertUserId(Long userId) {
        Assert.notNull(userId, "User Id should not be null");
    }


}
