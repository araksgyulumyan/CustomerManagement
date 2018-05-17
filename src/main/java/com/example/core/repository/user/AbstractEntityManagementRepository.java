package com.example.core.repository.user;

import com.example.core.entity.user.User;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:14 PM
 */
public interface AbstractEntityManagementRepository<T extends User> {
    List<T> getLimitedUsers(final Integer limit, final Integer offset);

}
