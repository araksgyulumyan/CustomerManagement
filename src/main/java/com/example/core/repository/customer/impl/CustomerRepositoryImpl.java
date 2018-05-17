package com.example.core.repository.customer.impl;

import com.example.core.entity.user.Customer;
import com.example.core.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 3:10 PM
 */

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getLimitedCustomers(Integer limit, Integer offset) {
        int pageNumber = 1;
        int pageSize = 10;

        // creating criteriaBuilder  object for creating criteriaQuery
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // creating criteriaQuery object with Long type for count
        CriteriaQuery<Long> countQuery = criteriaBuilder
                .createQuery(Long.class);

        // building query for selecting count of elements -> SELECT count(*) FROM Customer
        countQuery.select(criteriaBuilder
                .count(countQuery.from(Customer.class)));

        // executing query and getting the result
        Long count = entityManager.createQuery(countQuery)
                .getSingleResult();

        // creating criteriaQuery object with Customer List type for customers
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder
                .createQuery(Customer.class);

        // building query for selecting all customers -> SELECT * FROM Customer
        CriteriaQuery<Customer> select = criteriaQuery.select(criteriaQuery.from(Customer.class));

        // executing query and getting the result as TypedQuery object with Typed List of elements
        TypedQuery<Customer> typedQuery = entityManager.createQuery(select);
        List<Customer> customers = new ArrayList<>();

        try {
            while (offset > 0 && offset < count.intValue()) {
                typedQuery.setFirstResult(offset - 1); // sets position for the first result -> where to start
                typedQuery.setMaxResults(limit); // sets max number of results -> limits number of elements
                customers = typedQuery.getResultList();
                offset += limit;
            }
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Offset must be greater than 0");
        }
        return customers;
    }
}
