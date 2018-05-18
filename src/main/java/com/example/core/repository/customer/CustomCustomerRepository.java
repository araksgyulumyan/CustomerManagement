package com.example.core.repository.customer;

import com.example.core.entity.user.Customer;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 10:42 PM
 */
public interface CustomCustomerRepository {

    List<Customer> getLimitedUsers(final Integer limit, final Integer offset);

}
