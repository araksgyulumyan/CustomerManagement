package com.example.core.repository.customer;

import com.example.core.entity.user.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 7:21 PM
 */
@Repository
public interface CustomerRepository{
    List<Customer> getLimitedCustomers(Integer limit, Integer offset);

}
