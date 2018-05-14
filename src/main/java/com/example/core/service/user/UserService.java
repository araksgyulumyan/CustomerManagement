package com.example.core.service.user;

import com.example.core.entity.User;

/**
 * Created by araksgyulumyan
 * Date - 5/14/18
 * Time - 9:13 PM
 */
public interface UserService {
    User getUserByEmail(final String email);
}
