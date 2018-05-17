package com.example.api.facade.user;

import com.example.api.model.user.AbstractUserModel;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:37 PM
 */
public interface AbstractUserFacade<T extends AbstractUserModel> {

    T create(final String email, final T userModel);

    T update(final Long userId, final T userModel);

    void deleteUser(final Long userId);

}
