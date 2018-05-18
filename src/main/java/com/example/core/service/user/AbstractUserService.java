package com.example.core.service.user;

import com.example.core.entity.user.User;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 3:52 PM
 */
public interface AbstractUserService<T extends User> {

    void removeUserById(final Long id);

    T getUserById(final Long id);

}
