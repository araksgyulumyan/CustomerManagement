package com.example.core.service.user;

import com.example.core.dto.AbstractUserDto;
import com.example.core.entity.User;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 3:52 PM
 */
public interface AbstractUserService<T extends User> {

    T createUser(final String email, final AbstractUserDto<T> userDto);

    T updateUser(final Long userId, final AbstractUserDto<T> userDto);

    void removeUserById(final Long id);

    T getUserById(final Long id);

    T getUserByEmail(final String email);

}
