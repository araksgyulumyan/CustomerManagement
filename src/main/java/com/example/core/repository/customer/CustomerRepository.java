package com.example.core.repository.customer;

import com.example.core.entity.user.Customer;
import com.example.core.repository.user.AbstractUserRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 7:21 PM
 */
@Repository
public interface CustomerRepository extends AbstractUserRepository<Customer>, CustomCustomerRepository {
}
