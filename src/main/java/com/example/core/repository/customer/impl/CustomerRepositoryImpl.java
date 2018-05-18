package com.example.core.repository.customer.impl;

import com.example.core.entity.user.Customer;
import com.example.core.repository.customer.CustomCustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 3:10 PM
 */
public class CustomerRepositoryImpl implements CustomCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getLimitedUsers(Integer limit, Integer offset) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder
                .createQuery(Customer.class);

        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(limit);
        return typedQuery.getResultList();
    }
}
